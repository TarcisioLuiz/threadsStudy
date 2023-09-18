package threadsI.colecoesThreadSafe;

public class TarefaAdicionarElemento implements Runnable {

    private Lista lista;
    private int numeroThread;

    public TarefaAdicionarElemento(Lista lista, int numeroThread) {
        this.lista = lista;
        this.numeroThread = numeroThread;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            lista.adicionarElementos("Thread " + numeroThread + " - " + i);
        }
    }
}
