package by.matrosov.appl;

import by.matrosov.appl.threads.ConsumerThread;
import by.matrosov.appl.threads.ProducerThread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerImpl pc = new ProducerConsumerImpl();

        ConsumerThread consumerThread = new ConsumerThread(pc);
        ProducerThread producerThread = new ProducerThread(pc);

        consumerThread.start();
        producerThread.start();

        consumerThread.join();
        producerThread.join();
    }
}
