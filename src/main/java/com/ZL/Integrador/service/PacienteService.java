package com.ZL.Integrador.service;

import com.ZL.Integrador.entity.Paciente;
import com.ZL.Integrador.exception.ExistException;
import com.ZL.Integrador.exception.NotFoundException;
import com.ZL.Integrador.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PacienteService {
    private PacienteRepository pacienteRepository;

    public void agregar(Paciente paciente) throws ExistException {
        if (pacienteRepository.exists(Example.of(paciente)))throw new ExistException("El paciente ya existe");
        pacienteRepository.save(paciente);
    }
    public List<Paciente> listar(){return pacienteRepository.findAll();}

    public void modificar(Paciente paciente){pacienteRepository.save(paciente);}

    public Paciente buscar(Integer id) throws NotFoundException {
        return pacienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Paciente no encontrado"));
    }
    public void eliminar(int id) throws NotFoundException {
        if(buscar(id) == null) throw new NotFoundException("El odontologo a eliminar no existe");
        pacienteRepository.deleteById(id);
    }

}
