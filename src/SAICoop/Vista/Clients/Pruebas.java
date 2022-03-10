/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAICoop.Vista.Clients;

import SAICoop.Util.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.eclipse.persistence.internal.helper.DatabaseField;
import org.eclipse.persistence.queries.ScrollableCursor;
import org.eclipse.persistence.sessions.DatabaseRecord;

/**
 *
 * @author wilmer
 */
public class Pruebas {

    public static void main(String ars[]) {

        try {
            EntityManager em = new JPAUtil().createEntityManager("192.168.99.200", "sannicolas30nov20_movimientos");

           /* Query query = em.createNativeQuery("SELECT nombre FROM personas limit 1");
            String nombre = (String) query.getSingleResult();
            System.out.println("nombre:" + query.getFlushMode().name().toString());
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }*/
        String strQuery = "select * from colonias limit 10";
        Query query = em.createNativeQuery(strQuery);
        query.setHint("eclipselink.result-type","Map");
        /*query.setHint("eclipselink.result-type", "Map");*/
        query.setHint("eclipselink.cursor.scrollable", true);
        List<String>lista=new ArrayList();
        List<String>lista1=new ArrayList();
        
        String name ="";
        ScrollableCursor cursor = (ScrollableCursor) query.getSingleResult();
        
        while (cursor.hasNext()) {
            DatabaseRecord record = (DatabaseRecord) cursor.next();
            Vector<DatabaseField> fields = record.getFields();
            
            for (DatabaseField field : fields) {                
                name= field.getName();
                Object value = record.getValues(field);
                if(lista.contains(name)){
                    System.out.println("Ya existe");
                }else{
                    lista.add(name); 
                }                
                
            }
        }
            System.out.println("Lista:"+lista);
            
            
    }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
    }
}}
