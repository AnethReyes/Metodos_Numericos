/**
 * Método de Regla Falsa (False Position) para resolver f(x)=0
 * Combina ideas de Bisección y Secante: usa interpolación lineal en lugar de dividir el intervalo a la mitad.
 * Convergencia: Superlineal (más rápido que Bisección en muchos casos).
 */
public class ReglaFalsa {
    
    public static double resolver(Funcion f, double a, double b, double tol, int maxIter) {
        if (f.evaluar(a) * f.evaluar(b) >= 0) {
            throw new IllegalArgumentException("No se cumple f(a)*f(b) < 0");
        }
        
        double c = a;
        for (int iter = 0; iter < maxIter; iter++) {
            // Fórmula de interpolación lineal (como la Secante pero con intervalo fijo)
            c = (a * f.evaluar(b) - b * f.evaluar(a)) / (f.evaluar(b) - f.evaluar(a));
            
            if (Math.abs(f.evaluar(c)) < tol) {
                break;
            }
            
            if (f.evaluar(c) * f.evaluar(a) < 0) {
                b = c;
            } else {
                a = c;
            }
        }
        return Math.round(c * 100.0) / 100.0; // Redondeo a 2 decimales
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        Funcion f = x -> Math.cos(x) - x; // f(x) = cos(x) - x (raíz ≈ 0.74)
        double raiz = resolver(f, 0.0, 1.0, 0.0001, 100);
        System.out.println("Raíz aproximada: " + raiz); // Output: 0.74
    }
}
