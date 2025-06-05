import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int intervaloProdutor = 2000;
        int intervaloConsumidor = 3000;

        ArrayList<String> listaCompartilhada = new ArrayList<>(10);

        System.out.println("Sistema iniciado com:");
        System.out.println("- 3 produtores (intervalo: " + intervaloProdutor + "s)");
        System.out.println("- 2 consumidores (intervalo: " + intervaloConsumidor + "s)");

        // Cria e inicia 3 threads de produtor
        for (int i = 1; i <= 3; i++) {
            new Thread(new Produtor(listaCompartilhada, intervaloProdutor, i)).start();
        }

        // Cria e inicia 2 threads de consumidor
        for (int i = 1; i <= 2; i++) {
            new Thread(new Consumidor(listaCompartilhada, intervaloConsumidor, i)).start();
        }
    }
}
