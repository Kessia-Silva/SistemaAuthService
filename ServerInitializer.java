
import java.util.concurrent.CountDownLatch;


public class ServerInitializer{

    private final CountDownLatch latch;

    public ServerInitializer(CountDownLatch latch){
        this.latch = latch;
    }

    public void waitForInitialization() throws InterruptedException{
            latch.await();
    }

    public void startServer(){
        try {
            System.out.println("\n[SERVIDOR] Aguardando carregamento de módulos críticos...\n");
            waitForInitialization();
            System.out.println("\n=======================================================================");
            System.out.println("Servidor Principal Online: Pronto para aceitar conexões (Socket.bind())");
            System.out.println("=======================================================================\n");
        } catch (InterruptedException e) {
            System.err.println("Erro: Inicialização do servidor interrompida - " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

}