/**
 * Resuelve sistemas Ax = b usando Eliminación Gaussiana con pivoteo parcial
 * @param A Matriz de coeficientes (n x n)
 * @param b Vector de términos independientes
 * @return Solución x con redondeo a 2 decimales
 */
public class Gaussiana {
    
    public static double[] resolver(double[][] A, double[] b) {
        int n = b.length;
        
        // Eliminación hacia adelante con pivoteo
        for (int p = 0; p < n; p++) {
            // Pivoteo parcial
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p]; A[p] = A[max]; A[max] = temp;
            double t = b[p]; b[p] = b[max]; b[max] = t;
            
            // Eliminación
            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }
        
        // Sustitución hacia atrás
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
            x[i] = Math.round(x[i] * 100) / 100.0; // Redondeo
        }
        return x;
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        double[][] A = {{3, 2, -1}, {2, -2, 4}, {-1, 0.5, -1}};
        double[] b = {1, -2, 0};
        double[] x = resolver(A, b);
        System.out.println("Solucion: " + Arrays.toString(x)); 
        // Output: [1.0, -2.0, -2.0]
    }
}
