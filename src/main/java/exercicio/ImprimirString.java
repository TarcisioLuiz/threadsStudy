package exercicio;

public class ImprimirString implements Runnable{

    @Override
    public void run() {
        System.out.println("Teste impressão a partir de uma thread!");
    }

    public static void main(String[] args) {
        ImprimirString imprimirString = new ImprimirString();

        Thread thread = new Thread(imprimirString);
        thread.start();
    }

}

