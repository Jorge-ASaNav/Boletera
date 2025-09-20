/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reservas.Boletera.Repositorio;

import com.reservas.Boletera.Modelo.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jorge Alberto SN
 */
@Repository
public interface ReservaRepositorio extends JpaRepository<Reservas, Integer>{
    
}
