package practice3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeList<T> {
    private final List<T> list;
    private final Lock lock;

    public ThreadSafeList() {
        list = new ArrayList<>();
        lock = new ReentrantLock();
    }

    public void add(T element) {
        lock.lock();
        try {
            list.add(element);
        } finally {
            lock.unlock();
        }
    }

    public void remove(T element) {
        lock.lock();
        try {
            list.remove(element);
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return list.size();
    }
}