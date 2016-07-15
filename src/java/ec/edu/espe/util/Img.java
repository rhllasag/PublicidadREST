/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vicho
 */
public class Img {
    
    String nombre;
    String contenido;
    String tipo;

    public Img() {
    }

    public Img(String nombre, String contenido, String tipo) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Img{" + "nombre=" + nombre + ", contenido=" + contenido + ", tipo=" + tipo + '}';
    }
    
    
}
