/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package com.mycompany.eightboard;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JLabel;

/**
 *
 * @author paololanza
 */
public class EightController extends JLabel implements PropertyChangeListener, VetoableChangeListener, Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "hole";
    
    //The controller in order to allow operations knows only the position of the hole
    private Integer hole;
    private HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
    
    public EightController() {
    }
    
    public EightController(Integer hole) {
        
        this.hole = hole;
        
        //create the hashtable that contains the adjacent positions
        this.hashMap.put(1, new ArrayList<>(Arrays.asList(2, 4)));
        this.hashMap.put(2, new ArrayList<>(Arrays.asList(1, 3, 5)));
        this.hashMap.put(3, new ArrayList<>(Arrays.asList(2, 6)));
        this.hashMap.put(4, new ArrayList<>(Arrays.asList(1, 5, 7)));
        this.hashMap.put(5, new ArrayList<>(Arrays.asList(2, 4, 6, 8)));
        this.hashMap.put(6, new ArrayList<>(Arrays.asList(3, 5, 9)));
        this.hashMap.put(7, new ArrayList<>(Arrays.asList(4, 8)));
        this.hashMap.put(8, new ArrayList<>(Arrays.asList(5, 7, 9)));
        this.hashMap.put(9, new ArrayList<>(Arrays.asList(6, 8)));
    }
    
    public Integer getHole() 
    {
        return this.hole;
    }

    /*
    vetoableChange function is called in order to have the permission to do 
    two main operations: the move and the flip. If the operation is not allowed 
    it throw a PropertyVetoException otherwise it change 
    */
    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException{
        if(evt.getPropertyName().equals("position"))
        {
            //take the old value
            Object oldValue = evt.getOldValue();

            //case in which the tiles are adjacent
            if(this.hashMap.get(this.hole).contains((Integer)oldValue))
            {
                //update the hole
                this.hole = (Integer)oldValue;
                this.setText("OK");
                System.out.println("EC: Operation approved!");
            }
            else
            {
                this.setText("KO");
                throw new PropertyVetoException("EC: The tiles are not adjacent", evt);
            }
        }
        else
        {
            if(evt.getPropertyName().equals("flip"))
            {
                if(this.hole != 9)
                    throw new PropertyVetoException("EC: The hole is not in position 9", evt);
                System.out.println("EC: Operation Approved!");
            }
            else
                throw new PropertyVetoException("EC: Operation not allowed!", evt);
        }
        
    }

    /*
    This function is performed when the restart operation is done and the 
    EightBoard fire the change. It's useful to set the hole in order to have 
    the hole updated.
    */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //takes new value
        Object newValue = evt.getNewValue();
        if(evt.getPropertyName().equals("hole"))
        {
            this.hole = (Integer)newValue;
        }
    }

}
