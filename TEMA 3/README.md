# Métodos de Solución de Sistemas de Ecuaciones

Los sistemas de ecuaciones lineales aparecen en numerosos problemas científicos y de ingeniería. Este tema cubre métodos directos e iterativos para resolver sistemas de la forma Ax = b.

**Métodos directos**:
- Eliminación Gaussiana: Transforma el sistema en forma triangular
- Gauss-Jordan: Lleva la matriz a forma diagonal (matriz identidad)

**Métodos iterativos**:
- Jacobi: Aproximaciones basadas en valores anteriores
- Gauss-Seidel: Versión mejorada que usa valores actualizados

La elección entre métodos directos e iterativos depende del tamaño del sistema, dispersión de la matriz y recursos computacionales disponibles. Los métodos iterativos son preferibles para sistemas grandes y dispersos.

## Pseudocódigos de los Métodos Implementados

### 1. Método de Gauss Jordan

```plaintext
Algoritmo Gauss-Jordan:
   Entrada:
      - A: matriz aumentada [A|b] n×(n+1)
   Salida:
      - Matriz identidad aumentada

   1. Para k desde 0 hasta n-1 hacer:
         pivote ← A[k][k]
         Para j desde k hasta n hacer:
              A[k][j] ← A[k][j] / pivote
         Fin Para
         
         Para i desde 0 hasta n-1 hacer:
              Si i ≠ k entonces:
                   factor ← A[i][k]
                   Para j desde k hasta n hacer:
                        A[i][j] ← A[i][j] - factor * A[k][j]
                   Fin Para
              Fin Si
         Fin Para
   2. Retornar A (columna n contiene solución)
```
### 2. Método de Gauss Seidel

```plaintext
Algoritmo Gauss-Seidel:
   Entrada:
      - A: matriz n×n
      - b: vector n×1
      - x0: vector inicial
      - tol: tolerancia
      - max_iter: máximo iteraciones
   Salida:
      - Solución aproximada x

   1. x ← x0
   2. Para iter desde 1 hasta max_iter hacer:
         Para i desde 0 hasta n-1 hacer:
              suma1 ← 0
              Para j desde 0 hasta i-1 hacer:
                   suma1 ← suma1 + A[i][j] * x[j]
              Fin Para
              
              suma2 ← 0
              Para j desde i+1 hasta n-1 hacer:
                   suma2 ← suma2 + A[i][j] * x[j]
              Fin Para
              
              x[i] ← (b[i] - suma1 - suma2) / A[i][i]
         Fin Para
         
         Si ||Ax - b|| < tol entonces:
              Retornar x
         Fin Si
   3. Retornar x
```
### 3. Método de Eliminacion Gaussiana 

```plaintext
Algoritmo Eliminación Gaussiana:
   Entrada:
      - A: matriz n×n
      - b: vector n×1
   Salida:
      - Matriz triangular superior

   1. Para k desde 0 hasta n-2 hacer:
         Para i desde k+1 hasta n-1 hacer:
              factor ← A[i][k] / A[k][k]
              Para j desde k hasta n-1 hacer:
                   A[i][j] ← A[i][j] - factor * A[k][j]
              Fin Para
              b[i] ← b[i] - factor * b[k]
         Fin Para
   2. Retornar A, b (sistema triangular)
```
### 4. Método de Jacobi

```plaintext
Algoritmo Jacobi:
   Entrada:
      - A: matriz n×n
      - b: vector n×1
      - x0: vector inicial
      - tol: tolerancia
      - max_iter: máximo iteraciones
   Salida:
      - Solución aproximada x

   1. x ← x0
   2. Para iter desde 1 hasta max_iter hacer:
         x_nuevo ← vector nuevo de tamaño n
         Para i desde 0 hasta n-1 hacer:
              suma ← 0
              Para j desde 0 hasta n-1 hacer:
                   Si j ≠ i entonces:
                        suma ← suma + A[i][j] * x[j]
                   Fin Si
              Fin Para
              x_nuevo[i] ← (b[i] - suma) / A[i][i]
         Fin Para
         
         Si ||x_nuevo - x|| < tol entonces:
              Retornar x_nuevo
         Fin Si
         x ← x_nuevo
   3. Retornar x (última aproximación)
```
