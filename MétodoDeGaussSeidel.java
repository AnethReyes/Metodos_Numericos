/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package método.de.gauss.seidel;

import java.util.Scanner;

/**
 *
 * @author aneth
 */
public class MétodoDeGaussSeidel {

    /**
     * @param args the command line arguments
     */

    public static double[][] llenarmatrizCoeficientes(int n, Scanner scanner) {
        double[][] matriz = new double[n][n];
        System.out.println("Ingrese los coeficientes del sistema:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Ingrese el valor para la posicion [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextDouble();
            }
        }
        return matriz;
    }

    public static double[] llenarVectorTIndependientes(int n, Scanner scanner) {
        double[] vector = new double[n];
        System.out.println("Ingrese los terminos independientes:");
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el valor del termino independiente en la fila " + i + ": ");
            vector[i] = scanner.nextDouble();
        }
        return vector;
    }

    public static void mostrarmatriz(double[][] matriz, String nombre) {
        System.out.println("\n" + nombre + ":");
        for (double[] fila : matriz) {
            for (double elemento : fila) {
                System.out.printf("%.2f ", elemento);
            }
            System.out.println();
        }
    }

    public static double[] gaussSeidel(double[][] A, double[] b, double tol, int maxIter) {
        int n = A.length;
        double[] x = new double[n]; // Inicializamos la solución con ceros
        double[] xNuevo = new double[n];
        int iteraciones = 0;

        for (int iter = 0; iter < maxIter; iter++) {
            System.arraycopy(x, 0, xNuevo, 0, n);

            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma += A[i][j] * xNuevo[j];
                    }
                }
                xNuevo[i] = (b[i] - suma) / A[i][i];
            }

            // Verificar la convergencia
            double error = 0;
            for (int i = 0; i < n; i++) {
                error = Math.max(error, Math.abs(xNuevo[i] - x[i]));
            }
            
            if (error < tol) {
                System.out.println("Convergencia alcanzada en " + (iteraciones + 1) + " iteraciones.\n");
                return xNuevo;
            }

            System.arraycopy(xNuevo, 0, x, 0, n);
            iteraciones++;
        }
        System.out.println("Maximo numero de iteraciones alcanzado. El metodo puede no haber convergido.\n");
        return x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el numero de ecuaciones (y variables): ");
        int n = scanner.nextInt();

        double[][] A = llenarmatrizCoeficientes(n, scanner);
        double[] b = llenarVectorTIndependientes(n, scanner);

        System.out.println("\nMatriz ingresada:");
        mostrarmatriz(A, "Matriz de coeficientes");

        double[] soluciones = gaussSeidel(A, b, 1e-6, 100);
        System.out.println("Soluciones del sistema:");
        for (double sol : soluciones) {
            System.out.printf("%.3f ", sol);
        }

        scanner.close();
         }
}
