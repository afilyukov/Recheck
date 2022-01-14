import java.util.concurrent.Semaphore;

public class RunnableMove implements Runnable{
    private final String move;
    private final Semaphore semaphore;

    public RunnableMove(String move, Semaphore semaphore) {
        this.move = move;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                semaphore.acquire();
                System.out.println(this.move);
                semaphore.release();
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
