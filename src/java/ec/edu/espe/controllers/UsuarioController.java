/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.controllers;

import ec.edu.espe.dao.UsuarioFacade;
import ec.edu.espe.entities.Usuario;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author homer
 */
@Stateless
public class UsuarioController {

    @EJB
    private UsuarioFacade facade;
    
    public List<Usuario> listUsuarios(){
    return facade.findAll();
    }
    public Usuario getByCodigo(Integer codigo){
    return facade.getByCodigo(codigo);
    }    
}
