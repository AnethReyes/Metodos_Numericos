/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package método.de.gauss.jordan;

import java.text.DecimalFormat;

/**
 *
 * @author aneth
 */
public class MétodoDeGaussJordan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                DecimalFormat df = new DecimalFormat("#.####");

        // Definimos el sistema de ecuaciones directamente
        int n = 3;
        double[][] matrix = {
            {2, 1, 1, 6},
            {3, 0, 5, 6},
            {2, 1, 3, 7}
        };

        System.out.println("Sistema de ecuaciones:");
        printMatrix(matrix, n, df);

        System.out.println("\n Procedimiento paso a paso:");
        gaussJordan(matrix, n, df);
    }

    public static void gaussJordan(double[][] matrix, int n, DecimalFormat df) {
        for (int i = 0; i < n; i++) {
            // 1. Hacer el pivote igual a 1
            double pivot = matrix[i][i];

            if (pivot == 0) {
                System.out.println("No se puede resolver: hay un pivote cero.");
                return;
            }

            System.out.println("\n Dividiendo fila " + (i + 1) + " por " + df.format(pivot));
            for (int j = 0; j < n + 1; j++) {
                matrix[i][j] /= pivot;
            }
            printMatrix(matrix, n, df);

            // 2. Hacer ceros en las demás filas
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matrix[k][i];
                    System.out.println("\n Eliminando elemento en fila " + (k + 1) + ", columna " + (i + 1));

                    for (int j = 0; j < n + 1; j++) {
                        matrix[k][j] -= factor * matrix[i][j];
                    }
                    printMatrix(matrix, n, df);
                }
            }
        }

        // Mostrar la solución
        System.out.println("\n Solucion del sistema:");
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + df.format(matrix[i][n]));
        }
    }

    public static void printMatrix(double[][] matrix, int n, DecimalFormat df) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(df.format(matrix[i][j]) + "\t");
            }
            System.out.println();
        }
    }
}
    
