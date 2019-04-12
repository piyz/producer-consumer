package by.matrosov.appl.threads;

import by.matrosov.appl.ProducerConsumer;

public class ProducerThread extends Thread {

    private ProducerConsumer producerConsumer;

    public ProducerThread(ProducerConsumer producerConsumer) {
        this.producerConsumer = producerConsumer;
    }

    @Override
    public void run() {
        try {
            producerConsumer.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
