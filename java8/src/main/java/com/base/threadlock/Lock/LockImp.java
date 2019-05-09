package com.base.threadlock.Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockImp {

    private Lock lock = new ReentrantLock();

    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

    private List<Integer> list = new ArrayList<>();

    public void doReentLock(Thread thread) {
        lock.lock();
        System.out.println(thread.getName() + "获取锁");
        try {

            for (int i = 0; i < 10; i++) {
                list.add(i);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println(thread.getName() + "释放锁");
        }


    }

    public void doReentrantReadLock(Thread thread) {
        rwLock.readLock().lock();
        System.out.println(thread.getName() + "获取锁");

        try {
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
        }catch (Exception e) {

        }finally {
            rwLock.readLock().unlock();
            System.out.println(thread.getName() + "释放读锁");
        }


    }

    public void doReetrantWriteLock(Thread thread) {
        rwLock.writeLock().lock();
        System.out.println(thread.getName() + "获取锁");

        try {
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
            System.out.println(thread.getName() + "释放写锁");
        }
    }

    public static void main(String [] args) {
        final LockImp lockImp = new LockImp();
        final Thread thread1 = new Thread();
        final Thread thread2 = new Thread();
        final Thread thread3 = new Thread();

        new Thread(new Runnable() {
            @Override
            public void run() {
                  lockImp.doReentLock(thread1);
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                lockImp.doReentLock(thread2);
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                lockImp.doReentLock(thread3);
            }
        });

        lockImp.doReentrantReadLock(thread1);
        lockImp.doReentrantReadLock(thread2);
        lockImp.doReentrantReadLock(thread3);

        lockImp.doReetrantWriteLock(thread1);
        lockImp.doReetrantWriteLock(thread2);
        lockImp.doReetrantWriteLock(thread3);
    }

}
