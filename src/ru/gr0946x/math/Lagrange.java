package ru.gr0946x.math;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Lagrange extends Polynomial{
    private final LinkedHashMap<Double, Double> points;

    public Lagrange(Map<Double, Double> points){
        this.points = new LinkedHashMap<>(points);
        create();
    }

    private void create(){
        var p = new Polynomial();
        for (var x: points.keySet()){
            p = p.plus(fundamental(x).times(points.get(x)));
        }
        coeff = p.coeff;
    }

    private Polynomial fundamental(double x){
        var p = new Polynomial(new double[]{1.0});
        for (var cx: points.keySet()){
            if (x == cx) continue;
            try {
                p = p.times(new Polynomial(new double[]{-cx, 1.0}).div(x - cx));
            } catch (Exception e){}
        }
        return p;
    }

    public void addPoint(double x, double y) {
        points.put(x, y);
        create();
    }
}
