package OPTIONAL;

import java.util.Optional;
import java.util.OptionalInt;

public class Java8_Optional {
    public static void main(String[] args) {

        //Usando o metdo antes do java 8
        String s = "1";
        Integer numero = converteEmNumero(s);
        System.out.println(numero);


        //usando metodo com java 8 optional
        //Assim funcionaria mas se passase uma palavra inteira ou letra geraria uma exceção
        String s2 = "1";
        Optional<Integer> numero2 = converteEmNumeroOptional(s2);
        System.out.println(numero2);

        //Sem exeção
        String ex = "Teste para Excecao"; //agora com ifPresent fica vazio sem erro de null
        String ex2 = "1"; // imprimi normalmente
        Optional<Integer> numero3 = converteEmNumeroOptional(ex);
        numero3.ifPresent(n -> System.out.println(n)); //imprimi nada mas não da erro


        //usando o orElse como default caso não consiga converter
        String msg = "Coloque texto";
        String ex3 = "1";
        Integer numero4 = converteEmNumeroOptional(ex3).orElse(0);
        System.out.println(numero4);
/*
        //usando orElseGet
        //você pode usar a expressão lambda e caso o valor não seja imprimido faça outra coisa com metodo

        String ex4 = "1";
        Integer numero5 = converteEmNumeroOptional(ex4)
                .orElseGet(() -> {return minhaOperacao();}); */

/*
        //usando OrElseThrow para emitir uma nova exceção com mensagem caso não seja numero em string
        String ex5 = "palavra";
        Integer numero5 = converteEmNumeroOptional(ex5)
                .orElseThrow(() -> new NullPointerException("valor vazio"));

        System.out.println(numero5); */



        //usando metodo agora com int se houver o valor numero em string imprimi se não gera uma exceção personalizada
        String ex6 = "8";

        int numero6 = converteEmNumeroOptionalInt(ex6)
                .orElseThrow(() -> new NullPointerException("Valor Vazio"));

        System.out.println(numero6);




    }



    //metodo retorna numero metedo antes do java8
    public static Integer converteEmNumero(String numeroStr){


        return Integer.valueOf(numeroStr);
    }

    //Com o Optional java8 mesmo metodo que converter string em Integer
    public static Optional<Integer> converteEmNumeroOptional(String numeroEmStr){

        try {
            Integer integer = Integer.valueOf(numeroEmStr);
            return Optional.of(integer);

        }catch (Exception e){

            return Optional.empty();
        }

    }


    //Com o Optional java8 mesmo metodo que converter string em Integer
    public static OptionalInt converteEmNumeroOptionalInt(String numeroEmStr){

        try {
            int integer = Integer.parseInt(numeroEmStr);
            return OptionalInt.of(integer);

        }catch (Exception e){

            return OptionalInt.empty();
        }

    }
}
