/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAICoop.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author wilmer
 */
public class HttpConsumo {

    String url = "", jsonRequest = "", typoMetodo = "";

    public HttpConsumo(String url, String jsonRequest, String typeMethod) {
        this.url = url;
        this.jsonRequest = jsonRequest;
        this.typoMetodo = typeMethod;
    }

    public String consumo() {
        String salida = "";
         StringBuilder resultado = new StringBuilder();
        try {
            URL url_privada = new URL(url);
            System.out.println("Url:"+url);
            //Se genera la conexion
            HttpURLConnection conn = (HttpURLConnection) url_privada.openConnection();
             
            /*
            conn.setDoOutput(true);
            //El metodo que utilizo
            conn.setRequestMethod("GET");
            //Tipo de contenido aceptado por el WS
            //conn.setRequestProperty("Content-Type", "application/t");
            //Obtengo el Stream
            OutputStream os = conn.getOutputStream();
            //Al stream le paso el request
            //os.write(jsonRequest.getBytes());
           // os.flush();

            //Obtengo el codigo de respuesta
            int codigoHTTP = conn.getResponseCode();
            String output = "";
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            System.out.println("Output from Server .... \n");
            System.out.println("El codigo de respuesta es:" + codigoHTTP);
            if (codigoHTTP == 200) {
                while ((output = br.readLine()) != null) {
                    salida = output;
                }
            } else {
                while ((output = br.readLine()) != null) {
                    salida = output;
                }
            }
            conn.disconnect();*/
            conn.setRequestMethod(typoMetodo.toUpperCase());
            // Búferes para leer
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String linea;
            // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
            while ((linea = rd.readLine()) != null) {
                resultado.append(linea);
            }
            // Cerrar el BufferedReader
            rd.close();
        } catch (Exception e) {
            System.out.println("Error al consumir proyecto interno para dispersion SPEI:" + e.getMessage());
        }
        return resultado.toString();
    }

}
