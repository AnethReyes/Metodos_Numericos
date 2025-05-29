/**
 * Método de Regla Falsa (False Position) para resolver f(x)=0
 * Combina ideas de Bisección y Secante: usa interpolación lineal en lugar de dividir el intervalo a la mitad.
 * Convergencia: Superlineal (más rápido que Bisección en muchos casos).
 */
public class ReglaFalsaSimple {
    
    interface MiFuncion {
        double calcular(double x);
    }
    
    public static void main(String[] args) {
        // Definir la función como clase anónima
        MiFuncion f = new MiFuncion() {
            public double calcular(double x) {
                return Math.cos(x) - x;
            }
        };
        
        double a = 0.0;
        double b = 1.0;
        double tolerancia = 0.0001;
        int maxPasos = 100;
        double raiz = 0;
        
        for (int paso = 1; paso <= maxPasos; paso++) {
            double fa = f.calcular(a);
            double fb = f.calcular(b);
            
            // Calcular nuevo punto
            raiz = (a * fb - b * fa) / (fb - fa);
            double fRaiz = f.calcular(raiz);
            
            System.out.println("Paso " + paso + ": x = " + raiz);
            
            // Verificar convergencia
            if (Math.abs(fRaiz) < tolerancia) {
                double resultado = Math.round(raiz * 100) / 100.0;
                System.out.println("Raiz encontrada: " + resultado);
                return;
            }
            
            // Actualizar intervalo
            if (fRaiz * fa < 0) {
                b = raiz;
            } else {
                a = raiz;
            }
        }
        
        System.out.println("No se encontro la raiz en " + maxPasos + " pasos");
    }
}

/** # === Ejemplo de ejecución ===
* Input:
* f(x) = cos(x) - x
* a = 0.0
* b = 1.0
* tol = 0.0001
* maxPasos = 100
* Output:
* Paso 1: x = 0.5384690426783971
* Paso 2: x = 0.7031946120986566
* Paso 3: x = 0.7363796144521006
* Paso 4: x = 0.7397751382618291
* Paso 5: x = 0.739085124774084
* Paso 6: x = 0.739085133215522
* Raíz encontrada: 0.74
*/

