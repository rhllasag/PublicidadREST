/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.util;

/**
 *
 * @author JuanAndresCaspi
 */
public class ElementoPublicidad {
    Integer id;
    String base64;
    String url;
    String posicion;

    public ElementoPublicidad() {
    }

    public ElementoPublicidad(Integer id, String base64, String url) {
        this.id = id;
        this.base64 = base64;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "ElementoPublicidad{" + "id=" + id + ", base64=" + base64 + ", url=" + url + '}';
    }
    
}
