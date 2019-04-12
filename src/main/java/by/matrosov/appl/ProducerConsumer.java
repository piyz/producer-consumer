package by.matrosov.appl;

public interface ProducerConsumer {
    void consume() throws InterruptedException;
    void produce() throws InterruptedException;
}
