
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main{
    public static void main(String[] args) {

        System.out.println("\n=======================================================================");
        System.out.println("                    Apolo Tech - AuthService");
        System.out.println("=======================================================================\n");
        
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(4);
        ServerInitializer server = new ServerInitializer(latch);

        try {
            executor.submit(new ModuleLoader("Configuração", 6, latch));
            executor.submit(new ModuleLoader("Cache", 9, latch));
            executor.submit(new ModuleLoader("Chaves de Criptografia", 12, latch));
            executor.submit(new ModuleLoader("Conexão de Log", 4, latch));

            executor.submit(() -> {
             server.startServer();
            });

            executor.shutdown();

            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                System.err.println("AVISO: Timeout na inicialização do servidor");
                executor.shutdownNow();
            }
            
        } catch (InterruptedException e) {
            System.err.println("ERRO CRÍTICO: Processo de inicialização interrompido");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("[SISTEMA] Processo de inicialização concluído.\n");
        
    }
}