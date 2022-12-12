package com.ZL.Integrador.controller;

import com.ZL.Integrador.entity.Odontologo;
import com.ZL.Integrador.exception.ExistException;
import com.ZL.Integrador.exception.NotFoundException;
import com.ZL.Integrador.exception.NullException;
import com.ZL.Integrador.service.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping("odontologos")
public class OdontologoController {
    private OdontologoService odontologoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Odontologo>> listar(){
        if (odontologoService.listar().isEmpty())return new ResponseEntity<>(null,null,HttpStatus.NOT_FOUND);
        return ResponseEntity.ok( odontologoService.listar());
    }
    @PostMapping("/nuevoOdontologo")
    public ResponseEntity<String> agregar(@RequestBody Odontologo odontologo) throws ExistException, NotFoundException, NullException {
            odontologoService.agregar(odontologo);
            return new ResponseEntity<>("Se creo exitosamente", HttpStatus.CREATED);
    }
    @Transactional
    @PutMapping("/actualizarOdontologo/{matricula}/{id}")
    public ResponseEntity<String>actualizar(@PathVariable String matricula, @PathVariable Integer id) throws NotFoundException{
        odontologoService.modificar(matricula,id);
        return new ResponseEntity<>("Se actualizo el odontologo",HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Odontologo> buscar(@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<>(odontologoService.buscar(id), null, HttpStatus.OK);
    }
    @DeleteMapping("/eliminarOdontologo/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws NotFoundException{
        odontologoService.eliminar(id);
        return new ResponseEntity<>("Odontologo eliminado exitosamente",HttpStatus.OK);
    }
}
