package com.desafio.api.desafio02.controller;

import com.desafio.api.desafio02.Model.primeiroDesafioModel02;
import com.desafio.api.desafio02.service.desafioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/desafio")
public class desafioController {

    private desafioService desafioService;

    @GetMapping(value = "/nome")
    public primeiroDesafioModel02 nomeDesafio(@RequestParam String nome) {
        return desafioService.desafioNome(nome);
    }

}

