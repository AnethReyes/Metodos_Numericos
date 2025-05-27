public class Euler {
    public static double[] resolver(Funcion f, double t0, double y0, double h, int pasos) {
        double[] y = new double[pasos+1];
        y[0] = y0;
        
        for (int i = 0; i < pasos; i++) {
            double t = t0 + i*h;
            y[i+1] = y[i] + h * f.evaluar(t, y[i]);
        }
        return y;
    }
    
    @FunctionalInterface
    public interface Funcion {
        double evaluar(double t, double y);
    }
}
