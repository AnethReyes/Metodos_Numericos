public class RedondeoError {
    public static void main(String[] args) {
        double num = 3.1415926535;  // Número original
        double aprox = Math.round(num * 100.0) / 100.0;  // Redondeado a 2 decimales
        double errorRedondeo = num - aprox;

        System.out.println("Error de redondeo: " + errorRedondeo);
    }
}

/** # === Ejemplo de ejecución ===
* Input:
* num = 3.1415926535
*
* Output:
* Error de redondeo: 0.0015926534999999298 */

