/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.dao;

import ec.edu.espe.entities.Elemento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author homer
 */
@Stateless
public class ElementoFacade extends AbstractFacade<Elemento> {

    @PersistenceContext(unitName = "PublicidadWebHitchUsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ElementoFacade() {
        super(Elemento.class);
    }
    
}
