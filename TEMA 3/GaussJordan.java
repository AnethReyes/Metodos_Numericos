/**
 * Transforma la matriz aumentada [A|b] a forma escalonada reducida (matriz identidad)
 * Útil para calcular matrices inversas y resolver sistemas múltiples
 */
public class GaussJordan {
    
    public static double[] resolver(double[][] A, double[] b) {
        int n = b.length;
        double[][] aumentada = new double[n][n+1];
        
        // Crear matriz aumentada [A|b]
        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, aumentada[i], 0, n);
            aumentada[i][n] = b[i];
        }
        
        // Reducción a forma escalonada reducida
        for (int p = 0; p < n; p++) {
            // Pivoteo parcial
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(aumentada[i][p]) > Math.abs(aumentada[max][p])) {
                    max = i;
                }
            }
            double[] temp = aumentada[p];
            aumentada[p] = aumentada[max];
            aumentada[max] = temp;
            
            // Hacer 1 en la diagonal
            double pivote = aumentada[p][p];
            for (int j = p; j <= n; j++) {
                aumentada[p][j] /= pivote;
            }
            
            // Hacer ceros en otras filas
            for (int i = 0; i < n; i++) {
                if (i != p && aumentada[i][p] != 0) {
                    double factor = aumentada[i][p];
                    for (int j = p; j <= n; j++) {
                        aumentada[i][j] -= factor * aumentada[p][j];
                    }
                }
            }
        }
        
        // Extraer solución
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = Math.round(aumentada[i][n] * 100) / 100.0;
        }
        return x;
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        double[][] A = {{2, 1, -1}, {-3, -1, 2}, {-2, 1, 2}};
        double[] b = {8, -11, -3};
        double[] x = resolver(A, b);
        System.out.println("Solución: " + Arrays.toString(x));
        // Output: [2.0, 3.0, -1.0]
    }
}
