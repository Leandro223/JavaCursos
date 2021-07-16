package CirarStreams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CriarStreams {

    public static void main(String[] args) throws IOException {

        //Colleticon

        List<Integer> list = Arrays.asList(1,2,3,4);
        list.stream().forEach(System.out::println);


        //Array
        Integer[] intArray = new Integer[] {1,2,3,4};
        Arrays.stream(intArray).forEach(System.out::println);

        //Stream.of pode ser passado também qualquer coisa uma lista de clientes, carros

        Stream<String> of = Stream.of("Muito", "Bom", "Isso"); //,of pode passar qualquer coisa e sera transformado em string
        System.out.println(of);

        Stream.of("Mesma", "Coisa").forEach(System.out::println);


        //InStream.range
        IntStream.range(0, 5).forEach(System.out::println); //Começa do zero e o 5 é exclusivo não aparece
        //imprimi do zero ao 4

        IntStream.range(15, 20).forEach(System.out::println);
        //imprimi do 15 ao 19


        //Stream iterate
        Stream.iterate(5, n -> n * 2) //começa com 5 e depois faz ele vezes 2
                .limit(10)
                .forEach(System.out::println);


        //ler arquivos como strings
        File file = new File("c://streams.txt");
        FileReader in = new FileReader(file);
        try (BufferedReader br = new BufferedReader(in)) {
            br.lines().forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            in.close();

        }

        //Ver diretorios

        Path p = Paths.get("c://");
        Files.list(p).forEach(System.out::println);


        //Random cria 10 numeros aleatorios
        new Random().ints()
                .limit(10)
                .forEach(System.out::println);

        //Pattern
        String s = "Olha que legal";
        //Pattern pa = Pattern.compile("\\w"); //w quebra entre palavaras Regex
        Pattern pa = Pattern.compile(" "); //quebra entre espaço e poe em linha
        pa.splitAsStream(s).forEach(System.out::println); //igual o split mas contrario de um array do split ele devolve uma string mesmo


    }
}
