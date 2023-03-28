public class Cine {
    
    // Constantes para las tarifas básicas
    private static final int DINAMIX = 18800;
    private static final int TRES_D = 15500;
    private static final int DOS_D = 11300;
    
    // Constantes para los recargos y descuentos
    private static final double RECARGO_HORA_PICO_2D = 1.25;
    private static final double RECARGO_HORA_PICO_3D = 1.25;
    private static final double RECARGO_HORA_PICO_DINAMIX = 1.5;
    private static final double DESCUENTO_TARJETA_CINE = 0.2;
    
    public static void main(String[] args) {
        // Ejemplo de uso de la función calcularPrecioBoletas
        int numBoletas = 5;
        String tipoSala = "Dinamix";
        boolean esHoraPico = true;
        boolean tieneReserva = false;
        boolean esTarjetaCine = false;
        
        int precioTotal = calcularPrecioBoletas(numBoletas, tipoSala, esHoraPico, tieneReserva, esTarjetaCine);
        System.out.println("El precio total de las boletas es: " + precioTotal);
    }
    
    public static int calcularPrecioBoletas(int numBoletas, String tipoSala, boolean esHoraPico, boolean tieneReserva, boolean esTarjetaCine) {
        int precioSala = 0;
        switch(tipoSala) {
            case "Dinamix":
                precioSala = DINAMIX;
                break;
            case "3D":
                precioSala = TRES_D;
                break;
            case "2D":
                precioSala = DOS_D;
                break;
        }
        
        // Aplicar recargo por hora pico
        if (esHoraPico) {
            switch(tipoSala) {
                case "Dinamix":
                    precioSala *= RECARGO_HORA_PICO_DINAMIX;
                    break;
                case "3D":
                    precioSala *= RECARGO_HORA_PICO_3D;
                    break;
                case "2D":
                    precioSala *= RECARGO_HORA_PICO_2D;
                    break;
            }
        }
        
        // Aplicar descuento por tarjeta del cine
        if (esTarjetaCine) {
            precioSala *= (1 - DESCUENTO_TARJETA_CINE);
        }
        
        // Aplicar descuento por reserva
        if (tieneReserva) {
            precioSala *= (1 - DESCUENTO_TARJETA_CINE); // Se puede cambiar por otro valor de descuento
        }
        
        // Calcular precio total
        int precioTotal = precioSala * numBoletas;
        
        return precioTotal;
    }
}