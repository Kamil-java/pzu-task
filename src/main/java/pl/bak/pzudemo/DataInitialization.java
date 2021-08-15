package pl.bak.pzudemo;

import org.springframework.stereotype.Component;
import pl.bak.pzudemo.util.SaveDataFromXlsx;

import javax.persistence.PrePersist;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class DataInitialization {
    private final SaveDataFromXlsx saveDataFromXlsx;

    public DataInitialization(SaveDataFromXlsx saveDataFromXlsx) {
        this.saveDataFromXlsx = saveDataFromXlsx;
        init();
    }

    @PrePersist
    private void init() {
        String directoryPath = System.getProperty("user.dir") + "/xlsxFiles";
        File[] listOfFiles = new File(directoryPath).listFiles();

        if (listOfFiles != null){
            for (File file : listOfFiles) {
                if (file.isFile()){
                    try {
                        saveDataFromXlsx.save(file.getAbsolutePath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
