/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author bruno
 */
public class SplitString {
    private String string;
    
    public SplitString(String string) {
        this.string = string;
    }
    
   public String[] getSplit() {
       String[] stringArray;
       return stringArray = string.split("/");
   }
   
    public String[] getSplit(String splitter) {
       String[] stringArray;
       return stringArray = string.split(splitter);
   }
}
