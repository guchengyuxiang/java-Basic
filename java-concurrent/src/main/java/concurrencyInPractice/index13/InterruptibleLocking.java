package concurrencyInPractice.index13;

import java.util.concurrent.locks.*;

/**
 * InterruptibleLocking 可中断的锁获取
 *
 * @author Brian Goetz and Tim Peierls
 */
public class InterruptibleLocking {
    private Lock lock = new ReentrantLock();

    public boolean sendOnSharedLine(String message)
            throws InterruptedException {
        /**
         * 实现一个定时的与可中断的锁获取操作时可以使用 tryLock
         * lock.tryLock();
         */
        lock.lockInterruptibly();
        try {
            return cancellableSendOnSharedLine(message);
        } finally {
            lock.unlock();
        }
    }

    private boolean cancellableSendOnSharedLine(String message) throws InterruptedException {
        /* send something */
        return true;
    }

}
