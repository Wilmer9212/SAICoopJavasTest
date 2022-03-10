/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAICoop.Util;

import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author wilmer
 */
public class JPAUtil {
    String usuario="saicoop";
    String contrasenia="slufpana?";
    String PU="conexion";
    public EntityManager createEntityManager(String ip, String bd) {
        System.out.println("Servidor:"+ip+",base:"+bd);
        try {
            Properties properties = new Properties();
            properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
            properties.put("javax.persistence.jdbc.url", "jdbc:postgresql://" + ip + ":5432/" + bd);
            properties.put("javax.persistence.jdbc.user", "saicoop");
            properties.put("javax.persistence.jdbc.password", "slufpana?");
            return Persistence.createEntityManagerFactory(PU, properties).createEntityManager();
        } catch (Throwable e) {
            System.err.println("Error en getTntityManagerFactory de JpaUtil tipo " + e.getMessage());
            return null;
        }
    }
}
