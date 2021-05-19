package com.oblivion.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarCedula {
	@Autowired(required=true)
    public boolean ingresoDataCedula(String cadena_cedual){
        try {
            if (stringLength(cadena_cedual, 10)) {//verificar que la cadena tenga tamaño 10
                String[] data = cadena_cedual.split("");//crear un string donde separa datos
                byte verifier = Byte.parseByte(data[0] + data[1]);
                byte[] digits = new byte[9];
                for (byte i = 0; i < 9; i++)
                    digits[i] = Byte.parseByte(data[i]);            
                if (verifier >= 1 && verifier <= 24) {
                    verifier = digits[2];
                    if (verifier <= 6) {
                        if (sumDigits(digits) == Byte.parseByte(data[9]))
                            return true;
                    }
                }
            }
        } catch (NumberFormatException e) {
        }
        return false;
    }

	private boolean stringLength(String string, int length) {
        if (string.length() == length)
            return true;
        return false;
    }
    private byte sumDigits(byte[] digits) {
        byte verifier;
        byte sum = 0;
        for (byte i = 0; i < digits.length; i = (byte) (i + 2)) {
            verifier = (byte) (digits[i] * 2);
            if (verifier > 9)
                verifier = (byte) (verifier - 9);
            sum = (byte) (sum + verifier);
        }
        for (byte i = 1; i < digits.length; i = (byte) (i + 2)) {
            verifier = (byte) (digits[i] * 1);
            sum = (byte) (sum + verifier);
        }
        return (byte) ((sum - (sum % 10) + 10) - sum);
    }
    
    

}
