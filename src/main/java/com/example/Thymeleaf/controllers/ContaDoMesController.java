package com.example.Thymeleaf.controllers;

import com.example.Thymeleaf.models.ContasDoMesModel;
import com.example.Thymeleaf.services.ContaDoMesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contas")
public class ContaDoMesController {

    @Autowired
    private ContaDoMesService service;

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("/indexContas");
        mv.addObject("conts", service.findAll());
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView add(ContasDoMesModel conta) {
        ModelAndView mv = new ModelAndView("/cadastrarContas");
        mv.addObject("ctn", conta);
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        return add(service.findOne(id).orElse(new ContasDoMesModel()));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return findAll();
    }

    @PostMapping("/save")
    public ModelAndView save(@Validated ContasDoMesModel conta, BindingResult result) {
        if (result.hasErrors()) {
            return add(conta);
        }
        service.save(conta);
        return findAll();
    }
}

