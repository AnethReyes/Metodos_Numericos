public class Euler {
    
    // Método de Euler para resolver dy/dt = f(t, y)
    public static double[] resolver(Funcion f, double t0, double y0, double h, int pasos) {
        double[] y = new double[pasos + 1];
        y[0] = y0;
        
        for (int i = 0; i < pasos; i++) {
            double t = t0 + i * h;
            y[i + 1] = y[i] + h * f.evaluar(t, y[i]);
        }
        return y;
    }
    
    // Interfaz funcional para representar la EDO
    @FunctionalInterface
    public interface Funcion {
        double evaluar(double t, double y);
    }
    
    // Ejemplo de uso: Resolver dy/dt = t - y, con y(0) = 1, h = 0.1, 10 pasos
    public static void main(String[] args) {
        // Definimos la EDO: dy/dt = t - y
        Funcion f = (t, y) -> t - y;
    
        double t0 = 0.0;   // Tiempo inicial
        double y0 = 1.0;   // Valor inicial y(t0)
        double h = 0.1;     // Tamaño del paso
        int pasos = 10;     // Número de pasos
        
        double[] solucion = resolver(f, t0, y0, h, pasos);
        
        // Mostramos resultados redondeados a 2 decimales
        System.out.println("Solución usando el método de Euler:");
        System.out.println("t\t\ty(t)");
        for (int i = 0; i < solucion.length; i++) {
            double t = t0 + i * h;
            double yRedondeado = Math.round(solucion[i] * 100.0) / 100.0;
            System.out.printf("%.1f\t\t%.2f%n", t, yRedondeado);
        }
    }
}

/** # === Ejemplo de ejecución ===
* EDO: dy/dt = t - y, y(0) = 1, h = 0.1, pasos = 10
* Output:
* Solución usando el método de Euler:
* t		y(t)
* 0.0		1.00
* 0.1		0.90
* 0.2		0.82
* 0.3		0.76
* 0.4		0.71
* 0.5		0.68
* 0.6		0.66
* 0.7		0.66
* 0.8		0.66
* 0.9		0.67
* 1.0		0.70
*/
