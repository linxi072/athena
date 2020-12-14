package com.mezo.athena.thread;

public class TatRunnable implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
