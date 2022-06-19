import toyanduser.ToyAndUser;

public class Main {
    public static void main(String[] args) {
        ToyAndUser toyAndUser = new ToyAndUser();

        Thread threadUser = new Thread(null, () -> toyAndUser.user(),"user");
        Thread threadToy = new Thread(null, () -> toyAndUser.toy(),"toy");
        threadUser.start();
        threadToy.start();

        try {
            threadUser.join();
            threadToy.interrupt();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
