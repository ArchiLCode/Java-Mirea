package practice4;

public class Main {
    public static void main(String[] args) {
        CustomExecutorService executorService = new CustomExecutorService(2);
        executorService.execute(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Second");
        });

        executorService.execute(() -> System.out.println("First"));
        executorService.shutdown();
    }
}