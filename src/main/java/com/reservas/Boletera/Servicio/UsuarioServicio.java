/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservas.Boletera.Servicio;

import com.reservas.Boletera.Modelo.Usuarios;
import com.reservas.Boletera.Repositorio.UsuarioRepositorio;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 *
 * @author Jorge Alberto SN
 */
@Service
public class UsuarioServicio implements IUsuarioServicio{
    
    private final UsuarioRepositorio usuRepo;
    
    public UsuarioServicio(UsuarioRepositorio usuRepo){
    this.usuRepo=usuRepo;
    }

    private final Logger logger=LoggerFactory.getLogger(UsuarioServicio.class);
    
    @Override
    public List<Usuarios> listarUsuarios() {
    return usuRepo.findAll();
    }

    @Override
    public Optional<Usuarios> obtenerUsuarioPorId(int id) {
        return usuRepo.findById(id);
    }

    @Override
    public Usuarios guardarUsuario(Usuarios usuario) {
        logger.info("Accesa:"+usuario);
        return usuRepo.save(usuario);
    }

    @Override
    public void eliminarUsuario(Usuarios usuario) {
        logger.info("Eliminando:"+usuario);
        usuRepo.delete(usuario);
    }
    
}
