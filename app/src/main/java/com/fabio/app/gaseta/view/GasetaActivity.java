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
import com.fabio.app.gaseta.controller.CombustivelController;
import com.fabio.app.gaseta.model.Combustivel;
import com.fabio.app.gaseta.util.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {

    CombustivelController controller;

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

                if(TextUtils.isEmpty(editGasolina.getEditableText())){
                    editGasolina.setError("Digitar o Valor");
                    Toast.makeText(GasEtaActivity.this, "Digitar os Campos Obrigátorios", Toast.LENGTH_LONG).show();
                    isDadosOk = false;
                } else if (TextUtils.isEmpty(editEtanol.getEditableText())){
                    editEtanol.setError("Digitar o valor");
                    Toast.makeText(GasEtaActivity.this, "Digitar os Campos Obrigátorios", Toast.LENGTH_LONG).show();
                    isDadosOk = false;
                } else if (isDadosOk) {
                    precoGasolina = Double.parseDouble(editGasolina.getEditableText().toString());
                    precoEtanol = Double.parseDouble(editEtanol.getEditableText().toString());

                    recomendado = UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol);

                    textResultado.setText(recomendado);
                    salvar.setEnabled(true);
                } else {
                    salvar.setEnabled(false);
                }
/*                if(TextUtils.isEmpty(editGasolina.getText()));{
                    editGasolina.setError("* Obrigatorio");
                    editGasolina.requestFocus();
                    isDadosOk = false;
                }*/

/*
                if(TextUtils.isEmpty(editEtanol.getText()));{
                    editEtanol.setError("*Obrigatorio");
                    editEtanol.requestFocus();
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
*/

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

                if (TextUtils.isEmpty(editGasolina.getEditableText())){
                    Toast.makeText(GasEtaActivity.this, "Digitar os Campos Obrigátorios", Toast.LENGTH_LONG).show();
                    salvar.setEnabled(false);
                } else
                if (TextUtils.isEmpty(editEtanol.getEditableText())){
                    Toast.makeText(GasEtaActivity.this, "Digitar os Campos Obrigátorios", Toast.LENGTH_LONG).show();
                    salvar.setEnabled(false);}
                else
                {controller = new CombustivelController(GasEtaActivity.this );

                    combustivelGasolina = new Combustivel();
                    combustivelGasolina.setNomeDoCombustivel("Gasolina");
                    combustivelGasolina.setPrecoDoCombustivel(precoGasolina);

                    combustivelEtanol = new Combustivel();
                    combustivelEtanol.setNomeDoCombustivel("Etanol");
                    combustivelEtanol.setPrecoDoCombustivel(precoEtanol);

                    combustivelGasolina.setRecomendado(UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));
                    combustivelEtanol.setRecomendado(UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));

                    controller.salvar(combustivelGasolina);
                    controller.salvar(combustivelEtanol);

                    Toast.makeText(GasEtaActivity.this, "SALVO COM SUSSESSO", Toast.LENGTH_SHORT).show();
                }


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
