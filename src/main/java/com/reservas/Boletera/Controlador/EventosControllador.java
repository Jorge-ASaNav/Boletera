/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservas.Boletera.Controlador;

import com.reservas.Boletera.DTO.EventoDTO;
import com.reservas.Boletera.Modelo.Eventos;
import com.reservas.Boletera.Servicio.IEventoServicio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jorge Alberto SN
 */
@RestController
@RequestMapping("boletera")
public class EventosControllador {
    
    private final IEventoServicio eveSer;
    
    public EventosControllador(IEventoServicio eveSer){
    this.eveSer=eveSer;
    }
    
    private final Logger logger=LoggerFactory.getLogger(EventosControllador.class);
    
    
    @GetMapping("/eventos")
    public List<EventoDTO> listarEventos(){
        List<EventoDTO> listaEventos=eveSer.listarEventos().stream().map(EventoDTO::new).toList();
        logger.info("Listado:");
        listaEventos.forEach(evento->logger.info(evento.toString()));
        return listaEventos;
    }
    
    
    @PostMapping("/eventos")
    public Eventos agregarEvento(@RequestBody Eventos evento){
        return eveSer.guardarEvento(evento);
    }
    
    @GetMapping("/eventos/{id}")
    public ResponseEntity<EventoDTO> buscarEventoPorId(@PathVariable int id){ 
        return eveSer.buscarEventoPorId(id).map(evento->ResponseEntity.ok(new EventoDTO(evento))).orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/eventos/{id}")
    public ResponseEntity<EventoDTO> editarEvento(@PathVariable int id,@RequestBody Eventos eventoObtenido){
        return eveSer.buscarEventoPorId(id).map(evento->{
            evento.setTitulo(eventoObtenido.getTitulo());
            evento.setDescripcion(eventoObtenido.getDescripcion());
            evento.setFechaevento(eventoObtenido.getFechaevento());
            evento.setCapacidad(eventoObtenido.getCapacidad());
            Eventos actualizado=eveSer.guardarEvento(evento);
            return ResponseEntity.ok(new EventoDTO(actualizado));
        }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/eventos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEvento(@PathVariable int id){
        return eveSer.buscarEventoPorId(id).map(evento->{
            eveSer.eliminarEvento(evento);
            Map<String,Boolean> respuesta=new HashMap<>();
            respuesta.put("Eliminado",Boolean.TRUE);
            logger.info("Eliminado");
            return ResponseEntity.ok(respuesta);
        }).orElse(ResponseEntity.notFound().build());
                
    }
    
}
