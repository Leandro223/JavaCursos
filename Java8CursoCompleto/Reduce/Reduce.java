package Reduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        //Soma
        Optional<Integer> soma = list.stream()
                .reduce((n1, n2) -> n1 + n2);

        System.out.println(soma.get());


        //Multiplicacao
        Optional<Integer> multiplicacao = list.stream()
                .parallel() //posso transformar todos em paralelo
                .reduce((n1, n2) -> n1 * n2);

        System.out.println(multiplicacao.get());

        //Concatenação

        String s = "Teste para concanetação";
        String [] split = s.split(" ");
        List<String> listStr = Arrays.asList(split);

        Optional<String> concatenacao = listStr.stream()
                .reduce((s1, s2) -> s1.concat(s2));

        System.out.println(concatenacao.get());
    }
}
