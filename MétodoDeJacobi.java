/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package método.de.jacobi;
/**
 *
 * @author aneth
 */
public class MétodoDeJacobi {
    public static void jacobi(double[][] A, double[] b, double[] x, double tolerance, int maxIterations) {
        int n = b.length;
        double[] xNew = new double[n];
        int iterations = 0;

        while (iterations < maxIterations) {
            for (int i = 0; i < n; i++) {
                double sum = 0.0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        sum += A[i][j] * x[j];
                    }
                }
                xNew[i] = (b[i] - sum) / A[i][i];
            }

            // Verificar convergencia
            double error = 0.0;
            for (int i = 0; i < n; i++) {
                error += Math.abs(xNew[i] - x[i]);
            }
            if (error < tolerance) {
                System.out.println("Convergencia alcanzada en " + iterations + " iteraciones.");
                break;
            }

            // Actualizar x para la siguiente iteración
            System.arraycopy(xNew, 0, x, 0, n);
            iterations++;
        }

        if (iterations == maxIterations) {
            System.out.println("Maximo de iteraciones alcanzado.");
        }
    }

    public static void main(String[] args) {
        // Definir la matriz A y el vector b
            double[][] A = {
        {10, 2, 1},
        {1, 10, 2},
        {2, 3, 10}
    };
    double[] b = {7, 8, 9};

        // Inicializar el vector x con ceros
        double[] x = {0, 0, 0};

        // Parámetros del método
        double tolerance = 0.001;
        int maxIterations = 100;

        // Resolver el sistema
        jacobi(A, b, x, tolerance, maxIterations);

        // Mostrar la solución
        System.out.println("Solucion:");
        System.out.printf("x = %.3f\n", x[0]);
        System.out.printf("y = %.3f\n", x[1]);
        System.out.printf("z = %.3f\n", x[2]);

        }
}

