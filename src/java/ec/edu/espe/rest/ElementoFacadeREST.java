/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.rest;

import ec.edu.espe.entities.Elemento;
import ec.edu.espe.util.FTPUploader;
import ec.edu.espe.util.Img;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import sun.misc.BASE64Decoder;

/**
 *
 * @author homer
 */
@Stateless
@Path("elemento")
public class ElementoFacadeREST extends AbstractFacade<Elemento> {

    @PersistenceContext(unitName = "PublicidadWebHitchUsPU")
    private EntityManager em;

    public ElementoFacadeREST() {
        super(Elemento.class);
    }

    @POST
    @Override
    @Path("create")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Elemento entity) {
        System.out.println("Creacion de nuevo elemento");
        super.create(entity);
    }

    @POST
    @Path("writeImage")
    @Consumes({MediaType.APPLICATION_JSON})
    public String writeImage(Img a) {
        System.out.println("Writeimage " + a);
        String path = "";
        FTPUploader ftpUploader;
        try {
            ftpUploader = new FTPUploader();
            BASE64Decoder decoder = new BASE64Decoder();
             byte[] imageByte = decoder.decodeBuffer(a.getContenido());
            File file = ftpUploader.toFile(a.getNombre(), imageByte);
            path = ftpUploader.uploadFile(file, a.getNombre(), "/" + a.getTipo() + "/");
            ftpUploader.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return path;
    }
//@POST
//@Path("writeImage")
//@Consumes({MediaType.APPLICATION_JSON})
//public String writeImage(Img a) {
//    System.out.println("Writeimage "+a);
//        String path = "";
//        FTPUploader ftpUploader;
//        try {
//        ftpUploader = new FTPUploader();
//        File file = ftpUploader.toFile(a.getNombre(), Base64.getDecoder().decode(a.getContenido()));        
//        path = ftpUploader.uploadFile(file, a.getNombre(), "/"+a.getTipo()+"/");       
//        ftpUploader.disconnect();
//        } catch (Exception ex) {
//            Logger.getLogger(UsuarioFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
//        }
//return path;
//}

    @PUT
    @Path("edit/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Elemento entity) {
        System.out.println("Actualizar ID " + id);
        super.edit(entity);
    }

    @DELETE
    @Path("remove/{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("find/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Elemento find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Elemento> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Elemento> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
