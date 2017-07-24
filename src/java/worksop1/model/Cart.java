/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksop1.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author nirav
 */
//Session scope - CDI
@SessionScoped
public class Cart implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private List<Item> items = new LinkedList<>();
    
    public void add(Item item){
        items.add(item);
    }
    
    public List<Item> getAllItems(){
        return items;
    }
    
    public void setItems(List<Item> content){
        this.items = content;
    }
            
    
}
