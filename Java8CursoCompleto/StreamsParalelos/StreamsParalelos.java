package StreamsParalelos;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsParalelos {
    public static void main(String[] args) {
        //ganhar performace

        List<Integer> list = Arrays.asList(1,2,3,4);

        //tornando paralelo
        IntStream.range(0, 5).parallel().forEach(System.out::println);

        //na lista chama direto o paralleStream
        //list.parallelStream()

        list.parallelStream()
                .forEach(System.out::println); //imprimi de forma aleatoria

        list.parallelStream()
                .forEachOrdered(System.out::println); //imprimi na ordem

        //findAnny pega o primeiro elemento pronto
        list.parallelStream()
                .findAny()
                .ifPresent(System.out::println); //retorna aleatorio pois a primeira treead que terminar entrega o elemento

        list.stream()
                .findAny()
                .ifPresent(System.out::println); //sempre retorna o 1 pois as treeads trabalha em conjunto


        //unordered use para dizer que não precisa de ordem ou seja o skip irá pular qualquer elemento que esteja pronto e o limite também //Com isso ganhe performace nas treeads

        list.parallelStream()
                .unordered() //distintic também se aplica
                .skip(1)
                .limit(2)
                .forEachOrdered(System.out::println);


        //reduce só pode usar parallelStream se for associativa tipo soma pois a ordem não importa o resultado será o mesmo. Na subtração não pode a ordem altera o resultado

        list.parallelStream()
                .reduce((n1, n2) -> n1 + n2)
                .ifPresent(System.out::println);

        //Collect
        //abaixo varios mapas serão criados com toMap para cada tread tornando muito custoso use o toConcurrentMap pois um unico mapa será criado e depois as treeads vão usar a operações realizadas e popular um unico mapa

        Map<Integer, Boolean> collect = list.parallelStream()
                .collect(
                        Collectors
                        .toMap(n -> n, n -> n % 2 == 0) //true ou false dependo de par ou impar
                );
        System.out.println(collect);


        //sofre o mesmo problema acima do toMap use o groupinbyConcurrent abaixo ambos não tem garantia de ordem
        Map<Boolean, List<Integer>> collect2 = list.parallelStream()
                .collect(
                        Collectors
                                .groupingBy(n -> n % 2 == 0) // agrupa true ou false dependo de par ou impar
                );
        System.out.println(collect2);






    }
}
