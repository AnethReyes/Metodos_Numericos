/**
 * Ajuste de recta por mínimos cuadrados (y = a + bx)
 * Minimiza la suma de los cuadrados de los residuos
 */
public class MinimosCuadrados {
    
    public static double[] ajustarRecta(double[] x, double[] y) {
        if (x.length != y.length) throw new IllegalArgumentException("x e y deben tener igual longitud");
        
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
        
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }
        
        double b = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double a = (sumY - b * sumX) / n;
        
        return new double[]{
            Math.round(a * 100.0) / 100.0,
            Math.round(b * 100.0) / 100.0
        };
    }

    // Ejemplo: Ajustar recta a puntos (1,1), (2,2), (3,2)
    public static void main(String[] args) {
        double[] x = {1, 2, 3};
        double[] y = {1, 2, 2};
        double[] coef = ajustarRecta(x, y);
        System.out.printf("Ecuacion: y = %.2f + %.2fx\n", coef[0], coef[1]);
        // Output: y = 0.67 + 0.50x
    }
}
