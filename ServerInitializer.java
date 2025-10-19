
import java.util.concurrent.CountDownLatch;


public class ServerInitializer{

    CountDownLatch latch;

    public ServerInitializer(CountDownLatch latch){
        this.latch = latch;
    }


    public void waitForInitialization(){
        try {
            latch.await();
            
        } catch (Exception e) {
        }
    }

    public void StartServer(){
        try {
            waitForInitialization();
            System.out.println("\n=======================================================================");
            System.out.println("Servidor Principal Online: Pronto para aceitar conexões (Socket.bind())");
            System.out.println("=======================================================================\n");
            System.out.println("[SISTEMA] Processo de inicialização concluído.\n");
        } catch (Exception e) {
        }
    }

}