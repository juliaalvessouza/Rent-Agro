package com.example.rentagro.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String LINGUA_PORTUGUES = "pt";
    public static final String BR = "br";

    public static String formatMoedaBrasileiro(BigDecimal moeda) {
        NumberFormat formatBr = DecimalFormat.getCurrencyInstance(new Locale(LINGUA_PORTUGUES, BR));
        return formatBr.format(moeda);
    }
}
