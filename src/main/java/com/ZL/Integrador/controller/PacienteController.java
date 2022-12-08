package com.ZL.Integrador.controller;

import com.ZL.Integrador.entity.Paciente;
import com.ZL.Integrador.exception.ExistException;
import com.ZL.Integrador.exception.NotFoundException;
import com.ZL.Integrador.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteService pacienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Paciente>> listar(){return ResponseEntity.ok( pacienteService.listar());}

    @PostMapping("/nuevoPaciente")
    public ResponseEntity<String> agregar(@RequestBody Paciente paciente) throws ExistException {
        pacienteService.agregar(paciente);
        return new ResponseEntity<>("Se creo el paciente exitosamente", HttpStatus.CREATED);
    }
    @PutMapping("/actualizarPaciente")
    public ResponseEntity<String>actualizar(@RequestBody Paciente paciente){
        pacienteService.modificar(paciente);
        return new ResponseEntity<>("Se actualizo el paciente",HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<>(pacienteService.buscar(id), null, HttpStatus.OK);
    }
    @DeleteMapping("/eliminarPaciente/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws NotFoundException {
        pacienteService.eliminar(id);
        return new ResponseEntity<>("Paciente eliminado exitosamente",HttpStatus.OK);
    }
}
