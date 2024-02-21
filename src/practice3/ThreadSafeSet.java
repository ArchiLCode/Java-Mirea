package practice3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class ThreadSafeSet<T> {
    private final Set<T> set;
    private final Semaphore semaphore;

    public ThreadSafeSet(int maxElements) {
        set = Collections.synchronizedSet(new HashSet<>());
        semaphore = new Semaphore(maxElements);
    }

    public void add(T element) throws InterruptedException {
        semaphore.acquire();
        try {
            set.add(element);
        }
        finally {
            semaphore.release();
        }
    }

    public void remove(T element) throws InterruptedException {
        semaphore.acquire();
        try {
            set.remove(element);
        }
        finally {
            semaphore.release();
        }
    }

    public int size() {
        return set.size();
    }

}