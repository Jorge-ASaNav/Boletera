/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservas.Boletera.DTO;

import com.reservas.Boletera.Modelo.Eventos;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jorge Alberto SN
 */
@Data
@NoArgsConstructor
public class EventoDTO {
    private int idevento;
    private String titulo;
    private String descripcion;
    private LocalDate fechaevento;
    private int capacidad;
    
    public EventoDTO(Eventos evento){
        this.idevento=evento.getIdevento();
        this.titulo=evento.getTitulo();
        this.descripcion=evento.getDescripcion();
        this.fechaevento=evento.getFechaevento();
        this.capacidad=evento.getCapacidad();
    }
}
