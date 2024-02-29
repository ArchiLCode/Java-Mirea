package practice3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadSafeSet<Integer> mySet = new ThreadSafeSet<>(5);
        ThreadSafeList<String> myList = new ThreadSafeList<>();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread thread1 = new Thread(() -> {
                try {
                    mySet.add(finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread1.start();
            thread1.join();
            Thread thread2 = new Thread(() -> {
                try {
                    mySet.remove(finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread2.start();
            thread2.join();
        }
        System.out.println("Размер множества после добавления и удаления элеметов: " + mySet.size());

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            myList.add("Element" + 3);
        });
        executorService.execute(() -> {
            myList.remove("Element" + 3);
        });
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Размер списка после добавления и удаления элеметов: " + myList.size());
    }
}
