package com.fabio.app.gaseta.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.fabio.app.gaseta.R;
import com.fabio.app.gaseta.controller.CursoController;
import com.fabio.app.gaseta.controller.PessoaController;
import com.fabio.app.gaseta.model.Pessoa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;

    CursoController cursoController;

    Pessoa pessoa;
    List<String> nomeDosCursos;
    Pessoa outraPessoa;

    EditText editName;
    EditText editSobreNome;
    EditText editCurso;
    EditText editTelefone;

    Button limpar;
    Button salvar;
    Button finalizar;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        controller = new PessoaController(MainActivity.this);
        controller.toString();

        cursoController = new CursoController();
        nomeDosCursos = cursoController.dadosParaSpiner();

        pessoa = new Pessoa();
        controller.buscar(pessoa);

        editName = findViewById(R.id.edit_text_name);
        editSobreNome = findViewById(R.id.edit_text_sobre_nome);
        editCurso = findViewById(R.id.edit_text_curso);
        editTelefone = findViewById(R.id.edit_text_telefone);
        spinner = findViewById(R.id.spiner);

        editName.setText(pessoa.getPrimeiroNome());
        editSobreNome.setText(pessoa.getSobreNome());
        editCurso.setText(pessoa.getCursoDesejado());
        editTelefone.setText(pessoa.getTelefoneContato());

        limpar = findViewById(R.id.buttonLimpar);
        salvar = findViewById(R.id.buttonSalvar);
        finalizar = findViewById(R.id.buttonFinalizar);


        // adapter
        // layout
        // enjetar o adapter no spinner

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                cursoController.dadosParaSpiner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                spinner.setAdapter(adapter);


        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText("");
                editSobreNome.setText("");
                editCurso.setText("");
                editTelefone.setText("");

                controller.limpar();
            }
        });

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "salvo com sussesso", Toast.LENGTH_LONG).show();
                pessoa.setPrimeiroNome(editName.getText().toString());
                pessoa.setSobreNome(editSobreNome.getText().toString());
                pessoa.setCursoDesejado(editCurso.getText().toString());
                pessoa.setTelefoneContato(editTelefone.getText().toString());

                controller.salvar(pessoa);
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte Logo", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}