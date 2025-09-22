/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservas.Boletera.DTO;

import com.reservas.Boletera.Modelo.Usuarios;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jorge Alberto SN
 */
@Data
@NoArgsConstructor
public class UsuarioDTO {
    private int id;
    private String nombre;
    private String email;
    
    public UsuarioDTO(Usuarios usuario){
        this.id=usuario.getIdusuarios();
        this.nombre=usuario.getNombre();
        this.email=usuario.getEmail();
    }
}
