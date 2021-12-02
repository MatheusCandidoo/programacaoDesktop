/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class CreateFiles {

    private File file;

    public CreateFiles(int option) {
        try {
            switch (option) {
                case 0:
                    file = new File("src/resources/person.txt");
                    break;
                case 1:
                    file = new File("src/resources/item.txt");
                    break;
                case 2:
                    file = new File("src/resources/category.txt");
                    break;
                default:
            }
            if(!file.exists())              
                file.createNewFile();
        } catch (Exception err) {
            System.err.println("Erro ao criar arquivo " + err);
        }
    }

    public File getFile() {
        return file;
    }

}
