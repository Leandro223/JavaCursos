package Lambda;

import java.util.stream.IntStream;

public class Lambda {
    public static void main(String[] args) {

        IntStream.range(0, 5)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);


        //quando quer declarar o tipo da variavel coloca entre parentes
        IntStream.range(0, 5)
                .filter((int n) -> n % 2 == 0)
                .forEach(System.out::println);


        IntStream.range(0, 5)
                .filter((int n) -> n % 2 == 0)
                .reduce((n1, n2) -> n1 + n2) //pega os pares e soma  //tem que colocar parentes quando tem dois arguementos
                .ifPresent(System.out::println);

        IntStream.range(0, 5)
                .filter((int n) -> n % 2 == 0)
                .reduce((int n1, int n2) -> n1 + n2) //pega os pares e soma  //tem que colocar parentes quando tem dois arguementos
                .ifPresent(System.out::println); //se colocar o tipo tem que colocar nos dois


        //Con {} chaves é possível passar mais de uma expressão
        IntStream.range(0, 5)
                .filter(n -> {
                    System.out.println("Pulando Linha");
                    return n % 2 == 0; }).forEach(n -> System.out.println(n));






    }
}
