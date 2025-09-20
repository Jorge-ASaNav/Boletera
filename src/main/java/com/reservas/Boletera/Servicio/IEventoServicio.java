/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reservas.Boletera.Servicio;

import com.reservas.Boletera.Modelo.Eventos;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jorge Alberto SN
 */
public interface IEventoServicio {
    public List<Eventos> listarEventos();
    public Optional<Eventos> buscarEventoPorId(int id);
    public Eventos guardarEvento(Eventos evento);
    public void eliminarEvento(Eventos evento);
}
