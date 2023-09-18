package threadsI.buscaTextual;

public class Principal {

    public static void main(String[] args) {

        String nome = "da";

        Thread threadAssinaturas1 = new Thread(new TarefaBuscaTextual("src/main/resources/assinaturas1.txt", nome));
        Thread threadAssinaturas2 = new Thread(new TarefaBuscaTextual("src/main/resources/assinaturas2.txt", nome));
        Thread threadAutores = new Thread(new TarefaBuscaTextual("src/main/resources/autores.txt", nome));

        threadAssinaturas1.start();
        threadAssinaturas2.start();
        threadAutores.start();
    }
}
