package threadsI.deadlock;

public class TarefaAcessoBancoProcedimento implements Runnable {

    private PoolDeConexao pool;
    private GerenciadorDeTransacao tx;

    public TarefaAcessoBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {

        synchronized (pool) {
            System.out.println("Começando a tx");
            pool.getConnection();

            synchronized (tx) {
                System.out.println("Peguei a conexão");
                tx.begin();
            }
        }
    }
}
