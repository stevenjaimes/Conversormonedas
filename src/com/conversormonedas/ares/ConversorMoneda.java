package com.conversormonedas.ares;

import java.util.Map;
import java.util.Scanner;

public class ConversorMoneda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServicioDivisas servicioDivisas = new ServicioDivisas();
        Map<String, Double> tasasCambio = servicioDivisas.obtenerTasasDeCambio();

        if (tasasCambio == null) {
            System.out.println("No se pudieron obtener las tasas de cambio. Saliendo del programa.");
            return;
        }

        boolean running = true;

        while (running) {
            System.out.println("\nMenu de Conversiones:");
            System.out.println("1. USD a Pesos Colombianos (COP)");
            System.out.println("2. Pesos Colombianos (COP) a USD");
            System.out.println("3. USD a Pesos Argentinos (ARS)");
            System.out.println("4. Pesos Argentinos (ARS) a USD");
            System.out.println("5. USD a Real Brasileño (BRL)");
            System.out.println("6. Real Brasileño (BRL) a USD");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");

            int option = scanner.nextInt();
            if (option == 7) {
                System.out.println("Saliendo...");
                running = false;
                continue;
            }

            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();
            double result = 0;

            switch (option) {
                case 1: // USD a COP
                    result = cantidad * tasasCambio.get("COP");
                    System.out.println("El valor de " + cantidad + " [USD] corresponde al valor final de =>> " + String.format("%.2f", result) + " [COP]");
                    break;
                case 2: // COP a USD
                    result = cantidad / tasasCambio.get("COP");
                    System.out.println("El valor de " + cantidad + " [COP] corresponde al valor final de =>> " + String.format("%.2f", result) + " [USD]");
                    break;
                case 3: // USD a ARS
                    result = cantidad * tasasCambio.get("ARS");
                    System.out.println("El valor de " + cantidad + " [USD] corresponde al valor final de =>> " + String.format("%.2f", result) + " [ARS]");
                    break;
                case 4: // ARS a USD
                    result = cantidad / tasasCambio.get("ARS");
                    System.out.println("El valor de " + cantidad + " [ARS] corresponde al valor final de =>> " + String.format("%.2f", result) + " [USD]");
                    break;
                case 5: // USD a BRL
                    result = cantidad * tasasCambio.get("BRL");
                    System.out.println("El valor de " + cantidad + " [USD] corresponde al valor final de =>> " + String.format("%.2f", result) + " [BRL]");
                    break;
                case 6: // BRL a USD
                    result = cantidad / tasasCambio.get("BRL");
                    System.out.println("El valor de " + cantidad + " [BRL] corresponde al valor final de =>> " + String.format("%.2f", result) + " [USD]");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
            System.out.println("*************************************************************");
        }
        scanner.close();
    }
}
