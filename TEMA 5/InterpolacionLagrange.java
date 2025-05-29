/**
 * Interpolación polinómica usando el método de Lagrange
 * Construye un polinomio de grado n-1 para n puntos
 */
public class InterpolacionLagrange {
    
    public static double interpolar(double[] x, double[] y, double punto) {
        if (x.length != y.length) throw new IllegalArgumentException("x e y deben tener igual longitud");
        
        double resultado = 0;
        for (int i = 0; i < x.length; i++) {
            double termino = y[i];
            for (int j = 0; j < x.length; j++) {
                if (j != i) {
                    termino *= (punto - x[j]) / (x[i] - x[j]);
                }
            }
            resultado += termino;
        }
        return Math.round(resultado * 100.0) / 100.0;
    }

    // Ejemplo: Polinomio para puntos (1,1), (2,4), (3,9) → x²
    public static void main(String[] args) {
        double[] x = {1, 2, 3};
        double[] y = {1, 4, 9};
        double valor = interpolar(x, y, 2.5);
        System.out.println("Valor interpolado: " + valor); // Output: 6.25
    }
}

/** # === Ejemplo de ejecución ===
* Input:
* x = {1, 2, 3}
* y = {1, 4, 9}
* punto = 2.5
* Output:
* Valor interpolado: 6.25
*/

