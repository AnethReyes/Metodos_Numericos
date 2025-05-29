public class Redondeo Error {
    public static void main(String[] args) {
        double num = 10.0 / 3.0;  // Resultado exacto
        double aprox = Math.round(num * 1000.0) / 1000.0;  // Redondeado a 3 decimales
        double errorRedondeo = num - aprox;

        System.out.println("Error de redondeo: " + errorRedondeo);
    }
}


/** # === Ejemplo de ejecución ===
* Input:
* num = 10 / 3
*
* Output:
* Error de redondeo: 1.6666666666666667e-05 */

