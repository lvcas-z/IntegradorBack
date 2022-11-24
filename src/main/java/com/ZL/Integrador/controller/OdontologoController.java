package com.ZL.Integrador.controller;

import com.ZL.Integrador.entity.Odontologo;
import com.ZL.Integrador.service.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class OdontologoController {
    private OdontologoService odontologoService;

    @GetMapping("/odontologos")
    public ResponseEntity<List<Odontologo>> listar(){return ResponseEntity.ok( odontologoService.listar());}

    @PostMapping("/nuevosOdontologos")
    public ResponseEntity<String> agregar(@RequestBody Odontologo odontologo)  {
         odontologoService.agregar(odontologo);
         return new ResponseEntity<>("Se creo exitosamente", HttpStatus.CREATED);
    }
}
