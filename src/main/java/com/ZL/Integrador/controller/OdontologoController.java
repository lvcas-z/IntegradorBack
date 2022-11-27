package com.ZL.Integrador.controller;

import com.ZL.Integrador.entity.Odontologo;
import com.ZL.Integrador.service.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OdontologoController {
    private OdontologoService odontologoService;

    @GetMapping("/odontologos")
    public ResponseEntity<List<Odontologo>> listar(){return ResponseEntity.ok( odontologoService.listar());}

    @PostMapping("/nuevoOdontologo")
    public ResponseEntity<String> agregar(@RequestBody Odontologo odontologo)  {
            odontologoService.agregar(odontologo);
            return new ResponseEntity<>("Se creo exitosamente", HttpStatus.CREATED);
    }
    @PutMapping("/actualizarOdontologo")
    public ResponseEntity<String>actualizar(@RequestBody Odontologo odontologo){
        odontologoService.modificar(odontologo);
        return new ResponseEntity<>("Se actualizo el odontologo",HttpStatus.OK);
    }

    @DeleteMapping("/eliminarOdontologo/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        odontologoService.eliminar(id);
        return new ResponseEntity<>("Odontologo eliminado exitosamente",HttpStatus.OK);
    }
}
