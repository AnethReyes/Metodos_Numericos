/**
 * Integración con la regla de Simpson 1/3 (usa parábolas para aproximar)
 * Requiere n par (número de intervalos par)
 * Fórmula: (h/3)[f(x0) + 4∑f(x_impares) + 2∑f(x_pares) + f(xn)]
 */
public class MetodoSimpson13 {

    // Función a integrar: f(x) = x^2
    public static double f(double x) {
        return x * x;
    }

    // Método de Simpson 1/3 con redondeo
    public static double metodoSimpson13(double a, double b, int n) {
        if (n % 2 != 0) {
            throw new IllegalArgumentException("n debe ser un número par.");
        }

        double h = (b - a) / n;
        double suma = f(a) + f(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            suma += (i % 2 == 0) ? 2 * f(x) : 4 * f(x);
        }

        double integral = (h / 3) * suma;
        return Math.round(integral * 100.0) / 100.0;  // Redondeo a 2 decimales
    }

    public static void main(String[] args) {
        double a = 0;    // Límite inferior
        double b = 2;    // Límite superior
        int n = 10;      // Número de subintervalos (par)

        double resultado = metodoSimpson13(a, b, n);
        System.out.println("Resultado de la integral aproximada: " + resultado);
    }
}

/** # === Ejemplo de ejecución ===
* Input:
* f(x) = x²
* Intervalo: [0, 2]
* n = 10 (subintervalos, debe ser par)
* Output:
* Resultado de la integral aproximada: 2.67
*/

