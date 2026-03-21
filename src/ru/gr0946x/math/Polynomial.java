package ru.gr0946x.math;

public class Polynomial {
    protected double[] coeff;
    public static final double EPS = 1.0E-50;

    public Polynomial() {
        this.coeff = new double[1];
        this.coeff[0] = (double)0.0F;
    }

    public Polynomial(double[] coeff) {
        this.coeff = (double[])(coeff).clone();
        this.correctPower();
    }

    public Polynomial(Polynomial p) {
        this.coeff = (double[])p.coeff.clone();
        this.correctPower();
    }

    private void correctPower() {
        int j;
        for(j = this.coeff.length; j > 1 && Math.abs(this.coeff[j - 1]) < 1.0E-50; --j) {
        }

        if (j < this.coeff.length) {
            double[] ncoeff = new double[j];
            System.arraycopy(this.coeff, 0, ncoeff, 0, j);
            this.coeff = ncoeff;
        }

    }

    public double get(int i) {
        return i >= 0 && i < this.coeff.length ? this.coeff[i] : Double.NaN;
    }

    public Polynomial plus(Polynomial other) {
        double[] nc = new double[Math.max(this.coeff.length, other.coeff.length)];
        int minl = Math.min(this.coeff.length, other.coeff.length);

        for(int i = 0; i < minl; ++i) {
            nc[i] = this.coeff[i] + other.coeff[i];
        }

        Polynomial longPol = this.coeff.length > other.coeff.length ? this : other;
        System.arraycopy(longPol.coeff, minl, nc, minl, nc.length - minl);
        return new Polynomial(nc);
    }

    public Polynomial times(double num) {
        double[] nc = new double[this.coeff.length];

        for(int i = 0; i < this.coeff.length; ++i) {
            nc[i] = num * this.coeff[i];
        }

        return new Polynomial(nc);
    }

    public Polynomial times(Polynomial other) {
        double[] nc = new double[other.getPower() + this.getPower() + 1];

        for(int i = 0; i < other.coeff.length; ++i) {
            for(int j = 0; j < this.coeff.length; ++j) {
                nc[i + j] += other.coeff[i] * this.coeff[j];
            }
        }

        return new Polynomial(nc);
    }

    public double invoke(double x) {
        double result = this.coeff[0];
        double p = x;

        for(int i = 1; i < this.coeff.length; ++i) {
            result += this.coeff[i] * p;
            p *= x;
        }

        return result;
    }

    public Polynomial minus(Polynomial other) {
        return this.plus(other.times((double)-1.0F));
    }

    public Polynomial div(double num) throws Exception {
        if (Math.abs(num) >= 1.0E-50) {
            return this.times((double)1.0F / num);
        } else {
            throw new Exception("Division by 0");
        }
    }

    public int getPower() {
        return this.coeff.length - 1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        for(int i = this.coeff.length - 1; i > 0; --i) {
            String sign = this.coeff[i - 1] >= 1.0E-15 ? "+" : "";
            s.append(!(Math.abs(this.coeff[i]) < 1.0E-15)
                    && !(Math.abs(this.coeff[i] - (double)1.0F) < 1.0E-15) ?
                    (Math.abs(this.coeff[i] + (double)1.0F) < 1.0E-15 ? "-" : this.coeff[i]) : "");
            s.append(Math.abs(this.coeff[i]) < 1.0E-15 ? "" : "x");
            s.append(i != 1 && !(Math.abs(this.coeff[i]) < 1.0E-15) ? "^" + i : "");
            s.append(sign);
        }

        s.append(!(Math.abs(this.coeff[0]) >= 1.0E-50) && this.coeff.length != 1 ? "" : this.coeff[0]);
        return s.toString();
    }
}

