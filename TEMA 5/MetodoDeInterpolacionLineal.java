/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
public class MetodoDeInterpolacionLineal {

    public static Double interpolar(double x0, double y0, double x1, double y1, double x) {
        if (x1 == x0) {
            return null; 
        }
        return y0 + ((y1 - y0) / (x1 - x0)) * (x - x0);
    }

    public static void main(String[] args) {
        // Datos de ejemplo
        double x0 = 20;
        double y0 = 45;
        double x1 = 10; 
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

/** # === Ejemplo de ejecución ===
* Input:
* x0 = 20, y0 = 45
* x1 = 10, y1 = 48.2
* x = 12
* Output:
* El valor interpolado en x = 12.00 es: f(x) = 47.56
*/
