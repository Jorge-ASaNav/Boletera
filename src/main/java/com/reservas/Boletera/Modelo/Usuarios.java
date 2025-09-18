/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservas.Boletera.Modelo;

import jakarta.persistence.Column;
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
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="usuarios")
public class Usuarios implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idusuarios")
    private Integer idusuarios;
    
    @NotBlank
    @Column(name="nombre")
    private String nombre;
    
    @NotBlank
    @Email
    @Column(name="email")
    private String email;
    
    @Column(name="fechaRegistro",nullable=false)
    private LocalDate fechaRegistro;
    
    @Column(name="privilegio")
    private String privilegio;
    
    @PrePersist
    public void prePersist(){
        fechaRegistro=LocalDate.now();
    }
}
