package Collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Colletion2 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.forEach(n -> System.out.println(n)); //qualquer classe que implementa o Iterable da pra usar o foreach

        list.removeIf(n -> n % 2 ==0); //remove numero pares //qq classe que implementa o Comparable da pra usar o remove
        list.forEach(n -> System.out.println());
        list.replaceAll(n -> n * 2); //pega o numero e multiplica


        //Com map
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Show");
        map.put(1, "De");
        map.put(2, "Bola");

        map.forEach((k, v ) -> System.out.println(k + v));

        //Compute faz uma alteração no mapa especifivado pela chave //se não houver a chave ele cria o agora e deixa a chave como nulla
        map.compute(1, (k, v) -> v + "agora"); //1 é o id da chave do mapa mais o proprio valor do id 1 concatenado com agora
        map.forEach((k, v ) -> System.out.println(k + v));


        //merge //se não houver a chave ele cria o que foi passado em value
        map.merge(2, "!", (v1, v2) -> v1 + v2); //v1 é o valor bola e o v2 é a (!)
        map.forEach((k, v ) -> System.out.println(k + v));

        //replaceAll

        map.replaceAll((k, v) -> v + "!"); //coloca exclamação em todos os valores
        map.forEach((k, v) -> System.out.println(k + v));







    }
}
