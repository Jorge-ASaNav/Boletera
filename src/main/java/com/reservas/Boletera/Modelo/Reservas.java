/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservas.Boletera.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
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
    @Column(name="idreserva")
    private Integer idreserva;
    
    @ManyToOne
    @JoinColumn(name="idusuario",nullable=false)
    private Usuarios usuario;
    
    @ManyToOne
    @JoinColumn(name="idevento",nullable=false)
    private Eventos evento;
    
    @Column(name="fechareserva",nullable=false)
    private LocalDate fechareserva;
    
    @PrePersist
    public void prePersist(){
        fechareserva=LocalDate.now();
    }
}
