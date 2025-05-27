public class RungeKutta4 {
    public static double[] resolver(Funcion f, double t0, double y0, double h, int pasos) {
        double[] y = new double[pasos+1];
        y[0] = y0;
        
        for (int i = 0; i < pasos; i++) {
            double t = t0 + i*h;
            double k1 = h * f.evaluar(t, y[i]);
            double k2 = h * f.evaluar(t + h/2, y[i] + k1/2);
            double k3 = h * f.evaluar(t + h/2, y[i] + k2/2);
            double k4 = h * f.evaluar(t + h, y[i] + k3);
            y[i+1] = y[i] + (k1 + 2*k2 + 2*k3 + k4)/6;
        }
        return y;
    }
}
