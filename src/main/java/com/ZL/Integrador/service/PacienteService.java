package com.ZL.Integrador.service;

import com.ZL.Integrador.entity.Paciente;
import com.ZL.Integrador.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PacienteService {
    private PacienteRepository pacienteRepository;

    public void agregar(Paciente paciente){
        pacienteRepository.save(paciente);
    }
    public List<Paciente> listar(){return pacienteRepository.findAll();}

    public void modificar(Paciente paciente){pacienteRepository.save(paciente);}

    public void eliminar(int id){pacienteRepository.deleteById(id);}

    public Optional<Paciente> getByMatricula(int id){return pacienteRepository.findById(id);}
}
