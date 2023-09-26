package threadsII.servidor;

import java.util.concurrent.ThreadFactory;

public class FabricaDeThreads implements ThreadFactory {

    private ThreadFactory defaultFactory;
    //static int numero = 1;


    public FabricaDeThreads(ThreadFactory defaultFactory) {
        this.defaultFactory = defaultFactory;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = defaultFactory.newThread(r);
        //numero++;

        thread.setUncaughtExceptionHandler(new TratadorDeExcecao());
        //thread.setDaemon(true);
        return thread;
    }
}
