package com.ZL.Integrador.controller;

import com.ZL.Integrador.entity.Paciente;
import com.ZL.Integrador.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PacienteController {
    private PacienteService pacienteService;

    @GetMapping("/pacientes")
    public ResponseEntity<List<Paciente>> listar(){return ResponseEntity.ok( pacienteService.listar());}

    @PostMapping("/nuevoPaciente")
    public ResponseEntity<String> agregar(@RequestBody Paciente paciente)  {
        pacienteService.agregar(paciente);
        return new ResponseEntity<>("Se creo el paciente exitosamente", HttpStatus.CREATED);
    }
    @PutMapping("/actualizarPaciente")
    public ResponseEntity<String>actualizar(@RequestBody Paciente paciente){
        pacienteService.modificar(paciente);
        return new ResponseEntity<>("Se actualizo el paciente",HttpStatus.OK);
    }

    @DeleteMapping("/eliminarPaciente/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        pacienteService.eliminar(id);
        return new ResponseEntity<>("Paciente eliminado exitosamente",HttpStatus.OK);
    }
}
