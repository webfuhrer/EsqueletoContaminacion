/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectocontaminacion;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author CDMFP
 */
public class PintaHTML {
    HashMap<Integer, String> mapa_estaciones=new HashMap();
    HashMap<Integer, String> mapa_magnitudes=new HashMap();
    public static String crearTabla(ArrayList<Contaminacion> datos_contaminacion)
    {
        rellenarMapas();
        String tabla="<table border=1>";
        //tabla=tabla+"....";
        tabla+="<tr><th>FECHA</th><th>MAGNITUD</th><th>ESTACIÓN</th>"+encabezadosHorarios(datos_contaminacion)+"</tr>";
        for(Contaminacion x: datos_contaminacion)
        {
            int n=Integer.parseInt(x.getMagnitud());
            
            tabla=tabla+"<tr><td>"+x.getFecha()+"</td><td>"+x.getMagnitud()+"</td><td>"+x.getEstacion()+"</td>"+
                    datosHorarios(x.getCantidades())+"</tr>";
                    
        }
        tabla=tabla+"</table>";
        return tabla;
    }
    private static String datosHorarios(ArrayList<String> lista_cantidades)
    {
        String aux="";
        for(String cantidad: lista_cantidades)
        {
            aux=aux+"<td>"+cantidad+"</td>";
            //aux="<td>0011</td><td>13</td><td>12</td>
        }
        return aux;
    }
    private static String encabezadosHorarios(ArrayList<Contaminacion> datos)
    {
        String encabezado="";
        Contaminacion c=datos.get(0);
        ArrayList<String> cantidades=c.getCantidades();
        for (int i=0; i<cantidades.size(); i++)
        {
            encabezado=encabezado+"<th>"+i+":00-"+(i+1)+":00"+"</th>";
        }
        return encabezado;
        
    }
}
