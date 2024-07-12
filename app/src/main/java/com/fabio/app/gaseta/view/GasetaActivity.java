package com.fabio.app.gaseta.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.fabio.app.gaseta.R;
import com.fabio.app.gaseta.controller.PessoaController;
import com.fabio.app.gaseta.model.Pessoa;

public class GasetaActivity extends AppCompatActivity {

    PessoaController controller;

    Pessoa pessoa;

    EditText editGasolina;
    EditText editEtanol;

    TextView resultado;

    Button calcular;
    Button limpar;
    Button salvar;
    Button finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        controller = new PessoaController(GasetaActivity.this);
        controller.toString();

        pessoa = new Pessoa();
        controller.buscar(pessoa);

        editGasolina = findViewById(R.id.edit_text_gasolina);
        editEtanol = findViewById(R.id.edit_text_etanol);
        resultado = findViewById(R.id.text_view_resultado);

        editGasolina.setText(pessoa.getPrimeiroNome());
        editEtanol.setText(pessoa.getSobreNome());

        calcular = findViewById(R.id.btn_calcular);
        limpar = findViewById(R.id.buttonLimpar);
        salvar = findViewById(R.id.buttonSalvar);
        finalizar = findViewById(R.id.buttonFinalizar);


        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editGasolina.setText("");
                editEtanol.setText("");

                controller.limpar();
            }
        });

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasetaActivity.this, "salvo com sussesso", Toast.LENGTH_LONG).show();
                pessoa.setPrimeiroNome(editGasolina.getText().toString());
                pessoa.setSobreNome(editEtanol.getText().toString());

                controller.salvar(pessoa);
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasetaActivity.this, "Volte Logo", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}