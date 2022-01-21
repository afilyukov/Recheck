import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private final Lock lock = new ReentrantLock();
    private int counter;

    public Counter (int counter) {
        this.counter = counter;
    }

    public boolean increment() {
        try {
            lock.lock();
            counter++;
            return true;
           } catch(Exception e) {return false;}
        finally {
            lock.unlock();
        }

    }

    public boolean decrement() {
        try {
            lock.lock();
            counter--;
            return true;
        } catch(Exception e) {return false;}
        finally {
            lock.unlock();
        }
    }

    public int getCounterValue(){
        try {
            lock.lock();
            return counter;
        } finally {
            lock.unlock();
        }
    }
}
