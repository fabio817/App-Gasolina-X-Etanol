package com.fabio.app.gaseta.util;

import android.widget.EditText;

public class UtilGasEta {




    public static String calcularMelhorOpcao(double precoGasolina, double precoEtanol ){

        double precoIdeal = precoGasolina * 0.70;
        String messagemDeRetorno;

        if (precoEtanol <= precoIdeal) {
            messagemDeRetorno = "melhor abastecer com Etanol";

        } else {
            messagemDeRetorno = "melhor abastecer com Gasolina";

        }
        return messagemDeRetorno;

    }

}
