package toyanduser;

public class ToyAndUser extends Thread{
    private volatile boolean open;
    private final int WAIT = 2000;

    public void user() {
        int i = 0;
        while (i < 4) {
            i++;
            System.out.println("Нажал");
            open = true;

            try {
                Thread.sleep(WAIT);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void toy() {

        while (true) {
            if (Thread.currentThread().isInterrupted()) return;
            if (open){
                open = false;
                System.out.println("Закрыл");
            }
        }
    }
}
