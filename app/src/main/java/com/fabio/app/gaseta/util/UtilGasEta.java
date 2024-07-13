package com.fabio.app.gaseta.util;

import android.widget.EditText;

public class UtilGasEta {



    public static String calcularMelhorOpcao(double editGasolina, double editEtanol ){

        double precoIdeal = editGasolina * 0.70;
        String messagemDeRetorno;

        if (editEtanol <= precoIdeal) {
            messagemDeRetorno = "melhor abastecer com Etanol";

        } else {
            messagemDeRetorno = "melhor abastecer com Gasolina";

        }
        return messagemDeRetorno;

    }

}
