/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.rest;

import ec.edu.espe.dao.CampaniaFacade;
import ec.edu.espe.dao.DetalleCampaniaFacade;
import ec.edu.espe.dao.ElementoFacade;
import ec.edu.espe.entities.Campania;
import ec.edu.espe.entities.DetalleCampania;
import ec.edu.espe.entities.Elemento;
import ec.edu.espe.util.ElementoPublicidad;
import ec.edu.espe.util.FTPUploader;
import ec.edu.espe.util.Img;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.imageio.ImageIO;
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
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author homer
 */
@Stateless
@Path("elemento")
public class ElementoFacadeREST extends AbstractFacade<Elemento> {

    @PersistenceContext(unitName = "PublicidadWebHitchUsPU")
    private EntityManager em;
    @EJB
    private ElementoFacade facade;
    @EJB
    private DetalleCampaniaFacade facadeDetalleCampania;
    @EJB
    private CampaniaFacade facadeCampania;

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
        try {
            //BASE64Decoder decoder = new BASE64Decoder();
            Base64 b = new Base64();
            byte[] imageByte = b.decode(a.getContenido());
            InputStream in = new ByteArrayInputStream(imageByte);
            BufferedImage bImageFromConvert = ImageIO.read(in);
            System.out.println("Contenido:" + a.getContenido() + "Nombre:" + a.getNombre() + "Tipo:" + a.getTipo());
            path = "http://52.34.202.157:82/img/" + a.getNombre();
//            path="http://192.168.80.109:82/img/"+a.getNombre();
            ImageIO.write(bImageFromConvert, a.getNombre().substring(a.getNombre().length() - 3, a.getNombre().length()), new File(
                    "C:/xampp/htdocs/img/" + a.getNombre()));

//        System.out.println("Writeimage " + a);
//        String path = "";
//        FTPUploader ftpUploader;
//        try {
//            ftpUploader = new FTPUploader();
//            BASE64Decoder decoder = new BASE64Decoder();
//            byte[] imageByte = decoder.decodeBuffer(a.getContenido());
//            File file = ftpUploader.toFile(a.getNombre(), imageByte);
//            path = ftpUploader.uploadFile(file, a.getNombre(), "/" + a.getTipo() + "/");
//            ftpUploader.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return path;
    }

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
    @Path("getElement")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ElementoPublicidad getElement() {
        int elemento = -1;
        Campania campaniaActiva = new Campania();
        List<Campania> campanias = facadeCampania.findAll();
        List<Campania> campaniasActivas = new ArrayList<>();
        for (Campania campania : campanias) {
            if (campania.getEstado().compareTo("A") == 0) {
                campaniasActivas.add(campania);
            }
        }
        List<DetalleCampania> detallesCampaniaActivas = new ArrayList<>();
        if (!campaniasActivas.isEmpty()) {
            do {
                int idx = new Random().nextInt(campaniasActivas.size());
                campaniaActiva = campaniasActivas.get(idx);
                List<DetalleCampania> detalles = facadeDetalleCampania.findAll();
                for (DetalleCampania detalle : detalles) {
                    if (detalle.getDetalleCampaniaPK().getSecCampania() == campaniaActiva.getCampaniaPK().getSecCampania()) {
                        detallesCampaniaActivas.add(detalle);
                    }
                }
            } while (detallesCampaniaActivas.isEmpty());
            int random = new Random().nextInt(detallesCampaniaActivas.size());
            DetalleCampania detalleCampaniaAMostrar = new DetalleCampania();
            if (random >= 0 && !detallesCampaniaActivas.isEmpty()) {
                detalleCampaniaAMostrar = detallesCampaniaActivas.get(random);
                elemento = detalleCampaniaAMostrar.getDetalleCampaniaPK().getIdElemento();
            }
        }

        if (elemento != -1) {
            //**********************************************************************************
//            String contenido = "";
//            Elemento eleTmp = (Elemento) facade.find(elemento);
//            ElementoPublicidad ele = new ElementoPublicidad();
//            ele.setId(eleTmp.getIdElemento());
//            ele.setUrl(eleTmp.getUrl());
//            FTPUploader ftpUploader;
//            BASE64Encoder encoder = new BASE64Encoder();
//            try {
//                ftpUploader = new FTPUploader();
//                contenido = encoder.encodeBuffer(ftpUploader.downloadFile(eleTmp.getPath()));
//                System.out.println("Contenido" + contenido.length());
//                ftpUploader.disconnect();
//            } catch (Exception ex) {
//                Logger.getLogger(UsuarioFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            ele.setBase64(contenido);
//            ele.setPosicion(eleTmp.getPantalla());
//            return ele;
            //**********************************************************************************
            Elemento eleTmp = (Elemento) facade.find(elemento);
            ElementoPublicidad ele = new ElementoPublicidad();
            ele.setId(eleTmp.getIdElemento());
            ele.setUrl(eleTmp.getUrl());
            ele.setBase64(eleTmp.getPath());
            ele.setPosicion(eleTmp.getPantalla());
            return ele;

        }
        return null;
    }

    @GET
    @Path("getAllElements")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ElementoPublicidad> getAllElements() {
        List<ElementoPublicidad> elementos = new ArrayList();
        List<Campania> campanias = facadeCampania.findAll();
        List<Campania> campaniasActivas = new ArrayList<>();
        for (Campania campania : campanias) {
            if (campania.getEstado().compareTo("A") == 0) {
                campaniasActivas.add(campania);
            }
        }
        List<DetalleCampania> detallesCampaniaActivas = new ArrayList<>();
        if (!campaniasActivas.isEmpty()) {

            List<DetalleCampania> detalles = facadeDetalleCampania.findAll();
            for (Campania c : campaniasActivas) {
                for (DetalleCampania detalle : detalles) {
                    if (detalle.getDetalleCampaniaPK().getSecCampania() == c.getCampaniaPK().getSecCampania()) {
                        detallesCampaniaActivas.add(detalle);
                    }
                }
            }
            if (!detallesCampaniaActivas.isEmpty()) {
                for (DetalleCampania detalle : detallesCampaniaActivas) {
                    Elemento eleTmp = (Elemento) facade.find(detalle.getDetalleCampaniaPK().getIdElemento());
                    if (eleTmp != null) {
                        ElementoPublicidad ele = new ElementoPublicidad();
                        ele.setId(eleTmp.getIdElemento());
                        ele.setUrl(eleTmp.getUrl());
                        ele.setBase64(eleTmp.getPath());
                        ele.setPosicion(eleTmp.getPantalla());
                        elementos.add(ele);
                    }
                }
                return elementos;
            }
        }
        return null;
    }

    @GET
    @Path("getImage/{path}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getImage(@PathParam("path") String path
    ) {
        System.out.println("dir " + path);
        String contenido = "";
        String pathRaiz = "/publicidad/";
        FTPUploader ftpUploader;
        //BASE64Encoder encoder = new BASE64Encoder();
        Base64 b = new Base64();
        try {
            ftpUploader = new FTPUploader();
            contenido = b.encode(ftpUploader.downloadFile(pathRaiz + path)).toString();
            ftpUploader.disconnect();

        } catch (Exception ex) {
            Logger.getLogger(UsuarioFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contenido;
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
    public List<Elemento> findRange(@PathParam("from") Integer from,
            @PathParam("to") Integer to
    ) {
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
