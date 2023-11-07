package com.example.demo.service;

import com.example.demo.model.Bike;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Exceluplod {
    public static boolean isValidExcelFile(MultipartFile file)
    {
        return Objects.equals(file.getContentType(),"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    public static List<Bike> getCustomersDataFromExcel(InputStream inputStream){
        List<Bike> bikes = new ArrayList<>();
        try
        {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("bikes");
                int rowIndex =0;
                Iterator<Row> iterator = sheet.iterator();
                while (iterator.hasNext())
                {
                    Row row = iterator.next();
                    if (rowIndex == 0)
                    {
                        rowIndex++;
                        continue;
                    }
                    Iterator<Cell> cellIterator = row.iterator();
                    int cellIndex = 0;
                    Bike bike = new Bike();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cellIndex) {
                            case 0 -> bike.setModel_id((int) cell.getNumericCellValue());
                            case 1 -> bike.setMake_id((int) cell.getNumericCellValue());
                            case 2 -> bike.setMake_name(cell.getStringCellValue());
                            case 3 -> bike.setModel_name(cell.getStringCellValue());
                            case 4 -> bike.setVariance(cell.getStringCellValue());
                            case 5 -> bike.setWheels((int) cell.getNumericCellValue());
                            case 6 -> bike.setOil(cell.getStringCellValue());
                            case 7 -> bike.setCc((int) cell.getNumericCellValue());
                            case 8 -> bike.setSeat((int) cell.getNumericCellValue());
                            case 10 -> bike.setDriver((int) cell.getNumericCellValue());
                            case 11 -> bike.setVt_id((int) cell.getNumericCellValue());
                            case 12 -> bike.setVt_name(cell.getStringCellValue());

                            default -> {
                            }
                        }
                        cellIndex++;
                    }
                    bikes.add(bike);
            }
        }
        catch (IOException e) {
            e.getStackTrace();
        }




        return bikes;
    }

}
