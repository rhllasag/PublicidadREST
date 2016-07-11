/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author homer
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ec.edu.espe.rest.CampaniaFacadeREST.class);
        resources.add(ec.edu.espe.rest.DetalleCampaniaFacadeREST.class);
        resources.add(ec.edu.espe.rest.DetalleFacturaFacadeREST.class);
        resources.add(ec.edu.espe.rest.ElementoFacadeREST.class);
        resources.add(ec.edu.espe.rest.EmpresaFacadeREST.class);
        resources.add(ec.edu.espe.rest.EstadisticaCampaniaFacadeREST.class);
        resources.add(ec.edu.espe.rest.FacturaEmpresaFacadeREST.class);
        resources.add(ec.edu.espe.rest.HistorialCampaniaFacadeREST.class);
        resources.add(ec.edu.espe.rest.SegmentoDetalleCampaniaFacadeREST.class);
        resources.add(ec.edu.espe.rest.TargetEdadFacadeREST.class);
        resources.add(ec.edu.espe.rest.UsuarioFacadeREST.class);
    }
    
}
