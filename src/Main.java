import java.util.concurrent.ThreadLocalRandom;

public class Main {


    public static void main(String[] args) {
        final int DINERO =10;


        Hermano hermano = new Hermano(DINERO);

        new Thread(hermano).start();


        for(int i = 0; i < 5; i++){

            new Thread(new Alumnos(
                    ThreadLocalRandom.current().nextInt(2,6),
                    hermano, "Alumno " + (i+1))).start();

        }

    }
}
