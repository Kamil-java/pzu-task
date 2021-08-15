package pl.bak.pzudemo.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.nio.file.*;

@Configuration
@EnableScheduling
public class MonitoringXlsxDirectory {
    private final SaveDataFromXlsx saveDataFromXlsx;

    public MonitoringXlsxDirectory(SaveDataFromXlsx saveDataFromXlsx) {
        this.saveDataFromXlsx = saveDataFromXlsx;
    }

    @Scheduled(cron = "@weekly")
    public boolean checkingIsUpdateIsRequired() throws IOException, InterruptedException {
        WatchService watchService
                = FileSystems.getDefault().newWatchService();

        String directoryPath = System.getProperty("user.dir") + "/xlsxFiles";
        Path path = Paths.get(directoryPath);

        path.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key;
        boolean refreshIsRequired = false;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                if (event.kind().equals(StandardWatchEventKinds.ENTRY_CREATE)) {
                    refreshIsRequired = true;
                    saveDataFromXlsx.save(directoryPath + "/" + event.context());
                }
            }
            key.reset();
        }
        return refreshIsRequired;
    }
}
