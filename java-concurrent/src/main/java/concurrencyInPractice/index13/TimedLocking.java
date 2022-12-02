package concurrencyInPractice.index13;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * TimedLocking 定时锁
 * <p/>
 * Locking with a time budget 带有时间限制的加锁
 *
 * @author Brian Goetz and Tim Peierls
 */
public class TimedLocking {
    private final Lock lock = new ReentrantLock();

    public boolean trySendOnSharedLine(String message,
                                       long timeout, TimeUnit unit)
            throws InterruptedException {
        long nanosToLock = unit.toNanos(timeout)
                - estimatedNanosToSend(message);
        if (!lock.tryLock(nanosToLock, NANOSECONDS))
            return false;
        try {
            return sendOnSharedLine(message);
        } finally {
            lock.unlock();
        }
    }

    private boolean sendOnSharedLine(String message) {
        /* send something */
        return true;
    }

    long estimatedNanosToSend(String message) {
        return message.length();
    }
}