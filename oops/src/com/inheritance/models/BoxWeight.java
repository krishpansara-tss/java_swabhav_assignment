package com.inheritance.models;

public class BoxWeight extends Box {

    private double weight;

    public BoxWeight(double weight, double length, double height, double width) {
        super(length, height, width);
        this.weight = weight;
    }

    public double getweight() {
        return weight;
    }

    public void setweight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "BoxWeight{" +
                "weight=" + weight +
                '}';
    }
}
