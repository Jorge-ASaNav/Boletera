/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reservas.Boletera.Servicio;

import com.reservas.Boletera.Modelo.Reservas;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jorge Alberto SN
 */
public interface IReservaServicio {
    public List<Reservas> listarReservas();
    public Optional<Reservas> buscarReservaPorId(int id);
    public Reservas guardarReserva(Reservas reserva);
    public void eliminarReserva(Reservas reserva);
    
}
