package com.mezo.athena.thread;

public class Main {

    public static void main(String[] args) {
        Thread tat = new Thread(new TatRunnable());
        Thread tac = new Thread(new TacRunnable());
        long l1 = System.currentTimeMillis();
        tac.run();
        tat.run();
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);
    }
}
