/**
 * Integración mediante la regla del trapecio (aproxima el área bajo la curva con trapecios)
 * Fórmula: (b-a)/2 * [f(a) + f(b)]
 */
public class MetodoTrapecioLognat {
    public static double f(double x) {
        return Math.log(x);
    }
    
    public static double metodoTrapecio(double a, double b, int n) {
        double h = (b - a) / n;
        double suma = f(a) + f(b);

        for (int i = 1; i < n; i++) {
            double xi = a + i * h;
            suma += 2 * f(xi);
        }
        
        double resultado = (h / 2) * suma;
        return Math.round(resultado * 100.0) / 100.0;  // Redondeo a 2 decimales
    }
    
    public static void main(String[] args) {
        double a = 1.0;    
        double b = 2.0;      
        int n = 100;        
        
        System.out.println("Metodo del Trapecio");
        System.out.println("Limite inferior a: " + a);
        System.out.println("Limite superior b: " + b);
        System.out.println("Numero de subintervalos n: " + n);
        
        double resultado = metodoTrapecio(a, b, n);
        System.out.println("La aproximacion de la integral es: " + resultado);
    }
}

/** # === Ejemplo de ejecución ===
* Input:
* f(x) = ln(x)
* Intervalo: [1.0, 2.0]
* n = 100
* Output:
* Metodo del Trapecio
* Limite inferior a: 1.0
* Limite superior b: 2.0
* Numero de subintervalos n: 100
* La aproximacion de la integral es: 0.39
*/

