/**
 * Método de Bisección para encontrar raíces de f(x)=0 en un intervalo [a,b]
 * Requiere que f(a)*f(b) < 0 (Teorema de Bolzano)
 * Convergencia: Lineal (garantizada)
 */
public class Biseccion {
    
    public static double resolver(Funcion f, double a, double b, double tol, int maxIter) {
        if (f.evaluar(a) * f.evaluar(b) >= 0) {
            throw new IllegalArgumentException("No se cumple f(a)*f(b) < 0");
        }
        
        double c = 0;
        for (int iter = 1; iter <= maxIter; iter++) {
            c = (a + b) / 2;
            if (Math.abs(f.evaluar(c)) < tol || (b - a)/2 < tol) {
                break;
            }
            if (f.evaluar(c) * f.evaluar(a) < 0) {
                b = c;
            } else {
                a = c;
            }
        }
        return Math.round(c * 100.0) / 100.0; 
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        Funcion f = x -> Math.pow(x, 3) - x - 2;
        double raiz = resolver(f, 1.0, 2.0, 0.001, 100);
        System.out.println("Raiz aproximada: " + raiz); 
    }
}

interface Funcion {
    double evaluar(double x);
}

/** # === Ejemplo de ejecución ===
* Input:
* f(x) = x³ - x - 2
* Output:
* Raiz aproximada: 1.52 */
