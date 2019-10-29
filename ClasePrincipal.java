/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectocontaminacion;

import java.util.ArrayList;

/**
 *
 * @author CDMFP
 */
public class ClasePrincipal {
    public static void main(String[] args) {
        ArrayList<Contaminacion> datos=AccesoFichero.leerDatosContaminacion();
        String html_tabla=PintaHTML.crearTabla(datos);
        AccesoFichero.grabarTablaHTML(html_tabla);
        System.out.println(html_tabla);
        //Magnitud Estacion 0-1 1-2 2-3 .....
    }
}
