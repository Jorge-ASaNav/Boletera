/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservas.Boletera.Controlador;

import com.reservas.Boletera.DTO.UsuarioDTO;
import com.reservas.Boletera.Modelo.Usuarios;
import com.reservas.Boletera.Servicio.IUsuarioServicio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jorge Alberto SN
 */
@RestController
@RequestMapping("boletera")
public class UsuariosControlador {
    
    private final IUsuarioServicio userVice;
    
    public UsuariosControlador(IUsuarioServicio userVice){
        this.userVice=userVice;
    }
    
    private final Logger logger=LoggerFactory.getLogger(UsuariosControlador.class);
    
    @GetMapping("/usuarios")
    public List<UsuarioDTO> listarUsuarios(){
        List<UsuarioDTO> listaUsuarios=userVice.listarUsuarios().stream().map(UsuarioDTO::new).toList();
        logger.info("Listado de usuarios;");
        listaUsuarios.forEach(usuario->logger.info(usuario.toString()));
        return listaUsuarios;
    }
    
    @PostMapping("/usuarios")
    public Usuarios agregarUsuario(@RequestBody Usuarios usuario){
        logger.info("Se accede al usuario:"+usuario);
        return userVice.guardarUsuario(usuario);
    }
    
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable int id){
        return userVice.obtenerUsuarioPorId(id).map(usuario->ResponseEntity.ok(new UsuarioDTO(usuario))).orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioDTO> editarUsuario(@PathVariable int id,@RequestBody UsuarioDTO usuarioObtenido){
        return userVice.obtenerUsuarioPorId(id).map(usuario -> {
           usuario.setNombre(usuarioObtenido.getNombre());
           usuario.setEmail(usuarioObtenido.getEmail());
           Usuarios actualizado=userVice.guardarUsuario(usuario);
           return ResponseEntity.ok(new UsuarioDTO(actualizado));
        }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarUsuario(@PathVariable int id){
        return userVice.obtenerUsuarioPorId(id).map(usuario->{
            userVice.eliminarUsuario(usuario);
            Map<String,Boolean> respuesta=new HashMap<>();
            logger.info("Eliminado");
            respuesta.put("Eliminado:", Boolean.TRUE);
            return ResponseEntity.ok(respuesta);
        }).orElse(ResponseEntity.notFound().build());
    }
    
}
