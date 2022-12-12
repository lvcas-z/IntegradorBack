package com.ZL.Integrador.controller;

import com.ZL.Integrador.entity.Usuario;
import com.ZL.Integrador.exception.ExistException;
import com.ZL.Integrador.exception.NotFoundException;
import com.ZL.Integrador.exception.NullException;
import com.ZL.Integrador.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UsuarioController {
    private UsuarioService usuarioService;
    @PostMapping("/registrar")
    public ResponseEntity<String> agregar(@RequestBody Usuario usuario) throws ExistException, NotFoundException, NullException {
        usuarioService.guardar(usuario);
        return new ResponseEntity<>("Usuario agregado correctamente",null, HttpStatus.CREATED);
    }
}
