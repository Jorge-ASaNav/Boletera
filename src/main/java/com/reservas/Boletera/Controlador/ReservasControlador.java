/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservas.Boletera.Controlador;

import com.reservas.Boletera.DTO.ReservasDTO;
import com.reservas.Boletera.Modelo.Eventos;
import com.reservas.Boletera.Modelo.Reservas;
import com.reservas.Boletera.Modelo.Usuarios;
import com.reservas.Boletera.Servicio.IEventoServicio;
import com.reservas.Boletera.Servicio.IReservaServicio;
import com.reservas.Boletera.Servicio.IUsuarioServicio;
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
public class ReservasControlador {
    
    private final IReservaServicio reServ;
    private final IUsuarioServicio uServ;
    private final IEventoServicio eveServ;
    
    public ReservasControlador(IReservaServicio reServ,IUsuarioServicio uServ,IEventoServicio eveServ){
        this.reServ=reServ;
        this.uServ=uServ;
        this.eveServ=eveServ;
    }
    
    private final Logger logger=LoggerFactory.getLogger(ReservasControlador.class);
    
    @GetMapping("/reservas")
    public List<ReservasDTO> listadoReservas(){
        List<ReservasDTO> reservas=reServ.listarReservas().stream().map(ReservasDTO::new).toList();
        logger.info("Listado:");
        reservas.forEach(reserva->logger.info(reserva.toString()));
        return reservas;
    }
    
    @PostMapping("/reservas")
    public ReservasDTO guardarReserva(@RequestBody ReservasDTO reserva){
        Usuarios usuario=uServ.obtenerUsuarioPorId(reserva.getIdUsuario()).orElseThrow(()->new RuntimeException("No hay usuario en BD"));
        Eventos evento=eveServ.buscarEventoPorId(reserva.getIdEvento()).orElseThrow(()-> new RuntimeException("No hay evento"));
        Reservas reservaNueva=new Reservas();
        reservaNueva.setUsuario(usuario);
        reservaNueva.setEvento(evento);
        reservaNueva.setFechareserva(reserva.getFechaReserva());
        Reservas reservaGuardada=reServ.guardarReserva(reservaNueva);
        
        return new ReservasDTO(reservaGuardada);
        
        
    }
    
    
    @GetMapping("/reservas/{id}")
    public ResponseEntity<ReservasDTO> obtenerReservaPorId(@PathVariable int id){
        return reServ.buscarReservaPorId(id).map(evento->ResponseEntity.ok(new ReservasDTO(evento))).orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/reservas/{id}")
    public ResponseEntity<ReservasDTO> editarReserva(@PathVariable int id,@RequestBody ReservasDTO reservaObtenida){
        return reServ.buscarReservaPorId(id).map(reserva->{
        Usuarios usuario=uServ.obtenerUsuarioPorId(reservaObtenida.getIdUsuario()).orElseThrow(()->new RuntimeException("No hay usuario en BD"));
        Eventos evento=eveServ.buscarEventoPorId(reservaObtenida.getIdEvento()).orElseThrow(()-> new RuntimeException("No hay evento"));
        reserva.setEvento(evento);
        reserva.setUsuario(usuario);
        reserva.setFechareserva(reservaObtenida.getFechaReserva());
        
        Reservas reservaGuardada=reServ.guardarReserva(reserva);
        return ResponseEntity.ok(new ReservasDTO(reservaGuardada));
        }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/reservas/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarReserva(@PathVariable int id){
        return reServ.buscarReservaPorId(id).map(reserva->{
            Map<String,Boolean> respuesta=new HashMap<>();
            reServ.eliminarReserva(reserva);
            logger.info("Eliminado:",reserva);
            respuesta.put("Eliminado",Boolean.TRUE);
            return ResponseEntity.ok(respuesta);
        }).orElse(ResponseEntity.notFound().build());
    
    }
    
}
