public class Taylor2 {
    
    @FunctionalInterface
    public interface Funcion {
        double evaluar(double t, double y);
    }
    
    public static double[] resolver(Funcion f, Funcion df, double t0, double y0, double h, int pasos) {
        double[] y = new double[pasos + 1];
        y[0] = y0;
        
        for (int i = 0; i < pasos; i++) {
            double t = t0 + i * h;
            y[i + 1] = y[i] + h * f.evaluar(t, y[i]) + (h * h / 2) * df.evaluar(t, y[i]);
        }
        return y;
    }
    
    public static void main(String[] args) {
        Funcion f = (t, y) -> y - t * t + 1;
        
        // Derivada exacta: d²y/dt² = dy/dt - 2t = (y - t² + 1) - 2t
        Funcion df = (t, y) -> (y - t * t + 1) - 2 * t;
        
        double t0 = 0.0;   // Valor inicial de t
        double y0 = 0.5;   // Condición inicial y(0) = 0.5
        double h = 0.1;    // Paso
        int pasos = 10;    // De t=0 a t=1
        
        double[] solucion = resolver(f, df, t0, y0, h, pasos);
        
        System.out.println("Solución de dy/dt = y - t² + 1, y(0)=0.5");
        System.out.println("t\t\ty(t)");
        
        for (int i = 0; i < solucion.length; i++) {
            double t = t0 + i * h;
            double yRedondeado = Math.round(solucion[i] * 100.0) / 100.0;
            System.out.printf("%.1f\t\t%.2f%n", t, yRedondeado);
        }
    }
}

/** # === Ejemplo de ejecución ===
* EDO: dy/dt = y - t² + 1, y(0) = 0.5, h = 0.1, pasos = 10
* Output:
* Solución de dy/dt = y - t² + 1, y(0)=0.5
* t               y(t)
* 0.0             0.50
* 0.1             0.66
* 0.2             0.83
* 0.3             1.02
* 0.4             1.21
* 0.5             1.43
* 0.6             1.65
* 0.7             1.88
* 0.8             2.13
* 0.9             2.38
* 1.0             2.64
*/
