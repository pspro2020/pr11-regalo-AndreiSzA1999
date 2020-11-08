import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Alumnos implements Runnable {

    protected int dinero;
    protected String alumno;
    protected final Hermano hermano;

    public Alumnos(int dinero, Hermano hermano, String alumno) {

        this.dinero = dinero;
        this.alumno = alumno;
        this.hermano = hermano;
    }


    @Override
    public void run() {
        try{
            añadir_dinero();
        }
        catch (InterruptedException e){
            System.out.println("He sido interrumpido");
        }


       if(hermano.countDownLatch.getCount() != 0 ) {
           hermano.agregar_dinero(dinero, alumno);
       }
    }


    private void añadir_dinero() throws InterruptedException {

        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(3, 11));
    }
}