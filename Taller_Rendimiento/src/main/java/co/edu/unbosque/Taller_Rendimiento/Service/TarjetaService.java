package co.edu.unbosque.Taller_Rendimiento.Service;

import org.springframework.stereotype.Service;

@Service
public class TarjetaService {

    // Método para validar el número de tarjeta usando el algoritmo de Luhn
    public boolean validarTarjeta(Long numero) {
        // Convertir el número a String para aplicar la lógica
        String numeroTarjeta = String.valueOf(numero);
        return AlgoritmoLuhn(numeroTarjeta);
    }

    // Algoritmo de Luhn para validar números de tarjeta
    private boolean AlgoritmoLuhn(String numeroTarjeta) {
        int sum = 0;
        boolean alternate = false;
        for (int i = numeroTarjeta.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(numeroTarjeta.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }
}
