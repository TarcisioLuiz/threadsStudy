package colecoesThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Principal {

    public static void main(String[] args) throws InterruptedException{

        Lista lista = new Lista();

        //List<String> lista = Collections.synchronizedList(new ArrayList<>());

        for(int i = 0; i < 10; i++) {
            new Thread(new TarefaAdicionarElemento(lista, i)).start();
        }

        new Thread(new TarefaImprimir(lista)).start();

        Thread.sleep(2000);

    }
}
