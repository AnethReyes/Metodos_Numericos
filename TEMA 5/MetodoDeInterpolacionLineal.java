/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodo.de.interpolacion.lineal;
//import java.util.Scanner;
///**
// *
// * @author aneth
// */
//public class MetodoDeInterpolacionLineal {
//
//    /**
//     * @param args the command line arguments
//     */ 
//    public static double interpolar(double x0, double y0, double x1, double y1, double x) {
//        if (x1 == x0) {
//            throw new IllegalArgumentException("x0 y x1 no pueden ser iguales (división por cero).");
//        }
//        return y0 + ((y1 - y0) / (x1 - x0)) * (x - x0);
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("=== Interpolación Lineal ===");
//
//        // Solicitar x0 y y0
//        System.out.print("Ingresa x0: ");
//        double x0 = scanner.nextDouble();
//
//        System.out.print("Ingresa y0: ");
//        double y0 = scanner.nextDouble();
//
//        // Solicitar x1 y y1
//        System.out.print("Ingresa x1: ");
//        double x1 = scanner.nextDouble();
//
//        System.out.print("Ingresa y1: ");
//        double y1 = scanner.nextDouble();
//
//        // Solicitar el valor de x a interpolar
//        System.out.print("Ingresa el valor de x a interpolar (x debe estar entre x0 y x1): ");
//        double x = scanner.nextDouble();
//
//        // Calcular y mostrar resultado
//        try {
//            double resultado = interpolar(x0, y0, x1, y1, x);
//            System.out.printf("El valor interpolado en x = %.4f es: f(x) = %.4f%n", x, resultado);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//        scanner.close();
//    }
//}
public class MetodoDeInterpolacionLineal {

    public static Double interpolar(double x0, double y0, double x1, double y1, double x) {
        if (x1 == x0) {
            return null; 
        }
        return y0 + ((y1 - y0) / (x1 - x0)) * (x - x0);
    }

    public static void main(String[] args) {
        // Datos de ejemplo
        double x0 = 12;
        double y0 = 45;
        double x1 = 12; 
        double y1 = 48.2;
        double x = 12;

        Double resultado = interpolar(x0, y0, x1, y1, x);

        if (resultado == null) {
            System.out.println("Error: x0 y x1 no pueden ser iguales (division por cero).");
        } else {
            System.out.printf("El valor interpolado en x = %.2f es: f(x) = %.2f%n", x, resultado);
        }
    }
}

