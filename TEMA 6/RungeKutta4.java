public class RungeKutta4 {
    
    @FunctionalInterface
    public interface Funcion {
        double evaluar(double t, double y);
    }
    
    // Método de Runge-Kutta de 4to orden
    public static double[] resolver(Funcion f, double t0, double y0, double h, int pasos) {
        double[] y = new double[pasos + 1];
        y[0] = y0;
        
        for (int i = 0; i < pasos; i++) {
            double t = t0 + i * h;
            double k1 = h * f.evaluar(t, y[i]);
            double k2 = h * f.evaluar(t + h/2, y[i] + k1/2);
            double k3 = h * f.evaluar(t + h/2, y[i] + k2/2);
            double k4 = h * f.evaluar(t + h, y[i] + k3);
            y[i + 1] = y[i] + (k1 + 2*k2 + 2*k3 + k4)/6;
        }
        return y;
    }
    
    public static void main(String[] args) {
        // Definimos la EDO: dy/dt = t - y
        Funcion f = (t, y) -> t - y;
        
        double t0 = 0.0;   // Tiempo inicial
        double y0 = 1.0;   // Valor inicial y(t0)
        double h = 0.1;    // Tamaño del paso
        int pasos = 10;    // Número de pasos (integrar hasta t = t0 + h*pasos)
        
        double[] solucion = resolver(f, t0, y0, h, pasos);
        
        System.out.println("Solución usando Runge-Kutta de 4to orden:");
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
* Output
* t		y(t)
* 0.0		1.00
* 0.1		0.91
* 0.2		0.84
* 0.3		0.78
* 0.4		0.74
* 0.5		0.71
* 0.6		0.70
* 0.7		0.69
* 0.8		0.70
* 0.9		0.71
* 1.0		0.74
*/
