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
public class Contaminacion {
    private String fecha;
    private String magnitud;
    private String estacion;
    private ArrayList<String> cantidades;

public Contaminacion(String fecha, String magnitud, String estacion, ArrayList<String> cantidades) {
        this.fecha = fecha;
        this.magnitud = magnitud;
        this.estacion = estacion;
        this.cantidades = cantidades;
    }
    public String getFecha() {
        return fecha;
    }

    public String getMagnitud() {
        return magnitud;
    }

    public String getEstacion() {
        return estacion;
    }

    public ArrayList<String> getCantidades() {
        return cantidades;
    }
    
}
