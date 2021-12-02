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
import model.Item;

/**
 *
 * @author bruno
 */
public class ItemController {
    private TextController textController;
    private CreateFiles filesClass;
    private JComboBox itemComboBox;
    private ArrayList<String> itemList;
    private String newName;
    
    public ItemController() {
        filesClass = new CreateFiles(1);
        textController = new TextController(filesClass.getFile());
    }
    
    public ItemController(JComboBox itemComboBox) {
        filesClass = new CreateFiles(1);
        textController = new TextController(filesClass.getFile());
        this.itemComboBox = itemComboBox;
        
        itemList = textController.lerArquivo();
        
        itemComboBox.setModel(new DefaultComboBoxModel(itemList.toArray(new String[itemList.size()])));
    }
    
    public void addItem(String name) {
        ArrayList<String> lerArquivo = textController.lerArquivo();
        
        if (lerArquivo.size() == 0) {
            Item newItem = new Item(name, 0);
        
            String newItemString = newItem.getName() + "/" + newItem.getId();
            
            textController.escreverArquivo(newItemString, true);
            return;
            
        } else {
            String lastName = lerArquivo.get(lerArquivo.size() - 1);
        
            String[] nameSplit = lastName.split("/");
            int lastNumber = Integer.parseInt(nameSplit[1]);
        
            Item newItem = new Item(name, lastNumber + 1);
        
            String newItemString = newItem.getName() + "/" + newItem.getId();
        
            textController.escreverArquivo(newItemString, true);
            return;
        }
    }
    
    public void list(JList itemJList) {
        ArrayList<String> itemList = textController.lerArquivo();
        DefaultListModel listModel = new DefaultListModel();
        
        for (String item : itemList) {
            listModel.addElement(item);
        }
        
        itemJList.setModel(listModel);
    }
    
    public void update(String newName) {
        this.newName = newName;
        Integer index = null;
        Integer id = null;
        SplitString arrayStringItem = new SplitString(itemComboBox.getSelectedItem().toString());
        
        for (int i = 0; i < itemList.size(); i++) {
            if (Integer.parseInt(itemList.get(i).split("/")[1]) == Integer.parseInt(arrayStringItem.getSplit()[1].toString())) {
                index = i;
                id = Integer.parseInt(itemList.get(i).split("/")[1]);
            }
        }
        
        if (index != null) {
            textController.escreverArquivo("", false);
            String newValue = (newName + "/" + id);
            itemList.set(index, newValue);
            
            for (String item : itemList) {
                textController.escreverArquivo(item, true);
            }
        }
    }
    
    public void delete() {
        Integer index = null;
        SplitString arrayStringItem = new SplitString(itemComboBox.getSelectedItem().toString());
        
        for (int i = 0; i < itemList.size(); i++) {
            if (Integer.parseInt(itemList.get(i).split("/")[1]) == Integer.parseInt(arrayStringItem.getSplit()[1].toString())) {
                index = i;
            }
        }
        
        if (index != null) {
            textController.escreverArquivo("", false);
            itemList.remove(itemList.get(index));
            
            for (String item : itemList) {
                textController.escreverArquivo(item, true);
            }
        }
    }
}
