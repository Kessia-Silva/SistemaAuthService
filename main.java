
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main{
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(4);
        ServerInitializer server = new ServerInitializer(latch);

        executor.submit(new ModuleLoader("Configuração", 6, latch));
        executor.submit(new ModuleLoader("Cache", 9, latch));
        executor.submit(new ModuleLoader("Chaves de Criptografia", 12, latch));
        executor.submit(new ModuleLoader("Conexão de Log", 4, latch));

        executor.submit(() -> {
             server.StartServer();
        });

        executor.shutdown();
        
    }
}