/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservas.Boletera.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jorge Alberto SN
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name="reservas")
public class Reservas implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idreservas")
    private Integer idreserva;
    
    @ManyToOne
    @JoinColumn(name="idusuarios",nullable=false)
    private Usuarios usuario;
    
    @ManyToOne
    @JoinColumn(name="ideventos",nullable=false)
    private Eventos evento;
    
    @Column(name="fechareserva",nullable=false)
    private LocalDate fechareserva;
    
    @PrePersist
    public void prePersist(){
        fechareserva=LocalDate.now();
    }
}
