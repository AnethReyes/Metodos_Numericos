/**
 * Método de la Secante para resolver f(x)=0 (versión sin derivada de Newton)
 * Usa aproximación de la derivada con diferencias finitas.
 */
public class Secante {
    
    public static double resolver(Funcion f, double x0, double x1, double tol, int maxIter) {
        for (int iter = 0; iter < maxIter; iter++) {
            double fx1 = f.evaluar(x1);
            double fx0 = f.evaluar(x0);
            double x2 = x1 - fx1 * (x1 - x0) / (fx1 - fx0);
            
            if (Math.abs(x2 - x1) < tol) {
                return Math.round(x2 * 100.0) / 100.0;
            }
            x0 = x1;
            x1 = x2;
        }
        throw new RuntimeException("No convergió en " + maxIter + " iteraciones");
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        Funcion f = x -> x * x - 2; // f(x) = x² - 2 (raíz √2 ≈ 1.41)
        double raiz = resolver(f, 1.0, 2.0, 0.0001, 100);
        System.out.println("Raíz aproximada: " + raiz); // Output: 1.41
    }
}
