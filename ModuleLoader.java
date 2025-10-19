
import java.util.concurrent.CountDownLatch;


public class ModuleLoader implements Runnable{
    String modulo;
    int tempo;
    CountDownLatch latch;

    public ModuleLoader(String modulo, int tempo, CountDownLatch latch) {
        this.modulo = modulo;
        this.tempo = tempo;
        this.latch = latch;
    }

    public void run(){
        try {
            System.out.println("[CARREGANDO] " + "Módulo " + modulo + " iniciando...");
            Thread.sleep(1000*tempo);
            System.out.println("[OK] " + "Módulo " + modulo + " carregado");
            latch.countDown();
        } catch (Exception e) {
        }
    }

    

}