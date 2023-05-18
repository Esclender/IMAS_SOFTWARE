/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class Excel_functions {
        public Stack LeerExcel() throws FileNotFoundException, IOException{
           FileInputStream fileIn = new FileInputStream("D:\\\\PRUEBAXLSX.xlsx");
           XSSFWorkbook wb = new XSSFWorkbook(fileIn);
           XSSFSheet sheet = wb.getSheetAt(0);
    
           int numero_filas = sheet.getLastRowNum();
           Stack tabla =new Stack ();
           
            for(int i = 1; i < numero_filas; i++){
                XSSFRow rows = sheet.getRow(i);
                Stack newRow = new Stack();
                if(rows != null){
                    short columnas = rows.getLastCellNum();
                    for(int j = 0; j < columnas; j++){
                        XSSFCell celda = sheet.getRow(i).getCell(j);
                        

                        if(((j + 1) != columnas) & celda != null ){
                            if(celda.toString() != ""){
                                newRow.push(celda.toString());
                            }
                            
                        }else{
                            if(celda != null ){
                                if(celda.toString() != ""){
                                    newRow.push(celda + "\n");
                                }
                            }
                            
                        }
                    
                    }
                }
                
                tabla.push(newRow);
           }
           
            System.out.println("Tabla" + tabla );
           return tabla;
           
    }
    
    public Stack LeerHeaders() throws FileNotFoundException, IOException{
           FileInputStream fileIn = new FileInputStream("D:\\\\PRUEBAXLSX.xlsx");
           XSSFWorkbook wb = new XSSFWorkbook(fileIn);
           XSSFSheet sheet = wb.getSheetAt(0);
    
           int numero_filas = sheet.getDefaultColumnWidth();
           Stack<String> tablaHeaders = new Stack<>();
            
           for(int i = 0; i < numero_filas; i++){
                XSSFCell celda = sheet.getRow(0).getCell(i);
                
                if(celda != null){
                    if(celda.toString() != ""){
                        tablaHeaders.push(celda.toString());
                    }
                }
                
           } 
           System.out.println("Headers" + tablaHeaders);
           return tablaHeaders;
           
    }
}
