package com.odc.FreeTirage.model;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PostulantExcelImport {
    public List<Postulants> excelImport(MultipartFile file) {
        List <Postulants> postulantList = new ArrayList<>();


        String nom="";
        String prenom="";
        String numero="";
        String email="";


        //String excelFilePath = "C:\\Users\\mkkeita\\Desktop\\projects\\apiFreeTirag\\file1.xlsx";

        long start = System.currentTimeMillis();//l'heure de debut

        try {
            //FileInputStream inputStrean = new FileInputStream(file.getInputStream());
            Workbook workbook = new XSSFWorkbook(file.getInputStream());

            Sheet firstSheet=workbook.getSheetAt(0);
            Iterator<Row> rowIterator=firstSheet.iterator();

            rowIterator.next();

            while (rowIterator.hasNext()){

                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator=nextRow.cellIterator();

                while (cellIterator.hasNext()){
                    Cell nextCell=cellIterator.next();

                    int columnIndex=nextCell.getColumnIndex();
                    switch (columnIndex){
                        case 0:
                            nom=nextCell.getStringCellValue();
                            System.out.println(nom);
                            break;
                        case 1:
                            prenom=nextCell.getStringCellValue();
                            System.out.println(prenom);
                            break;
                        case 2:
                            numero=nextCell.getStringCellValue();
                            System.out.println(numero);
                            break;
                        case 3:
                            email=nextCell.getStringCellValue();
                            System.out.println(email);
                            break;
                    }
                }
                postulantList.add(new Postulants(nom, prenom, numero, email));


            }
            workbook.close();
            long end = System.currentTimeMillis();//l'heure de fin
            System.out.printf("Import done in %d ms\n", (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  postulantList;
    }
}
