def sumar_arreglo(numeros):
    suma = 0
    for numero in numeros:
        suma += numero
    return suma


arreglo = [10, 20, 30, 40, 50]
resultado = sumar_arreglo(arreglo)

print("La suma es:", resultado)