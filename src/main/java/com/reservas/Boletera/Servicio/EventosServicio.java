/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservas.Boletera.Servicio;

import com.reservas.Boletera.Modelo.Eventos;
import com.reservas.Boletera.Repositorio.EventoRepositorio;
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
public class EventosServicio implements IEventoServicio{
    
    private final EventoRepositorio eveRepo;
    
    public EventosServicio(EventoRepositorio eveRepo){
        this.eveRepo=eveRepo;
    }
    
    private final Logger logger=LoggerFactory.getLogger(EventosServicio.class);

    @Override
    public List<Eventos> listarEventos() {
        return eveRepo.findAll();
    }

    @Override
    public Optional<Eventos> buscarEventoPorId(int id) {
        return eveRepo.findById(id);
    }

    @Override
    public Eventos guardarEvento(Eventos evento) {
        logger.info("Almacenando:"+evento);
        return eveRepo.save(evento);
    }

    @Override
    public void eliminarEvento(Eventos evento) {
        logger.info("Eliminando:"+evento);
        eveRepo.delete(evento);
    }
    
}
