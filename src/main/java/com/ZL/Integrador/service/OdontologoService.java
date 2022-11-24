package com.ZL.Integrador.service;

import com.ZL.Integrador.entity.Odontologo;
import com.ZL.Integrador.repository.OdontologoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OdontologoService {
    private OdontologoRepository odontologoRepository;
    public void agregar(Odontologo odontologo){
        odontologoRepository.save(odontologo);
    }
    public List<Odontologo> listar(){return odontologoRepository.findAll();}

    public Odontologo modificar(Odontologo odontologo){return odontologoRepository.save(odontologo);}

    public void eliminar(int id){odontologoRepository.deleteById(id);}

    public Optional<Odontologo> getByMatricula(int id){return odontologoRepository.findById(id);}
}
