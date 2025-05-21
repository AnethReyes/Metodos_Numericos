/**
 * Versión extendida de Simpson para n divisible por 3
 * Fórmula: (3h/8)[f(x0) + 3∑(f(x1)+f(x2)) + 2∑f(x3,6,...) + f(xn)]
 */
public class Simpson38 {
    
    public static double integrar(Funcion f, double a, double b, int n) {
        if (n % 3 != 0) throw new IllegalArgumentException("n debe ser multiplo de 3");
        
        double h = (b - a) / n;
        double suma = f.evaluar(a) + f.evaluar(b);
        
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            suma += (i % 3 == 0) ? 2 * f.evaluar(x) : 3 * f.evaluar(x);
        }
        
        double resultado = (3 * h / 8) * suma;
        return Math.round(resultado * 100.0) / 100.0;
    }

    // Ejemplo: ∫(sin(x^2))dx de 0 a π ≈ 0.77
    public static void main(String[] args) {
        Funcion f = x -> Math.sin(Math.pow(x, 2));
        double integral = integrar(f, 0, Math.PI, 999); // 999 es múltiplo de 3
        System.out.println("Integral aproximada: " + integral);
    }
}
