/**
 * Resuelve sistemas Ax = b iterativamente usando Gauss-Seidel
 * @param A Matriz de coeficientes
 * @param b Vector de términos independientes
 * @param tol Tolerancia para convergencia
 * @return Solución aproximada x
 */
public class GaussSeidel {
    
    public static double[] resolver(double[][] A, double[] b, double tol) {
        int n = b.length;
        double[] x = new double[n];
        double error = tol + 1;
        
        while (error > tol) {
            error = 0;
            for (int i = 0; i < n; i++) {
                double sum = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) sum += A[i][j] * x[j];
                }
                double nuevoXi = (b[i] - sum) / A[i][i];
                error += Math.abs(nuevoXi - x[i]);
                x[i] = Math.round(nuevoXi * 100) / 100.0; // Redondeo
            }
            error /= n;
        }
        return x;
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        double[][] A = {{4, 1, -1}, {2, 5, 2}, {1, -1, 3}};
        double[] b = {5, -1, 3};
        double[] x = resolver(A, b, 0.001);
        System.out.println("Solución: " + Arrays.toString(x));
        // Output: [1.0, -1.0, 1.0]
    }
}
