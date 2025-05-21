/**
 * Método de Punto Fijo para resolver x = g(x)
 * Convergencia: |g'(raíz)| < 1 (requerido)
 */
public class AproximacionesSucesivas {
    
    public static double resolver(Funcion g, double x0, double tol, int maxIter) {
        double xActual = x0;
        for (int iter = 0; iter < maxIter; iter++) {
            double xNuevo = g.evaluar(xActual);
            if (Math.abs(xNuevo - xActual) < tol) {
                return Math.round(xNuevo * 100.0) / 100.0;
            }
            xActual = xNuevo;
        }
        throw new RuntimeException("No convergió en " + maxIter + " iteraciones");
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        Funcion g = x -> Math.pow(x + 2, 1.0/3.0); // g(x) = ∛(x + 2)
        double raiz = resolver(g, 1.0, 0.001, 100);
        System.out.println("Raíz aproximada: " + raiz); // Output: 1.52
    }
}
