/**
 * Integración mediante la regla del trapecio (aproxima el área bajo la curva con trapecios)
 * Fórmula: (b-a)/2 * [f(a) + f(b)]
 */
public class Trapecio {
    
    public static double integrar(Funcion f, double a, double b, int n) {
        double h = (b - a) / n;
        double suma = 0.5 * (f.evaluar(a) + f.evaluar(b));
        
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            suma += f.evaluar(x);
        }
        
        double resultado = h * suma;
        return Math.round(resultado * 100.0) / 100.0;
    }

    // Ejemplo: ∫(e^x)dx de 0 a 1 ≈ 1.72
    public static void main(String[] args) {
        Funcion f = x -> Math.exp(x);
        double integral = integrar(f, 0, 1, 1000);
        System.out.println("Integral aproximada: " + integral);
    }
}
