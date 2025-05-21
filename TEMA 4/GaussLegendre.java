/**
 * Integración con cuadratura gaussiana (puntos óptimos para exactitud)
 * Usa pesos y nodos precalculados para 2 puntos (fórmula básica)
 */
public class GaussLegendre {
    
    private static final double[] NODOS = {-1/Math.sqrt(3), 1/Math.sqrt(3)};
    private static final double[] PESOS = {1, 1};
    
    public static double integrar(Funcion f, double a, double b) {
        double suma = 0;
        double escala = (b - a) / 2;
        
        for (int i = 0; i < NODOS.length; i++) {
            double x = ((b - a) * NODOS[i] + b + a) / 2;
            suma += PESOS[i] * f.evaluar(x);
        }
        
        double resultado = escala * suma;
        return Math.round(resultado * 100.0) / 100.0;
    }

    // Ejemplo: ∫(1/(1+x^2))dx de 0 a 1 ≈ 0.79 (arctan(1) = π/4 ≈ 0.785)
    public static void main(String[] args) {
        Funcion f = x -> 1 / (1 + Math.pow(x, 2));
        double integral = integrar(f, 0, 1);
        System.out.println("Integral aproximada: " + integral);
    }
}
