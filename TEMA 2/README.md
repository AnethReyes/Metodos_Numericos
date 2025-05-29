# Métodos de Solución de Ecuaciones

Este tema aborda técnicas para encontrar raíces de ecuaciones no lineales de la forma f(x)=0. Cuando no es posible despejar x analíticamente, los métodos numéricos proporcionan aproximaciones sucesivas.

Los métodos se dividen en:
- **Métodos cerrados** (requieren intervalo inicial que contenga la raíz): Bisección, Regla Falsa
- **Métodos abiertos** (requieren aproximación inicial): Newton-Raphson, Secante, Punto Fijo

Cada método tiene ventajas en términos de convergencia, velocidad y requisitos iniciales. La elección depende del problema específico y del comportamiento de la función.

## Bisección
El método de bisección es un algoritmo de búsqueda de raíces que divide repetidamente un intervalo a la mitad y selecciona el subintervalo que contiene la raíz. Requiere que la función cambie de signo en el intervalo inicial.

## Regla Falsa
Similar al método de bisección, pero en lugar de dividir el intervalo a la mitad, utiliza una aproximación lineal (interpolación) para estimar la raíz. También requiere un cambio de signo en el intervalo.

## Newton-Raphson
Este método utiliza la derivada de la función para encontrar una aproximación de la raíz. Parte de una estimación inicial y mejora iterativamente usando la tangente a la curva.

## Secante
Una variante del método de Newton-Raphson que no requiere la derivada. En su lugar, utiliza aproximaciones secuenciales basadas en puntos anteriores.

## Aproximaciones Sucesivas
Este método reorganiza la ecuación f(x) = 0 en la forma x = g(x) y itera esta relación hasta converger a la raíz.

## Pseudocódigos de los Métodos Implementados

### 1. Método de Aproximaciones Sucesivas (Punto Fijo)
**Fórmula:**  
`x_{n+1} = g(x_n)`

```plaintext
Algoritmo Punto Fijo:
   Entrada: 
      - g: función de iteración (debe cumplir |g'(x)| < 1)
      - x0: aproximación inicial
      - tol: tolerancia
      - max_iter: máximo de iteraciones
   Salida: raíz aproximada

   1. x_actual ← x0
   2. Para iter desde 1 hasta max_iter hacer:
         x_nuevo ← g(x_actual)
         Si |x_nuevo - x_actual| < tol entonces
            Retornar x_nuevo
         Fin Si
         x_actual ← x_nuevo
   3. Lanzar error "No convergió en max_iter iteraciones"
```
### 2. Método de Bisección
**Fórmula:**  
`c = (a + b) / 2`

```plaintext
Algoritmo Bisección:
   Entrada: 
      - f: función continua
      - a, b: intervalo [a, b] con f(a)*f(b) < 0
      - tol: tolerancia
      - max_iter: máximo de iteraciones
   Salida: raíz aproximada

   1. Si f(a)*f(b) ≥ 0 entonces
         Lanzar error "No se cumple teorema de Bolzano"
   2. Para iter desde 1 hasta max_iter hacer:
         c ← (a + b) / 2
         Si |f(c)| < tol o (b - a)/2 < tol entonces
            Retornar c
         Fin Si
         Si f(c)*f(a) < 0 entonces
            b ← c
         Sino
            a ← c
         Fin Si
   3. Retornar c (última aproximación)
```
### 3. Método de Newton-Raphson
**Fórmula:**  
`x_{n+1} = x_n - f(x_n)/f'(x_n)`

```plaintext
Algoritmo Newton-Raphson:
   Entrada: 
      - f: función diferenciable
      - df: derivada de f
      - x0: aproximación inicial
      - tol: tolerancia
      - max_iter: máximo de iteraciones
   Salida: raíz aproximada

   1. x ← x0
   2. Para iter desde 1 hasta max_iter hacer:
         fx ← f(x)
         Si |fx| < tol entonces
            Retornar x
         Fin Si
         dfx ← df(x)
         Si dfx = 0 entonces
            Lanzar error "Derivada cero"
         Fin Si
         x ← x - fx/dfx
   3. Retornar x
```
### 4. Método de Regla Falsa
**Fórmula:**  
`c = [a*f(b) - b*f(a)] / [f(b) - f(a)]`

```plaintext
Algoritmo Regla Falsa:
   Entrada: 
      - f: función continua
      - a, b: intervalo inicial
      - tol: tolerancia
      - max_iter: máximo de iteraciones
   Salida: raíz aproximada

   1. Si f(a)*f(b) ≥ 0 entonces
         Lanzar error "Intervalo inválido"
   2. Para iter desde 1 hasta max_iter hacer:
         c ← [a*f(b) - b*f(a)] / [f(b) - f(a)]
         Si |f(c)| < tol entonces
            Retornar c
         Fin Si
         Si f(c)*f(a) < 0 entonces
            b ← c
         Sino
            a ← c
         Fin Si
   3. Retornar c
```
### 5. Método de la Secante
**Fórmula:**  
`x_{n+1} = x_n - f(x_n)*(x_n - x_{n-1})/(f(x_n) - f(x_{n-1}))`

```plaintext
Algoritmo Secante:
   Entrada: 
      - f: función continua
      - x0, x1: aproximaciones iniciales
      - tol: tolerancia
      - max_iter: máximo de iteraciones
   Salida: raíz aproximada

   1. Para iter desde 1 hasta max_iter hacer:
         fx1 ← f(x1)
         fx0 ← f(x0)
         x2 ← x1 - fx1*(x1 - x0)/(fx1 - fx0)
         Si |x2 - x1| < tol entonces
            Retornar x2
         Fin Si
         x0 ← x1
         x1 ← x2
   2. Retornar x2
```
