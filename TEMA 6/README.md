# TEMA 6 - Solución de Ecuaciones Diferenciales Ordinarias (EDOs)

## Introducción

Los métodos numéricos para resolver ecuaciones diferenciales ordinarias son herramientas fundamentales en modelado científico e ingeniería, especialmente cuando no existen soluciones analíticas. Este tema cubre tres enfoques clave:

### 1. Método de Euler (Un Paso)
**Concepto:**  
El método más simple que aproxima la solución mediante lineas rectas tangentes a la curva real. Ideal para introducción conceptual.

**Características:**  
- Fácil implementación  
- Error proporcional al tamaño de paso (O(h))  
- Requiere pasos muy pequeños para precisión  

### 2. Método de Runge-Kutta de 4to Orden (RK4)
**Concepto:**  
El "caballo de batalla" de los métodos numéricos, combina cuatro evaluaciones de pendiente para lograr mayor precisión sin calcular derivadas.

**Características:**  
- Precisión de orden O(h⁴)  
- Coste computacional moderado (4 evaluaciones/paso)  
- Ampliamente usado en aplicaciones reales  

**Ecuación Clave:**  
$$
y_{n+1} = y_n + \frac{1}{6}(k_1 + 2k_2 + 2k_3 + k_4)
$$

### 3. Método de Taylor de 2do Orden
**Concepto:**  
Extensión del método de Euler que incorpora la segunda derivada para mejorar la precisión. Requiere conocimiento de las derivadas de la función.

**Características:**  
- Mayor precisión que Euler (O(h²))  
- Necesita derivadas analíticas  
  Punto intermedio entre Euler y RK4  

## Pseudocódigos de los Métodos Implementados

### 1. Método de Euler (Un Paso)

```plaintext
Algoritmo Euler:
   Entrada:
      - f: función dy/dt = f(t, y)
      - t0, y0: condición inicial
      - h: tamaño de paso
      - n: número de pasos
   Salida:
      - Vector de soluciones y[]

   1. y[0] ← y0
   2. Para i desde 0 hasta n-1 hacer:
         t ← t0 + i*h
         y[i+1] ← y[i] + h * f(t, y[i])
   3. Retornar y
```
### 2. Método de Runge-Kutta

```plaintext
Algoritmo RK4:
   Entrada:
      - f: función dy/dt
      - t0, y0: condición inicial
      - h: tamaño de paso
      - n: número de pasos
   Salida:
      - Vector de soluciones y[]

   1. y[0] ← y0
   2. Para i desde 0 hasta n-1 hacer:
         t ← t0 + i*h
         k1 ← h * f(t, y[i])
         k2 ← h * f(t + h/2, y[i] + k1/2)
         k3 ← h * f(t + h/2, y[i] + k2/2)
         k4 ← h * f(t + h, y[i] + k3)
         y[i+1] ← y[i] + (k1 + 2*k2 + 2*k3 + k4)/6
   3. Retornar y
```
### 3. Método de Taylor de 2do Orden

```plaintext
Algoritmo Taylor2:
   Entrada:
      - f, f': función y su derivada
      - t0, y0: condición inicial
      - h: tamaño de paso
      - n: número de pasos
   Salida:
      - Vector de soluciones y[]

   1. y[0] ← y0
   2. Para i desde 0 hasta n-1 hacer:
         t ← t0 + i*h
         y[i+1] ← y[i] + h*f(t, y[i]) + (h^2/2)*f'(t, y[i])
   3. Retornar y
```
