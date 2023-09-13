package exercicio;

public class ImprimirNumeros implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<1000;i++) {
            Thread threadAtual = Thread.currentThread();
            System.out.println(threadAtual.getId() + " - " + i);
        }
    }
}

class PrincipalOrdemDeExecucao {

    public static void main(String[] args) {
        new Thread(new ImprimirNumeros ()).start();
        new Thread(new ImprimirNumeros ()).start();
    }
}
