package com.irispca.model;

public class IrisRecord {

    private double sepalLength;
    private double sepalWidth;
    private double petalLength;
    private double petalWidth;
    private String species;

    public IrisRecord(double sepalLength,
                      double sepalWidth,
                      double petalLength,
                      double petalWidth,
                      String species) {

        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.species = species;
    }

    public double[] getFeatures() {
        return new double[]{
                sepalLength,
                sepalWidth,
                petalLength,
                petalWidth
        };
    }

    public String getSpecies() {
        return species;
    }
}