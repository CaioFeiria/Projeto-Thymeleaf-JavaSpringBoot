package com.example.Thymeleaf.services;

import com.example.Thymeleaf.models.ContasDoMesModel;
import com.example.Thymeleaf.repositories.ContasDoMesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaDoMesService {

    @Autowired
    private ContasDoMesRepository repository;

    public List<ContasDoMesModel> findAll() {
        return repository.findAll();
    }

    public Optional<ContasDoMesModel> findOne(Integer id) {
        return repository.findById(id);
    }

    public ContasDoMesModel save(ContasDoMesModel funcionario) {
        return repository.saveAndFlush(funcionario);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
