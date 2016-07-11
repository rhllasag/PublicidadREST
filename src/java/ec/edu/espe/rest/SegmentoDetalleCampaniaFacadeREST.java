/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.rest;

import ec.edu.espe.entities.SegmentoDetalleCampania;
import ec.edu.espe.entities.SegmentoDetalleCampaniaPK;
import java.util.List;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author homer
 */
@Stateless
@Path("segmentodetallecampania")
public class SegmentoDetalleCampaniaFacadeREST extends AbstractFacade<SegmentoDetalleCampania> {

    @PersistenceContext(unitName = "PublicidadWebHitchUsPU")
    private EntityManager em;

    private SegmentoDetalleCampaniaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;ruc=rucValue;secCampania=secCampaniaValue;idElemento=idElementoValue;tarRuc=tarRucValue;idTargetEdad=idTargetEdadValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.edu.espe.entities.SegmentoDetalleCampaniaPK key = new ec.edu.espe.entities.SegmentoDetalleCampaniaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> ruc = map.get("ruc");
        if (ruc != null && !ruc.isEmpty()) {
            key.setRuc(ruc.get(0));
        }
        java.util.List<String> secCampania = map.get("secCampania");
        if (secCampania != null && !secCampania.isEmpty()) {
            key.setSecCampania(new Integer(secCampania.get(0)));
        }
        java.util.List<String> idElemento = map.get("idElemento");
        if (idElemento != null && !idElemento.isEmpty()) {
            key.setIdElemento(new Integer(idElemento.get(0)));
        }
        java.util.List<String> tarRuc = map.get("tarRuc");
        if (tarRuc != null && !tarRuc.isEmpty()) {
            key.setTarRuc(tarRuc.get(0));
        }
        java.util.List<String> idTargetEdad = map.get("idTargetEdad");
        if (idTargetEdad != null && !idTargetEdad.isEmpty()) {
            key.setIdTargetEdad(new Integer(idTargetEdad.get(0)));
        }
        return key;
    }

    public SegmentoDetalleCampaniaFacadeREST() {
        super(SegmentoDetalleCampania.class);
    }

    @POST
    @Override
    @Path("create")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(SegmentoDetalleCampania entity) {
        super.create(entity);
    }

    @PUT
    @Path("edit/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, SegmentoDetalleCampania entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("remove/{id}")
    public void remove(@PathParam("id") PathSegment id) {
        ec.edu.espe.entities.SegmentoDetalleCampaniaPK key = getPrimaryKey(id);
        key.setRuc(id.toString().substring(id.toString().indexOf("=")+1));
        System.out.println(key.toString());
        super.remove(super.find(key));
    }

    @GET
    @Path("find/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public SegmentoDetalleCampania find(@PathParam("id") PathSegment id) {
        ec.edu.espe.entities.SegmentoDetalleCampaniaPK key = getPrimaryKey(id);
        key.setRuc(id.toString().substring(id.toString().indexOf("=")+1));
        System.out.println(key.toString());
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<SegmentoDetalleCampania> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<SegmentoDetalleCampania> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
