package DebugLambda;

import java.util.Arrays;
import java.util.List;

public class DebugLambda {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,5,8,9);

        list.stream()
                .map((n) -> new StringBuilder().append(n).append("s").append("a"))
                .forEach(System.out::println);


        //Jeito mais fácil pra debugar
        list.stream()
                .map((n) -> {
                    StringBuilder builder = new StringBuilder();
                    builder.append(n);
                    builder.append("s");
                    builder.append("a");


                    return builder;
                })
                .forEach(System.out::println);


        //Pode ser feito através de metodo

        list.stream()
                .map((n) -> converteParaStringBuilder(n))
                .forEach(System.out::println);


        //peek passa em toda linha para log e debu
        list.stream()
                .peek(n -> System.out.println(n + "Passa em toda linha"))
                .map((n) -> converteParaStringBuilder(n))
                .forEach(System.out::println);




    }

    private static StringBuilder converteParaStringBuilder (Integer n) {
        StringBuilder builder = new StringBuilder();
        builder.append(n);
        builder.append("s");
        builder.append("a");


        return builder;
    }



}
