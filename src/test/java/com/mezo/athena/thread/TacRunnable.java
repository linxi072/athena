package com.mezo.athena.thread;

public class TacRunnable implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
