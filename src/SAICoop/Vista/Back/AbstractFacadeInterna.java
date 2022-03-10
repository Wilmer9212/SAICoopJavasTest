/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAICoop.Vista.Back;


import SAICoop.Util.*;
import javax.persistence.EntityManager;

/**
 *
 * @author root
 */
public abstract class AbstractFacadeInterna<T> {
    
    private EntityManager em;
    private final Class<T> entityClass;

    public AbstractFacadeInterna(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    public static EntityManager conectar() {
         EntityManager em=null;
         FicheroConexion fc=new FicheroConexion();
         JPAUtil jpa=new JPAUtil();
         
         System.out.println("ip:"+fc.getIpbd()+",Base Conexion:"+fc.getBd());
         em=jpa.createEntityManager(fc.getIpbd(),fc.getBd());
         
        return em;
    }

}
