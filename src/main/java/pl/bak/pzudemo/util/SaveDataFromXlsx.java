package pl.bak.pzudemo.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import pl.bak.pzudemo.domain.dao.PolicyRepository;
import pl.bak.pzudemo.model.Policy;

import java.io.IOException;
import java.math.BigDecimal;

@Component
public class SaveDataFromXlsx {
    private final PolicyRepository policyRepository;

    public SaveDataFromXlsx(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public void save(String path) throws IOException {
        Workbook workbook = new XSSFWorkbook(path);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() != 0) {
                Policy policy = new Policy();
                for (Cell cell : row) {
                    switch (cell.getColumnIndex()) {
                        case 1:
                            policy.setPolicyType(cell.getStringCellValue());
                            break;
                        case 2:
                            policy.setSumInsured(BigDecimal.valueOf(cell.getNumericCellValue()));
                            break;
                        case 3:
                            policy.setInsuredPersonName(cell.getStringCellValue());
                            break;
                        case 4:
                            policy.setInsuredPersonLastName(cell.getStringCellValue());
                            break;
                        case 5:
                            policy.setItemInsured(cell.getStringCellValue());
                    }
                }
                policyRepository.save(policy);
            }
        }
        workbook.close();
    }
}
