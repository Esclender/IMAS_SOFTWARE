/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imas_software;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author Esclender
 */
public class c2_attributes {
    public String name;
    public Stack<Stack> amounts = new Stack();
    
    public void setAmount(String clothe){
        Stack actual_names = new Stack();
        for(Stack d: amounts){
            actual_names.push(d.get(0));
        }
         
        if(amounts.size() != 0 ){
            for(int i = 0; i < amounts.size(); i++){
                Stack d = amounts.get(i);
                if(d.get(0).equals( clothe.toString())){
                    int nuevoValor = (int) d.get(1) + 1;
                    d.pop();

                    d.push(nuevoValor);
                }else{
                    if(!actual_names.contains(clothe.toString() )){
                        Stack nuevoArr = new Stack();
                        nuevoArr.push(clothe);
                        nuevoArr.push(1);

                        amounts.push(nuevoArr);
                        break;
                    }
                }
            }
        }else{
            Stack nuevoArr = new Stack();
            nuevoArr.push(clothe);
            nuevoArr.push(1);
            
            amounts.push(nuevoArr);
            
        }
    }
}
