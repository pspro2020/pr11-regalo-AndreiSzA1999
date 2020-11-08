import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;

public class Hermano implements Runnable {


    protected final CountDownLatch countDownLatch;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    public Hermano(int dinero_necesario) {
        countDownLatch = new CountDownLatch(dinero_necesario);
    }


    @Override
    public void run() {
        System.out.printf("%s -> Esperando a que haya el suficiente dinero \n", LocalTime.now().format(dateTimeFormatter));
        try{

            countDownLatch.await();
            System.out.printf("%s -> Tenemos el dinero necesario, voy a comprar el regalo.. \n", LocalTime.now().format(dateTimeFormatter));


        } catch (InterruptedException e) {
            System.out.println("He sido interrumpido");
        }
    }


    public void agregar_dinero(int dinero, String alumno){

        System.out.printf("%s -> %s ha añadido %d euros para el regalo \n", LocalTime.now().format(dateTimeFormatter),alumno,dinero);

        for(int i = 0; i<dinero;i++){
            countDownLatch.countDown();
        }
    }
}


