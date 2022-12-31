/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halfacode.query;

import com.halfacode.entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ASUS
 */
public class DataQuery {
    EntityManagerFactory emf;
    EntityManager em;
    
    public DataQuery(){
        emf = Persistence.createEntityManagerFactory("Login_ExamplePU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        
    }
    public boolean loginControler(String username, String password){
         try {
                    Users user= em.createNamedQuery("Users.control", Users.class).setParameter("uname", username )
                                  .setParameter("password", password).getSingleResult();
                    if(user != null){
                        return true;
                    }
                    return false;
        } catch (Exception e) {
          return false;
        }
    
}
}
