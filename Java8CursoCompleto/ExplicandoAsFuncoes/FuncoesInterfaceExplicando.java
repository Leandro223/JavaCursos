package ExplicandoAsFuncoes;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class FuncoesInterfaceExplicando {
    public static void main(String[] args) {

        Stream.generate(() -> new Random().nextInt()) //supplier Fornecedor não recebe nada só entrega valor
                .limit(5)
                .forEach((e) -> System.out.println(e)); //consumer recebe e não entrega nada

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream()
                .filter(e -> e % 2 == 0) //predicate recebe um valor e compara true ou falsa
                .map(e -> e.doubleValue()) // function  recebe um valor e entrega outro
                .reduce((e1, e2) -> e1 +e2) //BinaryOperator recebe um ou dois valores e entrega do mesmo tipo
                .ifPresent(System.out::println);
    }

}
