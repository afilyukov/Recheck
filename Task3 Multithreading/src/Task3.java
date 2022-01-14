import java.util.concurrent.Semaphore;

public class Task3 {
    public static void main(String[] args) {

        //Do task 1
        Semaphore semaphore = new Semaphore(1);
        new Thread(new RunnableMove("Ping, ", semaphore)).start();
        new Thread(new RunnableMove("Pong, ", semaphore)).start();
    }
}
