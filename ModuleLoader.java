
import java.util.concurrent.CountDownLatch;


public class ModuleLoader implements Runnable{
    private final String modulo;
    private final int tempo;
    private final CountDownLatch latch;

    public ModuleLoader(String modulo, int tempo, CountDownLatch latch) {
        this.modulo = modulo;
        this.tempo = tempo;
        this.latch = latch;
    }

    @Override
    public void run(){
        try {
            System.out.println("[CARREGANDO] " + "Módulo " + modulo + " iniciando...");
            Thread.sleep(1000*tempo);
            System.out.println("[OK] " + "Módulo " + modulo + " carregado");
            latch.countDown();
        } catch (Exception e) {
            System.err.println("[ERRO] Falha no carregamento do módulo " + modulo);
            Thread.currentThread().interrupt();
        }
    }
    
}