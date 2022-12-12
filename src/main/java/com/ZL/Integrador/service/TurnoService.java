package com.ZL.Integrador.service;

import com.ZL.Integrador.entity.Turno;
import com.ZL.Integrador.exception.ExistException;
import com.ZL.Integrador.exception.NotFoundException;
import com.ZL.Integrador.repository.TurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TurnoService {
    private TurnoRepository turnoRepository;

    public void agregar(Turno turno) throws ExistException {
        if (turnoRepository.exists(Example.of(turno)))throw new ExistException("El turno ya existe");
        turnoRepository.save(turno);
    }

    public List<Turno> listar(){return turnoRepository.findAll();}

    public Turno buscar(Integer id) throws NotFoundException {
        return turnoRepository.findById(id).orElseThrow(() -> new NotFoundException("Turno no encontrado"));
    }

    public void eliminar(int id) throws NotFoundException {
        if(buscar(id) == null) throw new NotFoundException("El turno a eliminar no existe");
        turnoRepository.deleteById(id);
    }
}
