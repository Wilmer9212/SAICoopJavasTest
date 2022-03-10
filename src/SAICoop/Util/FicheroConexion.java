/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAICoop.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author root
 */
public class FicheroConexion {
    String fichero = "Conexion.txt";
    String nbd = "";
    String ipbd = "";

    public FicheroConexion() {
        leeFichero();
    }

    private String getHome() {
        return System.getProperty("user.home");
    }

    private String getSeparador() {
        return System.getProperty("file.separator");
    }

    public  File getFichero() {
        String sf = getHome() + getSeparador() + fichero;
        //String sf="/home/wilmer/SAICoopV1.0/Conexion.txt";
        System.out.println("sf:"+sf);
        File f = new File(sf);
        if (f.exists()) {
            return f;
        } else {
            System.out.println("El fichero no existe: " + sf);
            return null;
        }
    }

    public void leeFichero() {
        if (getFichero() != null) {
            try {
                try (FileReader fr = new FileReader(getFichero())) {
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        System.out.println("Linea:"+linea);  
                        establece(linea);
                      }
                 }
            } catch (Exception e) {
                System.out.println("Excepcion leyendo fichero " + fichero + ": " + e);
            }
        } else {
            System.out.println("No se encontro el fichero.");
        }
    }
   
   

    private void establece(String linea) {
        
        if (linea.contains("ip_conexion")) {
            ipbd = linea.split("=")[1];
            System.out.println("Base de datos:"+ipbd);
        }
        if (linea.contains("base_conexion")) {
            nbd = linea.split("=")[1];
        }   
        
    }

    public String getBd() {
        return nbd;
    }

    public String getIpbd() {
        return ipbd;
    }
}
