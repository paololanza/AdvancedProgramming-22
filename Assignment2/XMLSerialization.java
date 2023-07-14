/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.xmlserialization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paololanza
 * 
 */
public class XMLSerialization {
    
    public XMLSerialization(){
     
    }
    
    /*
    For each object in the array it checks if it's serializable and then 
    compute the serialized string. After iterating all the items it creates
    a new file called "fileName".xml that will contain all the serialized objects.
    */
    public void serialize(Object[] arr, String fileName)
    {
        String buffer = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        
        for(Object obj : arr)
        {
            Class c = obj.getClass();
            
            //check if the class is serializable
            if(c.isAnnotationPresent(XMLable.class))
            {
                buffer += "<" + c.getSimpleName() + ">\n";
               
                
                Field[] fields = c.getDeclaredFields();
                for(Field field : fields)
                {
                    XMLfield annotation = field.getAnnotation(XMLfield.class);

                    String fieldname = "";
                    if(annotation.name().equals(""))
                    {
                        fieldname = field.getName();
                    }
                    else
                    {
                        fieldname = annotation.name();
                    }
                    
                    try {
                        //case in which the field is private
                        field.setAccessible(true);
                        
                        String value = (String) field.get(obj).toString();
                        
                        buffer += "<" + fieldname + " type=\"" + annotation.type() + "\">" + value + "</" + fieldname + ">\n";
                        
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    
                }
                
                buffer += "</" + c.getSimpleName() + ">\n";      
            }
            else
            {
                buffer += "<notXMLable />";
            }            
        }
        
        try
        {
            File outFile = new File (fileName + ".xml");
            if (!outFile.exists()) 
            {
                outFile.createNewFile();
            }

            FileWriter writer = new FileWriter(outFile.getAbsolutePath());
            writer.write(buffer);
            
            writer.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    /*
    In order to test the XMLSerialization object has been used the Student 
    class provided by the project and two classes Exam and Book that are 
    serializable and non-serializable respectively.       
    */
    public static void main(String[] args) {
        
        XMLSerialization XMLS = new XMLSerialization();
        
        Student s1 = new Student("Paolo", "Lanza", 26);
        Book b1 = new Book(1, "I promessi sposi", "Alessandro Manzoni");
        Exam e1 = new Exam("Advanced Programming", true, 100);
        Student s2 = new Student("Mario", "Rossi", 20);
        
        ArrayList<Object> array = new ArrayList();
        
        array.add(s1);
        array.add(b1);
        array.add(e1);
        array.add(s2);
        
        XMLS.serialize(array.toArray(), "test");
    }
}
