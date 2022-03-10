/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAICoop.Util;

import javax.persistence.EntityManager;

/**
 *
 * @author root
 */
public abstract class AbstractFacade<T> {
    
    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    public static EntityManager conexion(String ip,String nombre) {
         EntityManager em;
         JPAUtil jpa=new JPAUtil();
        em=jpa.createEntityManager(ip, nombre);
        return em;
    }
}