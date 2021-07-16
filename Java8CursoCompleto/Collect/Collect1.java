package Collect;

import java.util.*;
import java.util.stream.Collectors;

public class Collect1 {

    public static void main(String[] args) {

        List <Integer> list = Arrays.asList(1,2,3,4,5,6);


        //Fornecedor - acumulação - combinação
        list.stream()
                //.collect(supplier, acumulator, combiner);
                .collect(() -> new ArrayList<>(), (l, e) -> l.add(e), (l1, l2) -> l1.add(l2) );

        System.out.println(list);

        //Com Set / Hashset

        Set<Integer> collect = list.stream()
                //.collect(supplier, acumulator, combiner);
                .collect(() -> new HashSet<>(), (l, e) -> l.add(e), (l1, l2) -> l1.addAll(l2) );

        System.out.println(collect);

        //Set de Strings
        Set<String> listaString = list.stream()
                //.collect(supplier, acumulator, combiner);
                .collect(() -> new HashSet<>(), (l, e) -> l.add(e.toString()), (l1, l2) -> l1.addAll(l2) );

        System.out.println(listaString);

        //Varios collector que já são implementados pelo proprio java
        //toList  Armazena Resultado em uma lista
        List<Integer> collect2 = list.stream()
                .collect(Collectors.toList());

        System.out.println(collect2);

        //Armazena Resultado para uma lista e usa o filtro que deixa passar só numeros pares
        List<Integer> collect3 = list.stream()
                .filter((n) -> n % 2 ==0)
                .collect(Collectors.toList());

        System.out.println(collect3);


        //toSet
        // Retorna um set
        Set<Integer> collect4 = list.stream()
                .filter((n) -> n % 2 ==0)
                .collect(Collectors.toSet());

        System.out.println(collect4);


        //toColleticon retorna o que você especificar

        Set<Integer> collect5 = list.stream()
                .filter((n) -> n % 2 ==0)
                .collect(Collectors.toCollection(() -> new TreeSet<>()));

        System.out.println(collect5);


        //Retornando uma LinkedList
        List<Integer> collect6 = list.stream()
                .filter((n) -> n % 2 ==0)
                .collect(Collectors.toCollection(() -> new LinkedList<>()));

        System.out.println(collect6);


        Deque<Integer> collect7 = list.stream()
                .filter((n) -> n % 2 ==0)
                .collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        System.out.println(collect7);


        //joing unir strings //mais preformatico pois usa o StringBuilder
        String join = list.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining(";"));

        System.out.println(join);
        
        
        //Fazer contas matematicas

        //repare que o Integer foi convertido para in no metodo inValue
        //Obter media
        Double media = list.stream()
                .collect(Collectors.averagingInt(n -> n.intValue()));

        System.out.println(media);


        //suming Soma tudo

        Integer soma = list.stream()
                .collect(Collectors.summingInt(n -> n.intValue()));

        System.out.println(soma);


        //sumarizing

        IntSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingInt(n -> n.intValue()));


        System.out.println(stats.getAverage()); //media
        System.out.println(stats.getMax()); //maior valor
        System.out.println(stats.getCount()); //quantos elementos
        System.out.println(stats.getMin()); //menor valor
        System.out.println(stats.getSum()); // soma tudo


        //couting quantos elementos tem
        Long quantos = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.counting());


        System.out.println(quantos);

        //Max/Min
        Optional<Integer> max = list.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println(max);

        list.stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);


        //groupingBy Faz o agrupamento dentro de um mapa
        Map<Integer, List<Integer>> grupo = list.stream()
                .collect(Collectors.groupingBy((n) -> n % 3));

        System.out.println(grupo);

        //partitionBy sempre agrupa em Boolean
        Map<Boolean, List<Integer>> grupopartiting = list.stream()
                .collect(Collectors.partitioningBy((n) -> n % 3 == 0));

        System.out.println(grupopartiting);

        //tomap
        Map<Integer, Integer> tomap = list.stream()
                .collect(Collectors.toMap(n -> n, n -> n * 2)); //primeiro a chave depois o valor

        System.out.println(tomap);

        //tomap potencia
        Map<Integer, Double> tomappotencia = list.stream()
                .collect(Collectors.toMap(n -> n, n -> Math.pow(n.doubleValue(), 5))); //primeiro a chave depois o valor

        System.out.println(tomappotencia);





    }

}
