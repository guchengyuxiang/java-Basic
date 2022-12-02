package concurrencyInPractice.index13;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/**
 * DeadlockAvoidance 避免死锁
 * <p/>
 * Avoiding lock-ordering deadlock using tryLock 通过使用tryLock避免顺序锁死锁
 * 出现原因：参数 fromAcct 与 toAcct 是不可控的 可能出现 A---》B B---》A 同时操作进行
 * @author Brian Goetz and Tim Peierls
 */
public class DeadlockAvoidance {
    private static final Random RANDOM = new Random();

    public boolean transferMoney(Account fromAcct, Account toAcct, DollarAmount amount, long timeout, TimeUnit unit)
            throws InsufficientFundsException, InterruptedException {
        long fixedDelay = getFixedDelayComponentNanos(timeout, unit);
        long randMod = getRandomDelayModulusNanos(timeout, unit);
        long stopTime = System.nanoTime() + unit.toNanos(timeout);

        while (true) {
            if (fromAcct.lock.tryLock()) {
                try {
                    if (toAcct.lock.tryLock()) {
                        try {
                            if (fromAcct.getBalance().compareTo(amount) < 0)
                                throw new InsufficientFundsException();
                            else {
                                fromAcct.debit(amount);
                                toAcct.credit(amount);
                                return true;
                            }
                        } finally {
                            toAcct.lock.unlock();
                        }
                    }
                } finally {
                    fromAcct.lock.unlock();
                }
            }
            if (System.nanoTime() < stopTime)
                return false;
            TimeUnit.NANOSECONDS.sleep(fixedDelay + RANDOM.nextLong() % randMod);
        }
    }

    private static final int DELAY_FIXED = 1;
    private static final int DELAY_RANDOM = 2;

    static long getFixedDelayComponentNanos(long timeout, TimeUnit unit) {
        return DELAY_FIXED;
    }

    static long getRandomDelayModulusNanos(long timeout, TimeUnit unit) {
        return DELAY_RANDOM;
    }

    static class DollarAmount implements Comparable<DollarAmount> {
        public int compareTo(DollarAmount other) {
            return 0;
        }

        DollarAmount(int dollars) {
        }
    }

    class Account {
        public Lock lock;

        void debit(DollarAmount d) {
        }

        void credit(DollarAmount d) {
        }

        DollarAmount getBalance() {
            return null;
        }
    }

    class InsufficientFundsException extends Exception {
    }
}
