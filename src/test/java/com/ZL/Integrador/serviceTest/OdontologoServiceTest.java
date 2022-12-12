package com.ZL.Integrador.serviceTest;

import com.ZL.Integrador.exception.NotFoundException;
import com.ZL.Integrador.repository.OdontologoRepository;
import com.ZL.Integrador.service.OdontologoService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OdontologoServiceTest {
    @Test
    public void buscarOdontologo(){
        var repository = mock(OdontologoRepository.class);
        when(repository.findById(anyInt())).thenReturn(Optional.empty());
        var service = new OdontologoService(repository);

        assertThrows(NotFoundException.class, ()-> service.buscar(5));
    }
}
