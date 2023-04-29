/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package imas_software;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Stack;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
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
    
    public Stack LeerExcel() throws FileNotFoundException, IOException{
           FileInputStream fileIn = new FileInputStream("D:\\\\PRUEBAXLS.xlsx");
           XSSFWorkbook wb = new XSSFWorkbook(fileIn);
           XSSFSheet sheet = wb.getSheetAt(0);
    
           int numero_filas = sheet.getLastRowNum();
           Stack tabla =new Stack ();
            
           for(int i = 1; i < numero_filas; i++){
                int columnas = sheet.getRow(i).getLastCellNum();
                Stack newRow = new Stack();
                
                for(int j = 0; j < columnas; j++){
                    XSSFCell celda = sheet.getRow(i).getCell(j);
                    
                    if((j + 1) == columnas){
                        newRow.push(celda + "\n");
                    }else{
                        newRow.push(celda.toString());
                    }
                    
                }
                tabla.push(newRow);
           }
           
           return tabla;
           
    }
    
    public Stack LeerHeaders() throws FileNotFoundException, IOException{
           FileInputStream fileIn = new FileInputStream("D:\\\\PRUEBAXLS.xlsx");
           XSSFWorkbook wb = new XSSFWorkbook(fileIn);
           XSSFSheet sheet = wb.getSheetAt(0);
    
           int numero_filas = sheet.getDefaultColumnWidth();
           Stack<String> tablaHeaders = new Stack<String>();
            
           for(int i = 0; i < numero_filas; i++){
                XSSFCell celda = sheet.getRow(0).getCell(i);
                
                if(celda != null){
                    tablaHeaders.push(celda.toString());
                }
                
           } 
           
           return tablaHeaders;
           
    }
    
}
