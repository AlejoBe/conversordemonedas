package src;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //Variables
        String tipoDeMonedaOrigen = "";
        String tipoDeMonedaRetorno = "";
        Double valorDeMoneda;
        
        //Panel principal
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        while(opcion != 7){
            System.out.println("""
                ==================================
                CONVERSOR DE MONEDAS
                ==================================
                Porfavor Seleccione una de las siguientes opciones:
                1. USD =>> ARS
                2. ARS =>> USD
                3. USD =>> BRL
                4. BRL =>> USD
                5. COP =>> USD
                6. USD = >> COP
                7. Salir
                """);
            System.out.println("Opción: ");
            opcion = entrada.nextInt();
            //
            switch (opcion){
                case 1 -> {
                    tipoDeMonedaOrigen = "ARS";
                    tipoDeMonedaRetorno = "USD";
                }
                case 2 -> {
                    tipoDeMonedaOrigen = "USD";
                    tipoDeMonedaRetorno = "ARS";
                }
                case 3 -> {
                    tipoDeMonedaOrigen = "ARS";
                    tipoDeMonedaRetorno = "BRL";
                }
                case 4 -> {
                    tipoDeMonedaOrigen = "BRL";
                    tipoDeMonedaRetorno = "USD";
                }
                case 5 -> {
                    tipoDeMonedaOrigen = "COP";
                    tipoDeMonedaRetorno = "USD";
                }
                case 6 -> {
                    tipoDeMonedaOrigen = "USD";
                    tipoDeMonedaRetorno = "COP";
                }
                case 7 -> {
                    System.out.println("Fin del conversor");
                    continue;
                }
            }
            System.out.println("Selecciona el valor que quieres convertir: ");
            valorDeMoneda = entrada.nextDouble();
            
            //Conversión
            ConsultaMoneda consulta = new ConsultaMoneda();
            Moneda moneda = consulta.buscaMoneda(tipoDeMonedaOrigen);
//            System.out.println(moneda);
            Double valor = moneda.conversion_rates().get(tipoDeMonedaRetorno);
            System.out.println("El valor: "+ valorDeMoneda + "["+tipoDeMonedaOrigen+"]"+" corresponde a =>> "+valor*valorDeMoneda +"["+tipoDeMonedaRetorno+"]");
        }
    }
}
