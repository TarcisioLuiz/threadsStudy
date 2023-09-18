package threadsI.deadlock;

public class TarefaAcessoBanco implements Runnable{

    private PoolDeConexao pool;
    private GerenciadorDeTransacao tx;

    public TarefaAcessoBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {

        synchronized (pool) {
            System.out.println("Peguei a chave do pool");
            pool.getConnection();

            synchronized (tx) {
                System.out.println("começando a gerenciar a tx");
                tx.begin();
            }
        }
    }
}
