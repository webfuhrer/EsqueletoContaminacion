/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectocontaminacion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CDMFP
 */
public class AccesoFichero {
    public static ArrayList<Contaminacion> leerDatosContaminacion() 
    {
        ArrayList<Contaminacion> lista_contaminaciones=new ArrayList<>();
        try {
           
            FileReader lector=new FileReader("C:\\contaminacion\\horario.csv");
            BufferedReader br=new BufferedReader(lector);
            String linea=br.readLine();//La primera linea no tiene info
            linea=br.readLine();
            
            while(linea!=null)
            {
                ArrayList<String> lista_cantidades=new ArrayList();
                String[] datos=linea.split(";");
                String estacion=datos[2];
                String magnitud=datos[3];
                String fecha=datos[7]+"-"+datos[6]+"-"+datos[5];
      //Contaminacion(String fecha, String magnitud, String estacion, ArrayList<String> cantidades) {
      
                for (int j=8; j<datos.length; j=j+2)
                {
                    String valor=datos[j];
                    lista_cantidades.add(valor);
                }
                Contaminacion c=new Contaminacion(fecha, magnitud, estacion, lista_cantidades);
                lista_contaminaciones.add(c);
                linea=br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_contaminaciones;
    }

    static void grabarTablaHTML(String html_tabla) {
        String html="<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<title>Title of the document</title>\n" +
"</head>\n" +
"\n" +
"<body>"+html_tabla+"</body></html>";
        try {
            FileWriter fw=new FileWriter("C:\\contaminacion\\horario.html");
            fw.write(html);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
