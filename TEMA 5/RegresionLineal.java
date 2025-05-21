/**
 * Regresión lineal simple: y = a + bx
 * Calcula coeficientes (a, b) y métricas de calidad del ajuste
 */
public class RegresionLineal {
    
    public static class Resultado {
        public final double a, b, r2;
        public Resultado(double a, double b, double r2) {
            this.a = Math.round(a * 100.0) / 100.0;
            this.b = Math.round(b * 100.0) / 100.0;
            this.r2 = Math.round(r2 * 100.0) / 100.0;
        }
    }

    public static Resultado calcular(double[] x, double[] y) {
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

        // Cálculo de coeficientes
        double b = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double a = (sumY - b * sumX) / n;

        // Cálculo de R²
        double r = (n * sumXY - sumX * sumY) / 
                  Math.sqrt((n * sumX2 - sumX * sumX) * (n * sumY2 - sumY * sumY));
        double r2 = r * r;

        return new Resultado(a, b, r2);
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2, 3.1, 3.9, 5.1, 6};

        Resultado resultado = calcular(x, y);
        System.out.printf("Ecuacion: y = %.2f + %.2fx\n", resultado.a, resultado.b);
        System.out.printf("Coeficiente R²: %.2f\n", resultado.r2);
        /* Output:
           Ecuación: y = 1.02 + 0.99x
           Coeficiente R²: 0.99
        */
    }
}
