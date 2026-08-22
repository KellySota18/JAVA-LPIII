#include <iostream>
using namespace std;

int sumarArreglo(int numeros[], int tamaño) {
    int suma = 0;

    for (int i = 0; i < tamaño; i++) {
        suma += numeros[i];
    }

    return suma;
}

int main() {
    int tamaño = 5;
    int arreglo[5];

    // Ingresar los valores del arreglo
    for (int i = 0; i < tamaño; i++) {
        cout << "Ingrese el valor " << i + 1 << ": ";
        cin >> arreglo[i];
    }

    // Llamar a la función para calcular la suma
    int resultado = sumarArreglo(arreglo, tamaño);

    // Mostrar el resultado
    cout << "La suma de los elementos es: " << resultado << endl;

    return 0;
}