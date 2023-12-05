package circulo;

import java.util.Scanner;

class circulo {
    // Definir la constante PI
    public static final double PI = 3.14159265359;

    public static double calcularArea(double radio) {
        return PI * radio * radio;
    }

    public static double calcularCircunferencia(double radio) {
        return 2 * PI * radio;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el radio del círculo: ");
        double radio = scanner.nextDouble();

        double area = calcularArea(radio);
        double circunferencia = calcularCircunferencia(radio);

        System.out.println("El área del círculo es: " + area);
        System.out.println("La circunferencia del círculo es: " + circunferencia);
    }
}
