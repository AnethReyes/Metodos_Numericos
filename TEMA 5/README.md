# Interpolación y Ajuste de Funciones

Cuando se tienen datos discretos y se necesita estimar valores intermedios o encontrar tendencias, estos métodos son esenciales.

**Interpolación**:
- Construye una función que pasa exactamente por los puntos dados
- Lineal: Conexión con segmentos rectos
- Polinómica: Polinomios de Lagrange o Newton

**Ajuste de curvas**:
- Regresión lineal: Minimiza la distancia cuadrática a una recta
- Mínimos cuadrados: Aproximación óptima para datos ruidosos
- Correlación: Mide la relación entre variables

Estas técnicas son ampliamente usadas en procesamiento de señales, visualización de datos y machine learning.

# *Interpolación
## Interpolación Lineal
Esta técnica fundamental estima valores intermedios entre dos puntos conocidos conectándolos con una línea recta. La fórmula básica para un punto x entre (x₀,y₀) y (x₁,y₁) es:

y = y₀ + (y₁ - y₀) * (x - x₀)/(x₁ - x₀)

## Interpolación de Lagrange
Método polinomial que pasa exactamente por n puntos conocidos usando polinomios base

# *Ajuste de Funciones
## Regresión Lineal
Modelo estadístico que encuentra la relación lineal óptima entre variables independientes y dependientes minimizando el error cuadrático

## Mínimos Cuadrados
Técnica fundamental de optimización para resolver sistemas sobredeterminados.

## Correlación
Medida estadística de la relación lineal entre variables

## Pseudocódigos de los Métodos Implementados

### 1. Método de Interpolacion Lineal

```plaintext
Algoritmo Interpolación Lineal:
   Entrada:
      - (x0, y0), (x1, y1): puntos conocidos
      - x: valor a interpolar
   Salida:
      - y estimado

   1. Si x0 == x1 entonces Lanzar Error
   2. pendiente ← (y1 - y0) / (x1 - x0)
   3. y ← y0 + pendiente * (x - x0)
   4. Retornar round(y * 100) / 100
```
### 2. Método de Interpolacion de Lagrange

```plaintext
Algoritmo Lagrange:
   Entrada:
      - x[], y[]: pares de puntos conocidos
      - x_val: valor a interpolar
   Salida:
      - y estimado

   1. n ← longitud(x) - 1
   2. resultado ← 0
   3. Para i desde 0 hasta n hacer:
         termino ← y[i]
         Para j desde 0 hasta n hacer:
              Si j != i entonces
                   termino ← termino * (x_val - x[j]) / (x[i] - x[j])
         resultado ← resultado + termino
   4. Retornar round(resultado * 100) / 100
```
### 3. Método de Regresion Lineal 

```plaintext
Algoritmo Regresión Lineal:
   Entrada:
      - x[], y[]: datos
   Salida:
      - (a, b, R²)

   1. Calcular a, b usando Mínimos Cuadrados
   2. sumRes ← sumTotal ← 0
   3. y_mean ← promedio(y)
   4. Para i desde 0 hasta n-1 hacer:
         y_pred ← a + b*x[i]
         sumRes ← sumRes + (y[i] - y_pred)^2
         sumTotal ← sumTotal + (y[i] - y_mean)^2
   5. R2 ← 1 - (sumRes / sumTotal)
   6. Retornar (a, b, round(R2*100)/100)
```

### 4. Método de Minimos Cuadrados

```plaintext
Algoritmo Mínimos Cuadrados:
   Entrada:
      - x[], y[]: datos experimentales
   Salida:
      - (a, b) de y = a + bx

   1. n ← longitud(x)
   2. sumX ← sumY ← sumXY ← sumX2 ← 0
   3. Para i desde 0 hasta n-1 hacer:
         sumX ← sumX + x[i]
         sumY ← sumY + y[i]
         sumXY ← sumXY + x[i]*y[i]
         sumX2 ← sumX2 + x[i]^2
   4. b ← (n*sumXY - sumX*sumY) / (n*sumX2 - sumX^2)
   5. a ← (sumY - b*sumX) / n
   6. Retornar (round(a*100)/100, round(b*100)/100)
```

### 5. Método de Correlacion 
```plaintext
Algoritmo Correlación:
   Entrada:
      - x[], y[]: variables a correlacionar
   Salida:
      - r ∈ [-1, 1]

   1. n ← longitud(x)
   2. sumX ← sumY ← sumXY ← sumX2 ← sumY2 ← 0
   3. Para i desde 0 hasta n-1 hacer:
         sumX ← sumX + x[i]
         sumY ← sumY + y[i]
         sumXY ← sumXY + x[i]*y[i]
         sumX2 ← sumX2 + x[i]^2
         sumY2 ← sumY2 + y[i]^2
   4. numerador ← n*sumXY - sumX*sumY
   5. denominador ← sqrt((n*sumX2 - sumX^2) * (n*sumY2 - sumY^2))
   6. r ← numerador / denominador
   7. Retornar round(r*100)/100
```
