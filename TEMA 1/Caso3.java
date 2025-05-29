public class RedondeoError {
    public static void main(String[] args) {
        double num = 0.1 + 0.2;  // Suma de flotantes en Java
        double aprox = Math.round(num * 10.0) / 10.0;  // Redondeado a 1 decimal
        double errorRedondeo = num - aprox;

        System.out.println("Error de redondeo: " + errorRedondeo);
    }
}


/** # === Ejemplo de ejecución ===
* Input:
* num = 0.1 + 0.2
*
* Output:
* Error de redondeo: 5.551115123125783e-17 */

