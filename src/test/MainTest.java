/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dal.Conexion;
import dao.ContactoDao;
import dao.ContactoDaoMySQL;
import dto.Contacto;
import factory.FactoryDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josec
 */
public class MainTest {
    
    public static void main(String[] args) {
        
        try {
            ContactoDao objDao = FactoryDao.getFactoryInstance().getNewContactoDao();
            
            Contacto obj = new Contacto();
            obj.setNombre("Maria la del Barrio");
            obj.setTelefono("7265842");
            
            int id = objDao.insert(obj);
            
            obj = objDao.get(id);
            
            System.out.println("Id: " + obj.getContactoId() + 
                    " | Nombre: " + obj.getNombre() + 
                    " | Telefono: " + obj.getTelefono());
                       
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        
    }
    
}
