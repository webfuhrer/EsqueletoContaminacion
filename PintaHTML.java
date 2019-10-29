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
     private static HashMap<Integer, String> mapa_estaciones=new HashMap();
     private static HashMap<Integer, String> mapa_magnitudes=new HashMap();
    private static void rellenarMapas()
    {
        mapa_estaciones.put(1, "Pº. Recoletos");
        mapa_estaciones.put(2, "Glta. de Carlos V");
        mapa_estaciones.put(3, "Pza. del Carmen");
        mapa_estaciones.put(4, "Pza. de España");
        mapa_estaciones.put(5, "Barrio del Pilar");
        
        mapa_magnitudes.put(1, "Dióxido de Azufre (SO<sub>2</sub>)");
        mapa_magnitudes.put(6, "Monóxido de Carbono (CO)");
        mapa_magnitudes.put(7, "Monóxido de Nitrógeno (NO)");
        mapa_magnitudes.put(8, "Dióxido de Nitrógeno (NO<sub>2</sub>)");
        mapa_magnitudes.put(9, "Partículas < 2.5 µm");
        
        
        
    }
    public static String crearTabla(ArrayList<Contaminacion> datos_contaminacion)
    {
        rellenarMapas();
        String tabla="<table border=1>";
        //tabla=tabla+"....";
        
        tabla+="<tr><th>FECHA</th><th>MAGNITUD</th><th>ESTACIÓN</th>"+encabezadosHorarios(datos_contaminacion)+"</tr>";
        for(Contaminacion x: datos_contaminacion)
        {
            int magnitud_numero=Integer.parseInt(x.getMagnitud());
            int estacion_numero=Integer.parseInt(x.getEstacion());
            String nombre_magnitud=mapa_magnitudes.get(magnitud_numero);
            String nombre_estacion=mapa_estaciones.get(estacion_numero);
            if (nombre_magnitud==null)
            {
                nombre_magnitud=x.getMagnitud();
            }
            if (nombre_estacion==null)
            {
                nombre_estacion=x.getEstacion();
            }
            tabla=tabla+"<tr><td>"+x.getFecha()+"</td><td>"+nombre_magnitud+"</td><td>"+nombre_estacion+"</td>"+
                    datosHorarios(x.getCantidades())+"</tr>";
                    
        }
        tabla=tabla+"</table>";
        return tabla;
    }
    private static String pasarANumero(String n) {
        int numero=0;
        float a=0;
        String aux="";
        try{
        numero=Integer.parseInt(n);
         aux=String.valueOf(numero);
        }
        catch(NumberFormatException excepcion)
        {
            a=Float.parseFloat(n);
            aux=String.valueOf(a);
        }
       return aux;  
    }
    private static String datosHorarios(ArrayList<String> lista_cantidades)
    {
        String aux="";
        for(String cantidad: lista_cantidades)
        {
            String cantidad_numerica=pasarANumero(cantidad);
            
            aux=aux+"<td>"+cantidad_numerica+"</td>";
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
