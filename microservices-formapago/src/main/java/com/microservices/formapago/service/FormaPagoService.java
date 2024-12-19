package com.microservices.formapago.service;

import com.microservices.formapago.model.FormaPago;
import com.microservices.formapago.repository.FormaPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagoService {

    @Autowired
    private FormaPagoRepository formaPagoRepository;

    public FormaPago crearFormaPago(FormaPago formaPago) {
        return formaPagoRepository.save(formaPago);
    }

    public Optional<FormaPago> obtenerFormaPagoPorId(Long id) {
        return formaPagoRepository.findById(id);
    }

    public List<FormaPago> obtenerTodasLasFormasPago() {
        return formaPagoRepository.findAll();
    }

    public void eliminarFormaPago(Long id) {
        formaPagoRepository.deleteById(id);
    }
}

