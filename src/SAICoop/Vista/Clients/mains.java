/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAICoop.Vista.Clients;

import SAICoop.Util.HttpConsumo;

/**
 *
 * @author wilmer
 */
public class mains {
    public static void main(String[] args) {
         HttpConsumo respuesta_metodo = new HttpConsumo("http://localhost:8090/api/welcome/ip=192.168.99.201/db="+"sannicolas30jun21_wilmer", "", "POST");
    }
}
