# Métodos de Solución de Ecuaciones

Este tema aborda técnicas para encontrar raíces de ecuaciones no lineales de la forma f(x)=0. Cuando no es posible despejar x analíticamente, los métodos numéricos proporcionan aproximaciones sucesivas.

Los métodos se dividen en:
- **Métodos cerrados** (requieren intervalo inicial que contenga la raíz): Bisección, Regla Falsa
- **Métodos abiertos** (requieren aproximación inicial): Newton-Raphson, Secante, Punto Fijo

Cada método tiene ventajas en términos de convergencia, velocidad y requisitos iniciales. La elección depende del problema específico y del comportamiento de la función.
## Pseudocódigos de los Métodos Implementados

### 1. Método de Bisección
```plaintext
Algoritmo Bisección:
   Entrada: f, a, b, tol, max_iter
   Salida: raíz aproximada

   1. Si f(a)*f(b) ≥ 0 entonces
         Lanzar error "No se cumple teorema de Bolzano"
   2. Para iter desde 1 hasta max_iter hacer:
         c ← (a + b)/2
         Si |f(c)| < tol o (b-a)/2 < tol entonces
            Retornar c
         Fin Si
         Si f(c)*f(a) < 0 entonces
            b ← c
         Sino
            a ← c
         Fin Si
   3. Retornar c (última aproximación)
