/**
 * Método de la Secante para resolver f(x)=0 (versión sin derivada de Newton)
 * Usa aproximación de la derivada con diferencias finitas.
 */
public class SecanteSimple {
    
    interface MiFuncion {
        double calcular(double x);
    }
    
    public static void main(String[] args) {
        // Definir la función
        MiFuncion f = new MiFuncion() {
            public double calcular(double x) {
                return x * x - 2; // f(x) = x² - 2
            }
        };
        
        double x0 = 1.0;
        double x1 = 2.0;
        double tolerancia = 0.0001;
        int maxPasos = 100;
        
        for (int paso = 1; paso <= maxPasos; paso++) {
            double fx0 = f.calcular(x0);
            double fx1 = f.calcular(x1);
            
            double x2 = x1 - fx1 * (x1 - x0) / (fx1 - fx0);
            
            System.out.println("Paso " + paso + ": x = " + x2);
            
            if (Math.abs(x2 - x1) < tolerancia) {
                double resultado = Math.round(x2 * 100) / 100.0;
                System.out.println("Raíz encontrada: " + resultado);
                return;
            }
            
            // Actualizar valores para siguiente paso
            x0 = x1;
            x1 = x2;
        }
        
        System.out.println("No se encontró la raíz en " + maxPasos + " pasos");
    }
}

/** # === Ejemplo de ejecución ===
* Input:
* f(x) = x² - 2
* x0 = 1.0
* x1 = 2.0
* tol = 0.0001
* maxPasos = 100
* Output:
* Paso 1: x = 1.3333333333333335
* Paso 2: x = 1.4000000000000001
* Paso 3: x = 1.4146341463414633
* Paso 4: x = 1.41421143847487
* Paso 5: x = 1.4142135620573204
* Raíz encontrada: 1.41
*/

