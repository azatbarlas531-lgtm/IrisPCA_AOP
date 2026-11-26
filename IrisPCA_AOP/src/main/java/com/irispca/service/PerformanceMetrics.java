package com.irispca.service;

public class PerformanceMetrics {

    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public void printMetrics() {

        System.out.println(
                "\nPerformans Raporu");

        System.out.println(
                "Toplam Süre: "
                        + (endTime - startTime)
                        + " ms");
    }
}