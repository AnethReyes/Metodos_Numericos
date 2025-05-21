import math
num = math.sqrt(2)  # Raíz cuadrada exacta
aprox = round(num, 4)  # Redondeado a 4 decimales
error_redondeo = num - aprox
print(f'Error de redondeo: {error_redondeo}')