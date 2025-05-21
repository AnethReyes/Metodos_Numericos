/**
 * Cálculo del coeficiente de correlación de Pearson (r)
 * Mide la relación lineal entre dos variables (-1 ≤ r ≤ 1)
 */
public class Correlacion {
    
    public static double calcular(double[] x, double[] y) {
        if (x.length != y.length) throw new IllegalArgumentException("x e y deben tener igual longitud");

        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0, sumY2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
            sumY2 += y[i] * y[i];
        }

        double numerador = n * sumXY - sumX * sumY;
        double denominador = Math.sqrt((n * sumX2 - sumX * sumX) * (n * sumY2 - sumY * sumY));
        
        double r = numerador / denominador;
        return Math.round(r * 100.0) / 100.0;
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2, 3.1, 3.9, 5.1, 6};

        double r = calcular(x, y);
        System.out.printf("Coeficiente de correlación (r): %.2f\n", r);
        // Output: Coeficiente de correlación (r): 0.99
    }
}
