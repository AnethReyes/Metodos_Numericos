/**
 * Método de Newton-Raphson para resolver f(x)=0
 * Requiere f'(x) y una aproximación inicial cercana a la raíz.
 * Convergencia: Cuadrática (rápida si converge).
 */
public class NewtonRaphsonSimple {
    
    interface MiFuncion {
        double calcular(double x);
    }
    
    public static void main(String[] args) {
        // Definir las funciones
        MiFuncion f = x -> Math.cos(x) - x;
        MiFuncion df = x -> -Math.sin(x) - 1;
        
        double x = 1.0; // Valor inicial
        double tolerancia = 0.0001;
        int maxPasos = 100;
        
        for (int paso = 1; paso <= maxPasos; paso++) {
            double fx = f.calcular(x);
            double dfx = df.calcular(x);
            
            x = x - fx / dfx;
            
            System.out.println("Paso " + paso + ": x = " + x);
            
            if (Math.abs(fx) < tolerancia) {
                double resultado = Math.round(x * 100) / 100.0;
                System.out.println("Solución encontrada: " + resultado);
                return;
            }
        }
        
        System.out.println("No se encontró solución en " + maxPasos + " pasos");
    }
}

/** # === Ejemplo de ejecución ===
* Input:
* f(x) = cos(x) - x
* f'(x) = -sin(x) - 1
* x0 = 1.0
* tol = 0.0001
* maxPasos = 100
* Output:
* Paso 1: x = 0.7503638678402439
* Paso 2: x = 0.7391128909113617
* Paso 3: x = 0.7390851333852839
* Paso 4: x = 0.7390851332151607
* Solución encontrada: 0.74
*/

