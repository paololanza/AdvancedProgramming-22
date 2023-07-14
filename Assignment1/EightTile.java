/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package com.mycompany.eightboard;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author paololanza
 */
public class EightTile extends JButton implements Serializable{
    
    public static final String PROP_LABEL = "labels";
    public static final String PROP_POSITION = "position";
    
    private Integer label;
    private final Integer position;
    
    private final VetoableChangeSupport vceListeners;
    
    private final PropertyChangeSupport propertySupport;
    
    public EightTile()
    {
        this.vceListeners = new VetoableChangeSupport(this);
        this.propertySupport = new PropertyChangeSupport(this);
        this.position = 0;
    }
    
    public EightTile(Integer position, Integer labels)
    {
        super();
        this.propertySupport = new PropertyChangeSupport(this);
        this.vceListeners = new VetoableChangeSupport(this);
        this.label = labels;
        this.position = position;
        this.buttonText();
        this.colorBG();
    }

    @Override
    public synchronized void addVetoableChangeListener(VetoableChangeListener listener) 
    {
        this.vceListeners.addVetoableChangeListener(listener);
    }
    
    @Override
    public synchronized void addPropertyChangeListener(PropertyChangeListener listener) 
    {
        if(this.propertySupport != null)
            this.propertySupport.addPropertyChangeListener(listener);
    }
    
    public Integer getLabels() {
        return this.label;
    }
    
    public Integer getPosition()
    {
        return this.position;
    }

    /*
    Function that set the tile when an operation is done. It takes as parameters
    an integer that represents the new value of the label and a boolean that 
    represents if the operation done required the veto of the EightController. 
    */
    public void setLabel(Integer value, boolean veto){
        if(veto)
        {
            Integer oldValue = this.label;
            try {
                System.out.println("ET" + this.position + ": Waiting the validation of the operation...");
                this.vceListeners.fireVetoableChange(PROP_POSITION, this.position, true);

                this.label = value;
                this.colorBG();
                this.buttonText();
                System.out.println("ET" + this.position + ": Tile changed!");

                System.out.println("ET" + this.position + ": Send a property change event to the board... ");
                this.propertySupport.firePropertyChange("hole", false, oldValue);

            }
            catch(PropertyVetoException e)
            {
                Timer timer = new Timer(500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        colorBG();
                    }
                });
                timer.setRepeats(false);
                this.setBackground(Color.RED);
                timer.start();
                System.out.println(e.getMessage());
            }
        }
        else
        {
            this.label = value;
            this.colorBG();
            this.buttonText();

            System.out.println("ET" + this.position + ": Tile changed!");           
        }
    }
    
    private void buttonText()
    {
        if(this.label != 9)
            this.setText(this.label.toString());
        else
            this.setText(" ");
    }
    
    private void colorBG()
    {
        if(this.label == 9)
            this.setBackground(Color.LIGHT_GRAY);
        else 
            if(Objects.equals(this.label, this.position))
            {
                this.setBackground(Color.GREEN);
                this.setForeground(Color.BLACK);
            }
            else
            {
                this.setBackground(Color.YELLOW);
            }
    }   
}
