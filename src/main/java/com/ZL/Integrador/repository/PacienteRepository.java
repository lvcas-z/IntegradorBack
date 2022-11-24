package com.ZL.Integrador.repository;

import com.ZL.Integrador.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
}
