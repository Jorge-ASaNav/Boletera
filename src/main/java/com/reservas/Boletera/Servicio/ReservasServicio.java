/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservas.Boletera.Servicio;

import com.reservas.Boletera.Modelo.Reservas;
import com.reservas.Boletera.Repositorio.ReservaRepositorio;
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
public class ReservasServicio implements IReservaServicio{
    
    private final ReservaRepositorio reseRepo;
    public ReservasServicio(ReservaRepositorio reseRepo){
    this.reseRepo=reseRepo;
    }

    private final Logger logger=LoggerFactory.getLogger(ReservasServicio.class);
    
    @Override
    public List<Reservas> listarReservas() {
        return reseRepo.findAll();
    }

    @Override
    public Optional<Reservas> buscarReservaPorId(int id) {
        return reseRepo.findById(id);
    }

    @Override
    public Reservas guardarReserva(Reservas reserva) {
        logger.info("Almacenando:"+reserva);
        return reseRepo.save(reserva);
    }

    @Override
    public void eliminarReserva(Reservas reserva) {
        logger.info("Eliminando:"+reserva);
        reseRepo.delete(reserva);
    }
    
}
