/**
 * Método de Newton-Raphson para resolver f(x)=0
 * Requiere f'(x) y una aproximación inicial cercana a la raíz.
 * Convergencia: Cuadrática (rápida si converge).
 */
public class NewtonRaphson {
    
    public static double resolver(Funcion f, Funcion df, double x0, double tol, int maxIter) {
        double x = x0;
        for (int iter = 0; iter < maxIter; iter++) {
            double fx = f.evaluar(x);
            double dfx = df.evaluar(x);
            if (Math.abs(fx) < tol) {
                return Math.round(x * 100.0) / 100.0;
            }
            x = x - fx / dfx;
        }
        throw new RuntimeException("No convergio en " + maxIter + " iteraciones");
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        Funcion f = x -> Math.cos(x) - x; // f(x) = cos(x) - x
        Funcion df = x -> -Math.sin(x) - 1; // f'(x) = -sin(x) - 1
        double raiz = resolver(f, df, 1.0, 0.0001, 100);
        System.out.println("Raiz aproximada: " + raiz); // Output: 0.74
    }
}
