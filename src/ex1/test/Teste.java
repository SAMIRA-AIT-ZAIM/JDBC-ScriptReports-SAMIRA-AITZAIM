/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1.test;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import ex1.entitie.DevData;
import ex1.rapport.DevDataRapp;

/**
 *
 * @author salam
 */

public class Teste {
    public static void main(String[] args) {
        DevData dev1 = new DevData("ALAMI","lundi",1);
        DevData dev2 = new DevData("WAFI","lundi",2);
        DevData dev3 = new DevData("SALAMI","Mardi",9);
        DevData dev4 = new DevData("SAFI","Mardi",2);
        DevData dev5 = new DevData("ALAMI","Mardi",2);
        DevData dev6 = new DevData("SEBIHI","Mercredi",2);
        DevData dev7 = new DevData("WAFI","Jeudi",3);
        DevData dev8 = new DevData("ALAOUI","Vendredi",9);
        DevData dev9 = new DevData("SAFI","Vendredi",3);
        DevData dev10 = new DevData("SEBIHI","Vendredi",4);
        
        
        DevDataRapp data = new DevDataRapp();
        data.create(dev1);
        data.create(dev2);
        data.create(dev3);
        data.create(dev4);
        data.create(dev5);
        data.create(dev6);
        data.create(dev7);
        data.create(dev8);
        data.create(dev9);
        data.create(dev10);
       
        
        
        
       
    
        
        
        
        
             
        
    }
    
    
}
