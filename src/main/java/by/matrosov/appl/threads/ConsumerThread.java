package by.matrosov.appl.threads;

import by.matrosov.appl.ProducerConsumer;

public class ConsumerThread extends Thread{

    private ProducerConsumer producerConsumer;

    public ConsumerThread(ProducerConsumer producerConsumer) {
        this.producerConsumer = producerConsumer;
    }

    @Override
    public void run() {
        try {
            producerConsumer.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
