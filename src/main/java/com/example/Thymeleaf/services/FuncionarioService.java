package com.example.Thymeleaf.services;

import com.example.Thymeleaf.models.FuncionarioModel;
import com.example.Thymeleaf.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<FuncionarioModel> findAll() {
        return repository.findAll();
    }

    public Optional<FuncionarioModel> findOne(String cpf) {
        return repository.findById(cpf);
    }

    public FuncionarioModel save(FuncionarioModel funcionario) {
        return repository.saveAndFlush(funcionario);
    }

    public void delete(String cpf) {
        repository.deleteById(cpf);
    }
}
