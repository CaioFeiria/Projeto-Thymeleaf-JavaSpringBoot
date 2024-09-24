package com.example.Thymeleaf.controllers;

import com.example.Thymeleaf.models.FuncionarioModel;
import com.example.Thymeleaf.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("/indexFuncs");
        mv.addObject("funcs", service.findAll());
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView("/cadastrarFuncionario");
        mv.addObject("func", new FuncionarioModel());
        return mv;
    }

    @GetMapping("/edit/{cpf}")
    public ModelAndView edit(@PathVariable("cpf") String cpf) {
        ModelAndView mv = new ModelAndView("/atualizarFuncionario");
        FuncionarioModel funcionario = service.findOne(cpf)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado"));
        mv.addObject("func", funcionario);
        return mv;
    }

    @GetMapping("/delete/{cpf}")
    public String delete(@PathVariable("cpf") String cpf) {
        service.delete(cpf);
        return "redirect:/funcionarios";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("func") FuncionarioModel func, BindingResult result) {
        if(result.hasErrors()) {
            return "/cadastrarFuncionario";
        }
        service.save(func);
        return "redirect:/funcionarios";
    }
}
