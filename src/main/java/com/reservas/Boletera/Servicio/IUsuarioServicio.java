/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reservas.Boletera.Servicio;

import com.reservas.Boletera.Modelo.Usuarios;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jorge Alberto SN
 */
public interface IUsuarioServicio {
    public List<Usuarios> listarUsuarios();
    public Optional<Usuarios> obtenerUsuarioPorId(int id);
    public Usuarios guardarUsuario(Usuarios usuario);
    public void eliminarUsuario(Usuarios usuario);
}
