public class Taylor2 {
    public static double[] resolver(Funcion f, Funcion df, double t0, double y0, double h, int pasos) {
        double[] y = new double[pasos+1];
        y[0] = y0;
        
        for (int i = 0; i < pasos; i++) {
            double t = t0 + i*h;
            y[i+1] = y[i] + h*f.evaluar(t, y[i]) + (h*h/2)*df.evaluar(t, y[i]);
        }
        return y;
    }
}
