/**
 * Integración con la regla de Simpson 1/3 (usa parábolas para aproximar)
 * Requiere n par (número de intervalos par)
 * Fórmula: (h/3)[f(x0) + 4∑f(x_impares) + 2∑f(x_pares) + f(xn)]
 */
public class Simpson13 {
    
    public static double integrar(Funcion f, double a, double b, int n) {
        if (n % 2 != 0) throw new IllegalArgumentException("n debe ser par");
        
        double h = (b - a) / n;
        double suma = f.evaluar(a) + f.evaluar(b);
        
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            suma += (i % 2 == 0) ? 2 * f.evaluar(x) : 4 * f.evaluar(x);
        }
        
        double resultado = (h / 3) * suma;
        return Math.round(resultado * 100.0) / 100.0;
    }

    // Ejemplo: ∫(√(1 + x^3))dx de 0 a 2 ≈ 3.24
    public static void main(String[] args) {
        Funcion f = x -> Math.sqrt(1 + Math.pow(x, 3));
        double integral = integrar(f, 0, 2, 1000);
        System.out.println("Integral aproximada: " + integral);
    }
}
