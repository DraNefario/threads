class MinhaThreads extends Thread{
    private double[] vetor;
    private int inicio;
    private int fim;
    private int SIZE = 2_000_000;
    private int NUM_THREADS = 4;

    public MinhaThreads(double[] vetor, int inicio, int fim) {
        this.vetor = vetor;
        this.inicio = inicio;
        this.fim = fim;
    }
    public void run(){
        int chunkSize = SIZE / NUM_THREADS;

        for(int i = 0; i < NUM_THREADS; i++){
            inicio = i * chunkSize;
            int n = i + 1;
            if(n == 4){
                int fim = n * chunkSize;
            }else{
                int fim = (i + 1) * chunkSize - 1;
            }

            threads

        }


}


    public class Main {
    public static void main(String[] args) throws InterruptedException {
         int SIZE = 2_000_000;
         int NUM_THREADS = 4;
         double[] vetor = new double[SIZE];
         Thread[] threads = new Thread[NUM_THREADS];

    }
}