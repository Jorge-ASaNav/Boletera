/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservas.Boletera.DTO;

import com.reservas.Boletera.Modelo.Eventos;
import com.reservas.Boletera.Modelo.Reservas;
import com.reservas.Boletera.Modelo.Usuarios;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jorge Alberto SN
 */
@Data
@NoArgsConstructor
public class ReservasDTO {
    private int idReserva;
    private int idUsuario;
    private int idEvento;
    private LocalDate fechaReserva;
    
    public ReservasDTO(Reservas reserva){
        this.idReserva=reserva.getIdreserva();
        this.idUsuario=reserva.getUsuario().getIdusuarios();
        this.idEvento=reserva.getEvento().getIdevento();
        this.fechaReserva=reserva.getFechareserva();
    }
}
