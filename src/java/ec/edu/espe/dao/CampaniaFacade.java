/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dao;

import ec.edu.espe.entities.Campania;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author homer
 */
@Stateless
public class CampaniaFacade extends AbstractFacade<Campania> {
    
    @PersistenceContext(unitName = "PublicidadWebHitchUsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CampaniaFacade() {
        super(Campania.class);
    }
    
}
