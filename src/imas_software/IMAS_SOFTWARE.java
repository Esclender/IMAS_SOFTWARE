/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package imas_software;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Esclender
 */
public class IMAS_SOFTWARE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public String LeerExcel() throws FileNotFoundException, IOException{
           FileInputStream fileIn = new FileInputStream("D:\\\\PRUEBAXLS.xlsx");
           XSSFWorkbook wb = new XSSFWorkbook(fileIn);
           XSSFSheet sheet = wb.getSheetAt(0);
    
           int numero_filas = sheet.getLastRowNum();
           String tabla = "";
            
           for(int i = 0; i < numero_filas; i++){
                int columnas = sheet.getRow(i).getLastCellNum();
                
                for(int j = 0; j < columnas; j++){
                    XSSFCell celda = sheet.getRow(i).getCell(j);
                    if((j + 1) == columnas){
                        tabla += celda + "\n";
                    }else{
                        tabla += celda + "    ";
                    }
                }
           }
           
           return tabla;
           
    }
    
}
