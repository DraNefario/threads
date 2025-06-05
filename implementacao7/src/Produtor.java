import java.util.ArrayList;
import java.util.Random;

public class Produtor extends Thread{
    private final ArrayList<String> lista;
    private final Random rm = new Random();
    private final int intervalo;
    private final int id;

    public Produtor (ArrayList<String> lista, int intervalo, int id) {
        this.lista = lista;
        this.id = id;
        this.intervalo = intervalo;
    }

    public void run(){
        try {
            while (true){
                String valor = String.valueOf(rm.nextInt(100));

                synchronized (lista){
                    while (this.lista.size() >= 5){
                        this.lista.wait();
                    }

                    lista.add(valor);
                    System.out.printf("Produtor %02d - Inseriu '%s' na fila%n", id, valor);
                    lista.notifyAll();
                }
                Thread.sleep(intervalo);
            }
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }
}
