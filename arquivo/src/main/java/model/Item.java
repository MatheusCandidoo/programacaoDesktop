/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author bruno
 */
public class Item {
    
    private Integer id;
    private String name;
    
    public Item(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId() {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
