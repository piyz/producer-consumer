package by.matrosov.appl;

import by.matrosov.appl.threads.ConsumerThread;
import by.matrosov.appl.threads.ProducerThread;

import java.util.LinkedList;

public class ProducerConsumerImpl implements ProducerConsumer{

    private static LinkedList<Integer> list = new LinkedList<>();
    private static final int capacity = 3;

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerImpl pc = new ProducerConsumerImpl();

        ConsumerThread consumerThread = new ConsumerThread(pc);
        ProducerThread producerThread = new ProducerThread(pc);

        consumerThread.start();
        producerThread.start();

        consumerThread.join();
        producerThread.join();
    }

    @Override
    public void consume() throws InterruptedException {
        while (true){
            synchronized (this){
                while (list.size() == 0){
                    wait();
                }

                int value = list.removeFirst();
                System.out.println("Consumer consumed- " + value);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    @Override
    public void produce() throws InterruptedException {
        int value = 0;
        while (true){
            synchronized (this){
                while (list.size() == capacity){
                    wait();
                }

                System.out.println("Producer produced - " + value);
                list.add(value++);
                notify();
                Thread.sleep(1000);
            }
        }
    }
}
