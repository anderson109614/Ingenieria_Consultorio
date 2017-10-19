package Interfaces;

import java.util.Scanner;

public class Auxiliar {

   public static int verificarCedula(String ced) {

        int par, impar, tot, x, dv, z;
        par = 0;
        impar = 0;

        if (ced.length() == 10) {
            for (int i = 0; i <= 9; i++) {
                if (ced.charAt(i) < '0' || ced.charAt(i) > '9') {
                   // System.out.print("ERROR..... ");
                }
            }
            for (int i = 1; i <= 8; i += 2) {
                par += Character.getNumericValue(ced.charAt(i));
            }
            for (int i = 0; i <= 8; i += 2) {
                x = (Character.getNumericValue(ced.charAt(i))) * 2;
                if (x > 9) {
                    x = x - 9;
                }
                impar += x;
            }
            tot = par + impar;
            z = (((tot / 10) + 1) * 10) - tot;
            dv = Character.getNumericValue(ced.charAt(9));
            if (z == 10) {
                z = 0;
            }
            if (z == dv) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}

