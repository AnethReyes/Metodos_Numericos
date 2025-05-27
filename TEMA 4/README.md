# Diferenciación e Integración Numérica

Cuando las funciones son difíciles de derivar o integrar analíticamente, o solo se conocen en puntos discretos, los métodos numéricos proporcionan herramientas esenciales.

**Diferenciación numérica**:
- Fórmulas de puntos (3 y 5 puntos) para aproximar derivadas
- Sensibles al ruido en los datos

**Integración numérica**:
- Regla del trapecio: Aproxima el área bajo la curva con trapecios
- Simpson: Usa parábolas para mejor precisión
- Cuadratura Gaussiana: Puntos óptimos para máxima exactitud

Estos métodos son fundamentales en física computacional, ingeniería y análisis de datos.

## Pseudocódigos de los Métodos Implementados

### 1. Método de Gauss Legendre

```plaintext
Algoritmo Gauss-Legendre (2 puntos):
   Entrada:
      - f: función a integrar
      - a, b: límites
   Salida:
      - Aproximación de la integral

   1. nodos ← [-1/√3, 1/√3]
   2. pesos ← [1, 1]
   3. suma ← 0
   4. Para i desde 0 hasta 1 hacer:
         t ← nodos[i]
         x ← ((b-a)*t + a + b) / 2
         suma ← suma + pesos[i] * f(x)
   5. integral ← ((b-a)/2) * suma
   6. Retornar integral
```
### 2. Método de Simpson 1/3

```plaintext
Algoritmo Simpson 1/3:
   Entrada:
      - f: función a integrar
      - a, b: límites
      - n: número par de subintervalos
   Salida:
      - Aproximación de la integral

   1. Si n % 2 ≠ 0 entonces Lanzar Error
   2. h ← (b - a) / n
   3. suma ← f(a) + f(b)
   4. Para i desde 1 hasta n-1 hacer:
         x_i ← a + i*h
         Si i % 2 = 1 entonces
            suma ← suma + 4*f(x_i)
         Sino
            suma ← suma + 2*f(x_i)
   5. integral ← (h / 3) * suma
   6. Retornar integral
```
### 3. Método de Simpson 3/8

```plaintext
Algoritmo Simpson 3/8:
   Entrada:
      - f: función a integrar
      - a, b: límites
      - n: múltiplo de 3
   Salida:
      - Aproximación de la integral

   1. Si n % 3 ≠ 0 entonces Lanzar Error
   2. h ← (b - a) / n
   3. suma ← f(a) + f(b)
   4. Para i desde 1 hasta n-1 hacer:
         x_i ← a + i*h
         Si i % 3 = 0 entonces
            suma ← suma + 2*f(x_i)
         Sino
            suma ← suma + 3*f(x_i)
   5. integral ← (3*h / 8) * suma
   6. Retornar integral
```
### 4. Método del trapecio

```plaintext
Algoritmo Trapecio Compuesto:
   Entrada:
      - f: función a integrar
      - a, b: límites de integración
      - n: número de subintervalos
   Salida:
      - Aproximación de la integral

   1. h ← (b - a) / n
   2. suma ← (f(a) + f(b)) / 2
   3. Para i desde 1 hasta n-1 hacer:
         x_i ← a + i*h
         suma ← suma + f(x_i)
   4. integral ← h * suma
   5. Retornar integral
```
