import java.util.ArrayList;

public class Consumidor extends Thread{
    private final ArrayList<String> lista;
    private final int intervalo;
    private final int id;

    public Consumidor(ArrayList<String> lista, int intervalo, int id) {
        this.lista = lista;
        this.intervalo = intervalo;
        this.id = id;
    }

    public void run(){
        try {
            while(true){
                String valor;

                synchronized (this.lista){
                    while(this.lista.isEmpty()){
                        this.lista.wait();
                    }
                    valor = lista.remove(0);
                    System.out.printf("Consumidor %02d - Retirou '%s' da fila%n", id, valor);
                    this.lista.notifyAll();
                }
                Thread.sleep(intervalo);
            }
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }
}
