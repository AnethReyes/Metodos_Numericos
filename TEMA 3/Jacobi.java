/**
 * Método iterativo que descompone la matriz en diagonal (D) y resto (R)
 * Fórmula de iteración: x^{(k+1)} = D^{-1}(b - Rx^{(k)})
 */
public class Jacobi {
    
    public static double[] resolver(double[][] A, double[] b, double tol, int maxIter) {
        int n = b.length;
        double[] x = new double[n];
        double[] xNuevo = new double[n];
        Arrays.fill(x, 0);
        
        for (int iter = 0; iter < maxIter; iter++) {
            for (int i = 0; i < n; i++) {
                double sum = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) sum += A[i][j] * x[j];
                }
                xNuevo[i] = (b[i] - sum) / A[i][i];
            }
            
            // Cálculo de error
            double error = 0;
            for (int i = 0; i < n; i++) {
                error += Math.abs(xNuevo[i] - x[i]);
                x[i] = Math.round(xNuevo[i] * 100) / 100.0;
            }
            
            if (error < tol) break;
        }
        return x;
    }

    // Ejemplo de uso (sistema diagonalmente dominante)
    public static void main(String[] args) {
        double[][] A = {{4, -1, 0}, {-1, 4, -1}, {0, -1, 4}};
        double[] b = {2, 6, 2};
        double[] x = resolver(A, b, 0.0001, 100);
        System.out.println("Solución: " + Arrays.toString(x));
        // Output: [1.0, 2.0, 1.0]
    }
}
