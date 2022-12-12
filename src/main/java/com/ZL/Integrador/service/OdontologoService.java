package com.ZL.Integrador.service;

import com.ZL.Integrador.entity.Odontologo;
import com.ZL.Integrador.exception.ExistException;
import com.ZL.Integrador.exception.NotFoundException;
import com.ZL.Integrador.repository.OdontologoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OdontologoService {
    private OdontologoRepository odontologoRepository;
    public void agregar(Odontologo odontologo) throws ExistException {
        if (odontologoRepository.exists(Example.of(odontologo))) throw new ExistException("El odontologo ya existe");
        odontologoRepository.save(odontologo);
    }
    public List<Odontologo> listar(){return odontologoRepository.findAll();}

    public void modificar(String matricula,Integer id) throws NotFoundException {
        if(buscar(id) == null) throw new NotFoundException("El odontologo a modificar es inexistente");
        odontologoRepository.modificar(matricula, id);
        ;}

    public void eliminar(int id) throws NotFoundException {
        if (buscar(id) ==null) throw new NotFoundException("El odontologo a eliminar no existe");
        odontologoRepository.deleteById(id);
    }

    public Odontologo buscar(Integer id) throws NotFoundException {
        return odontologoRepository.findById(id).orElseThrow(() -> new NotFoundException("Odontologo no encontrado"));
    }
}
