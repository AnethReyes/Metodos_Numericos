/**
 * Versión extendida de Simpson para n divisible por 3
 * Fórmula: (3h/8)[f(x0) + 3∑(f(x1)+f(x2)) + 2∑f(x3,6,...) + f(xn)]
 */
import java.text.DecimalFormat;

public class MétodoDeSimpson38 {

    public static double f(double x) {
        return Math.pow(x, 4) - 2 * x + 1;
    }

    public static double simpsonThreeEighths(double a, double b, int n) {
        if (n % 3 != 0) {
            throw new IllegalArgumentException("n debe ser múltiplo de 3.");
        }

        double h = (b - a) / n;
        double sum = f(a) + f(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += (i % 3 == 0) ? 2 * f(x) : 3 * f(x);
        }

        return (3 * h / 8) * sum;
    }

    public static void main(String[] args) {
        double a = 0;      
        double b = 3;      
        int n = 6;         

        double result = simpsonThreeEighths(a, b, n);
        
        DecimalFormat df = new DecimalFormat("#.##"); // 2 decimales
        System.out.println("Resultado: " + df.format(result));
    }
}

/** # === Ejemplo de ejecución ===
* Input:
* f(x) = x^4 - 2x + 1
* Intervalo: [0, 3]
* n = 6 (n debe ser múltiplo de 3)
* Output:
* Resultado: 42.66
*/


