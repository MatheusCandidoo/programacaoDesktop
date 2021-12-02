/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import util.CreateFiles;
import util.SplitString;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import model.Person;

/**
 *
 * @author bruno
 */
public class PersonController {
    private TextController textController;
    private CreateFiles filesClass;
    private JComboBox personComboBox;
    private ArrayList<String> personList;
    private String newName;
    
    public PersonController() {
        filesClass = new CreateFiles(0);
        textController = new TextController(filesClass.getFile());
    }
    
    public PersonController(JComboBox personComboBox) {
        filesClass = new CreateFiles(0);
        textController = new TextController(filesClass.getFile());
        this.personComboBox = personComboBox;
        
        personList = textController.lerArquivo();
        
        personComboBox.setModel(new DefaultComboBoxModel(personList.toArray(new String[personList.size()])));
    }
    
    public void addPerson(String name) {
        personList = textController.lerArquivo();
        
        if (personList.size() == 0) {
            Person newPerson = new Person(name, 0);
       
            String newPersonString = newPerson.getName() + "/" + newPerson.getId();
        
            textController.escreverArquivo(newPersonString, true);
            return;
        } else {
            int lastIndex = personList.size();
            String lastName = personList.get(lastIndex - 1);
        
            String[] nameSplit = lastName.split("/");
            int lastNumber = Integer.parseInt(nameSplit[1]);
        
            Person newPerson = new Person(name, lastNumber + 1);
       
            String newPersonString = newPerson.getName() + "/" + newPerson.getId();
        
            textController.escreverArquivo(newPersonString, true);
            return;
        }
    }
    
    public void delete() {
        Integer index = null;
        SplitString arrayStringItem = new SplitString(personComboBox.getSelectedItem().toString());
        
        for (int i = 0; i < personList.size(); i++) {
            if (Integer.parseInt(personList.get(i).split("/")[1]) == Integer.parseInt(arrayStringItem.getSplit()[1].toString())) {
                index = i;
            }
        }
        
        if (index != null) {
            textController.escreverArquivo("", false);
            personList.remove(personList.get(index));
            
            for (String item : personList) {
                textController.escreverArquivo(item, true);
            }
        }
    }
    
    public void list(JList personJList) {
        ArrayList<String> personList = textController.lerArquivo();
        DefaultListModel listModel = new DefaultListModel();
        
        for (String item : personList) {
            listModel.addElement(item);
        }
        
        personJList.setModel(listModel);
    }
    
    public void update(String newName) {
        this.newName = newName;
        Integer index = null;
        Integer id = null;
        SplitString arrayStringItem = new SplitString(personComboBox.getSelectedItem().toString());
        
        for (int i = 0; i < personList.size(); i++) {
            if (Integer.parseInt(personList.get(i).split("/")[1]) == Integer.parseInt(arrayStringItem.getSplit()[1].toString())) {
                index = i;
                id = Integer.parseInt(personList.get(i).split("/")[1]);
            }
        }
        
        if (index != null) {
            textController.escreverArquivo("", false);
            String newValue = (newName + "/" + id);
            personList.set(index, newValue);
            
            for (String item : personList) {
                textController.escreverArquivo(item, true);
            }
        }
    }
}
