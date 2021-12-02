/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import util.CreateFiles;
import util.SplitString;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import model.Category;

/**
 *
 * @author bruno
 */
public class CategoryController {
    public TextController textController;
    private CreateFiles filesClass;
    private JComboBox categoryComboBox;
    private ArrayList<String> categoryList;
    private String newName;
    
    public CategoryController() {
        filesClass = new CreateFiles(2);
        textController = new TextController(filesClass.getFile());
    }
    
    public CategoryController(JComboBox categoryComboBox) {
        filesClass = new CreateFiles(2);
        textController = new TextController(filesClass.getFile());
        this.categoryComboBox = categoryComboBox;
        
        categoryList = textController.lerArquivo();
        
        categoryComboBox.setModel(new DefaultComboBoxModel(categoryList.toArray(new String[categoryList.size()])));
    }
    
    public void list(JList categoryJList) {
        ArrayList<String> categoryList = textController.lerArquivo();
        DefaultListModel listModel = new DefaultListModel();
        
        for (String item : categoryList) {
            listModel.addElement(item);
        }
        
        categoryJList.setModel(listModel);
    }
    
    public void update(String newName) {
        this.newName = newName;
        Integer index = null;
        Integer id = null;
        SplitString arrayStringItem = new SplitString(categoryComboBox.getSelectedItem().toString());
        
        for (int i = 0; i < categoryList.size(); i++) {
            if (Integer.parseInt(categoryList.get(i).split("/")[1]) == Integer.parseInt(arrayStringItem.getSplit()[1])) {
                index = i;
                id = Integer.parseInt(categoryList.get(i).split("/")[1]);
            }
        }
        
        if (index != null) {
            textController.escreverArquivo("", false);
            String newValue = (newName + "/" + id);
            categoryList.set(index, newValue);
            
            for (String item : categoryList) {
                textController.escreverArquivo(item, true);
            }
        }
    }
    
    public void delete() {
        Integer index = null;
        SplitString arrayStringItem = new SplitString(categoryComboBox.getSelectedItem().toString());
        
        for (int i = 0; i < categoryList.size(); i++) {
            if (Integer.parseInt(categoryList.get(i).split("/")[1]) == Integer.parseInt(arrayStringItem.getSplit()[1].toString())) {
                index = i;
            }
        }
        
        if (index != null) {
            textController.escreverArquivo("", false);
            categoryList.remove(categoryList.get(index));
            
            for (String item : categoryList) {
                textController.escreverArquivo(item, true);
            }
        }
    }
    
    public void store(String name) {
        ArrayList<String> lerArquivo = textController.lerArquivo();
        
        if (lerArquivo.size() == 0) {
            Category newCategory = new Category(name, 0);
        
            String newCategoryString = newCategory.getName() + "/" + newCategory.getId();
        
            textController.escreverArquivo(newCategoryString, true);
            return;
            
        } else {
            int lastIndex = lerArquivo.size();
            String lastName = lerArquivo.get(lastIndex - 1);
        
            String[] nameSplit = lastName.split("/");
            int lastNumber = Integer.parseInt(nameSplit[1]);
        
            Category newCategory = new Category(name, lastNumber + 1);
        
            String newCategoryString = newCategory.getName() + "/" + newCategory.getId();
        
            textController.escreverArquivo(newCategoryString, true);
            return;
        }

    }
}
