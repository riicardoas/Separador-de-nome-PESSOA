package com.desafio.api.desafio02.service;

import com.desafio.api.desafio02.Model.primeiroDesafioModel;
import com.desafio.api.desafio02.Model.primeiroDesafioModel02;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class desafioService {


    public primeiroDesafioModel02 desafioNome(String nome) {

        primeiroDesafioModel nomes = new primeiroDesafioModel();
        primeiroDesafioModel02 nomeFinal = new primeiroDesafioModel02();


        nomes.setNomeInteiro(nome);

        String[] PrimeiroNomeSeparado = nomes.getNomeInteiro().split("_");
        List<String> nomeSeparado = Arrays.asList(PrimeiroNomeSeparado);
        List<String> ultimoNomeSeparado = nomeSeparado.subList(1, nomeSeparado.size() - 1);
        nomes.setPrimeiroNome(nomeSeparado.get(0));
        nomes.setUltimoNome(nomeSeparado.get(nomeSeparado.size() - 1));
        nomeFinal.setPrimeiroNomeReturn(nomes.getPrimeiroNome());
        nomeFinal.setSobrenomeReturn(nomes.getUltimoNome());

        if (containsPenultimo(ultimoNomeSeparado)) {

            ultimoNomeSeparado = ultimoNomeSeparado.subList(0, ultimoNomeSeparado.size() - 1);

        }

        for (int i = 0; i < ultimoNomeSeparado.size(); i++) {

            nomeFinal.setNomeDoMeio(nomeFinal.getNomeDoMeio() + " " + ultimoNomeSeparado.get(i));

        }

        nomeFinal.setUltimoNome(nomeSeparado.stream().collect(Collectors.joining(" ")));


        return nomeFinal;

    }

    boolean containsPenultimo(List ultimoNomeSeparado) {

        List<String> osD = new ArrayList<>();
        osD.add("de");
        osD.add("da");
        osD.add("do");
        osD.add("das");
        osD.add("dos");
        osD.add("De");
        osD.add("Da");
        osD.add("Das");
        osD.add("Do");
        osD.add("Dos");

        if (osD.contains(ultimoNomeSeparado.get(ultimoNomeSeparado.size() - 1))) {
            return true;
        } else {
            return false;
        }
    }

}




