package com.fabio.app.gaseta.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fabio.app.gaseta.R;
import com.fabio.app.gaseta.model.Combustivel;
import com.fabio.app.gaseta.util.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {

    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    EditText editGasolina;
    EditText editEtanol;

    TextView textResultado;

    Button calcular;
    Button limpar;
    Button salvar;
    Button finalizar;

    double precoGasolina;
    double precoEtanol;
    String recomendado;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        editGasolina = findViewById(R.id.edit_text_gasolina);
        editEtanol = findViewById(R.id.edit_text_etanol);

        editGasolina.setText(editGasolina.getText());
        editEtanol.setText(editEtanol.getText());

        textResultado = findViewById(R.id.text_view_resultado);

        calcular = findViewById(R.id.btn_calcular);
        limpar = findViewById(R.id.buttonLimpar);
        salvar = findViewById(R.id.buttonSalvar);
        finalizar = findViewById(R.id.buttonFinalizar);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDadosOk = true;

                if(TextUtils.isEmpty(editGasolina.getText()));{
                    editGasolina.setError("* Obrigatorio");
                    editGasolina.requestFocus();
                    isDadosOk = false;
                }

                if(TextUtils.isEmpty(editEtanol.getText()));{
                    editEtanol.setError("*Obrigatorio");
                    isDadosOk = false;
                }

                if (isDadosOk){

                    precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(editEtanol.getText().toString());

                    recomendado = UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol);

                    textResultado.setText(recomendado);

                    salvar.setEnabled(true);

                } else {
                    Toast.makeText(GasEtaActivity.this, "Digitar os Campos Obrigátorios", Toast.LENGTH_LONG).show();
                    salvar.setEnabled(false);
                }

            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editGasolina.setText("");
                editEtanol.setText("");

                salvar.setEnabled(false);
            }
        });

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                combustivelGasolina = new Combustivel();
                combustivelGasolina.setNomeDoCombustivel("Gasolina");
                combustivelGasolina.setPrecoDoCombustivel(precoGasolina);

                combustivelEtanol = new Combustivel();
                combustivelEtanol.setNomeDoCombustivel("Etanol");
                combustivelEtanol.setPrecoDoCombustivel(precoEtanol);

                combustivelGasolina.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));
                combustivelEtanol.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));

            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasEtaActivity.this, "Finalizando o App", Toast.LENGTH_SHORT).show();
                finish();;
            }
        });
    }
}
