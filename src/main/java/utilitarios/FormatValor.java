package utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FormatValor {

    //Formatar valor que sera apresentado no terminal
    static NumberFormat formatValores = new DecimalFormat("R$ #,##0.00");

    public static String doubleToString(Double valor) {
        return formatValores.format(valor);
    }
}
