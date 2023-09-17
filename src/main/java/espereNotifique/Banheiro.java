package espereNotifique;

public class Banheiro {

    private boolean ehSujo = true;

    public void fazNumero1() {

        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized(this) {
            System.out.println(nome + " entrando no banheiro");

            while(ehSujo) {
                esperaLaFora(nome);
            }
            System.out.println(nome + " fazendo coisa rapida");

            dorme(2000);

            this.ehSujo = true;

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mao");
            System.out.println(nome + " saindo do banheiro");
        }
    }

    public void fazNumero2() {

        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized(this) {

            System.out.println(nome + " entrando no banheiro");

             while(ehSujo) {
                esperaLaFora(nome);
            }
            System.out.println(nome + " fazendo coisa demorada");

            dorme(2000);

            this.ehSujo = true;

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " lavando a mao");
            System.out.println(nome + " saindo do banheiro");
        }
    }

    public void limpa() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized(this) {
            System.out.println(nome + " entrando no banheiro");

            if(!ehSujo) {
                System.out.println(nome + ", não está sujo, vou sair");
                return;
            }

            System.out.println(nome + " limpando banheiro");
            this.ehSujo = false;

            dorme(3000);

            this.notifyAll();

            System.out.println(nome + " saindo do banheiro");
        }
    }

    private void dorme(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void esperaLaFora(String nome) {
        System.out.println(nome + ", eca banheiro tá sujo");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
