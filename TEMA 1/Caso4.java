public class RedondeoError {
    public static void main(String[] args) {
        double num = Math.sqrt(2);  // Raíz cuadrada exacta
        double aprox = Math.round(num * 10000.0) / 10000.0;  // Redondeado a 4 decimales
        double errorRedondeo = num - aprox;

        System.out.println("Error de redondeo: " + errorRedondeo);
    }
}


/** # === Ejemplo de ejecución ===
* Input:
* num = math.sqrt(2)
*
* Output:
* Error de redondeo: 1.5949463971764999e-05 */

