package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Streams {

    public static void main(String[] args) {

        //como fica no javas anteriores

        List<Integer> lista = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);

        //Java5
        for (Integer integer : lista){
            System.out.println(integer);

        }


        //java8
        // Stream é um fluxo de dados
        lista.stream().forEach(e -> System.out.println(e));

        //skip ignora os 2 primeiros elementos
        lista.stream()
                .skip(2) // operação intermediaria
                .forEach(e -> System.out.println(e));

        //Limit igonra a sucessão de elementos apos o indicado *imprime abaixo 1, 5 apenas
        lista.stream()
                .limit(2) // operação intermediaria
                .forEach(e -> System.out.println(e));


        //Não deixa elementos repetidos se repetir
        lista.stream()
                .distinct() // usa o equals e o hascode    //se a classe for sua implemente o equals e o hascode
                .forEach(e -> System.out.println(e));


        //usando os 3 todos intermediarios
        lista.stream()
                .skip(2)
                .limit(3)
                .distinct()
                .forEach(e -> System.out.println(e));

        //filter permite personalizar
        lista.stream()
                .filter(e -> e % 2 == 0) //só vai imprimir pares
                .forEach(e -> System.out.println(e));


        lista.stream()
                .map(e -> e * 2) //mutiplica os numeros da lista por 2
                .forEach(e -> System.out.println(e));

        //a lista original não é modificada


        //Operações Finais

        //count conta elementos em um lista
        long count = lista.stream()
                .map(e -> e * 2)
                .count();

        System.out.println(count);
        //imprime 11


        //count conta elementos em um lista
        long count2 = lista.stream()
                .filter(e -> e % 2 == 0)
                .count();

        System.out.println(count2);
        //imprime 11


        //Usando o min que utiliza o comparator no exemplo usa do Integer mas se implementar na usa classe mesmo é só passar
        Optional<Integer> min = lista.stream()
                .filter(e -> e % 2 == 0)
                .min(Comparator.naturalOrder());
                //max devolve o 8

        System.out.println(min.get());
        //imprime o menor valor

        //collect
        List <Integer> novaLista = lista.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(novaLista);
        //imprime uma nova lista com os novos valores

        //Armazenando em um Map os numeros que o resto da divisão é par true e o impar false

        Map<Boolean, List<Integer>> mapa = lista.stream() // Uma mapa que armazena bollean
                .map(e -> e * 3) // pega a lista intera e multiplica por 3
                .collect(Collectors.groupingBy(e -> e % 2 == 0));

        System.out.println(mapa);






        Map<Integer, List<Integer>> collect = lista.stream()
                .collect(Collectors.groupingBy(e -> e % 3));


        System.out.println(collect);
        //imprimi resto que dividi por 3 e o restante é zero, que é 1, que é 2


        //Joing agrupa somente String
        String minhaColecao = lista.stream() //pode usar paralleStream()
                .map(e -> String.valueOf(e))
                .collect(Collectors.joining(";"));

        System.out.println(minhaColecao);
//        imprimi os numeros agora convertido de integer para string separado por ponto e virgula












    }
}
