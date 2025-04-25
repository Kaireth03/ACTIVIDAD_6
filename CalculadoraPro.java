import java.util.Scanner;

public class CalculadoraPro {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double[] resultados = new double[100]; 
        int contadorResultados = 0;
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("\nSeleccione la figura:");
                System.out.println("1. Circulo");
                System.out.println("2. Cuadrado");
                System.out.println("3. Triangulo");
                System.out.println("4. Rectangulo");
                System.out.println("5. Pentagono");
                System.out.print("Opción: ");
                int figura = Integer.parseInt(entrada.nextLine());

                System.out.println("\nSeleccione la operación:");
                System.out.println("1. Area");
                System.out.println("2. Perimetro");
                System.out.print("Opcion: ");
                int operacion = Integer.parseInt(entrada.nextLine());

                double resultado = 0;

                switch (figura) {
                    case 1: // Círculo
                        System.out.print("Radio: ");
                        double radio = Double.parseDouble(entrada.nextLine());
                        resultado = (operacion == 1) ? Math.PI * radio * radio : 2 * Math.PI * radio;
                        break;

                    case 2: // Cuadrado
                        System.out.print("Lado: ");
                        double lado = Double.parseDouble(entrada.nextLine());
                        resultado = (operacion == 1) ? lado * lado : 4 * lado;
                        break;

                    case 3: // Triángulo
                        if (operacion == 1) {
                            System.out.print("Base: ");
                            double base = Double.parseDouble(entrada.nextLine());
                            System.out.print("Altura: ");
                            double altura = Double.parseDouble(entrada.nextLine());
                            resultado = (base * altura) / 2;
                        } else {
                            System.out.print("Lado 1: ");
                            double l1 = Double.parseDouble(entrada.nextLine());
                            System.out.print("Lado 2: ");
                            double l2 = Double.parseDouble(entrada.nextLine());
                            System.out.print("Lado 3: ");
                            double l3 = Double.parseDouble(entrada.nextLine());
                            resultado = l1 + l2 + l3;
                        }
                        break;

                    case 4: // Rectángulo
                        System.out.print("Base: ");
                        double baseR = Double.parseDouble(entrada.nextLine());
                        System.out.print("Altura: ");
                        double alturaR = Double.parseDouble(entrada.nextLine());
                        resultado = (operacion == 1) ? baseR * alturaR : 2 * (baseR + alturaR);
                        break;

                    case 5: // Pentágono
                        System.out.print("Lado: ");
                        double ladoP = Double.parseDouble(entrada.nextLine());
                        resultado = (operacion == 1)
                                ? (5 * ladoP * ladoP) / (4 * Math.tan(Math.PI / 5))
                                : 5 * ladoP;
                        break;

                    default:
                        System.out.println("Figura no valida.");
                        continue;
                }

                resultados[contadorResultados] = resultado;
                contadorResultados++;

                System.out.println("Resultado: " + resultado);

            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero valido.");
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado.");
            }

            System.out.print("\n¿Desea realizar otra operacion? (s/n): ");
            String respuesta = entrada.nextLine().toLowerCase();
            if (!respuesta.equals("s")) {
                continuar = false;
            }
        }

        System.out.println("\n--- Resultados almacenados ---");
        for (int i = 0; i < contadorResultados; i++) {
            System.out.println("Operación " + (i + 1) + ": " + resultados[i]);
        }

        entrada.close();
        System.out.println("Gracias por usar la calculadora.");
    }
}
