package com.example.rentagro.util;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formatEmTexto(int qtadeDias) {
        if (qtadeDias > 1) {
            return qtadeDias + PLURAL;
        }
        return qtadeDias + SINGULAR;
    }
}