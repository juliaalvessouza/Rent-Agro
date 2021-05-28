package com.example.rentagro.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_E_MES = "dd/MM";

    public static String periodoDiasEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatDataBr = new SimpleDateFormat(DIA_E_MES);
        String dataFormatadaIda = formatDataBr.format(dataIda.getTime());
        String dataFormatadaVolta = formatDataBr.format(dataVolta.getTime());
        return dataFormatadaIda + " - "
                + dataFormatadaVolta + " de "
                + dataVolta.get(Calendar.YEAR);
    }
}
