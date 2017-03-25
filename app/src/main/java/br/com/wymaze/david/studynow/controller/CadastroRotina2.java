package br.com.wymaze.david.studynow.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.wymaze.david.studynow.R;
import br.com.wymaze.david.studynow.model.Rotina;

public class CadastroRotina2 extends AppCompatActivity {
    int materia = 1, h1, h2;
    int btn11 = 0, btn12 = 0, btn13 = 0, btn14 = 0, btn15 = 0, btn16 = 0, btn17 = 0;
    String descricao;
    ArrayList<String> listMaterias;
    EditText edtMateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_rotina2);

        Intent intent = getIntent();
        Bundle args = intent.getExtras();
        final int materias = args.getInt("materias");
        h1 = args.getInt("h1");
        h2 = args.getInt("h2");
        btn11 = args.getInt("seg");
        btn12 = args.getInt("ter");
        btn13 = args.getInt("qua");
        btn14 = args.getInt("qui");
        btn15 = args.getInt("sex");
        btn16 = args.getInt("sab");
        btn17 = args.getInt("dom");
        descricao = args.getString("descricao");
        listMaterias = new ArrayList<>();

        final Button btnSalvar = (Button) findViewById(R.id.btnSalvar);
        edtMateria = (EditText) findViewById(R.id.edtMateria);

        final String TAG = "MyActivity";
        Log.i(TAG, "qt: " + materias);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtMateria.getText().toString().isEmpty()) {
                    if (materia < materias) {
                        Context context = getApplicationContext();
                        listMaterias.add(edtMateria.getText().toString());

                        CharSequence text = "Matéria Salva";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        edtMateria.setText("");
                        materia += 1;
                        edtMateria.setHint("Matéria " + materia);
                    }
                    else {
                        Context context = getApplicationContext();

                        Date time = null;
                        DateFormat formatter = new SimpleDateFormat("hh");
                        try {
                            time = formatter.parse(String.valueOf(h1));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Rotina rotina = new Rotina(time, btn11, btn12, btn13, btn14, btn15, btn16, btn17, listMaterias, descricao);
                        rotina.save();

                        Toast toast = Toast.makeText(context, "Rotina Salva!", Toast.LENGTH_SHORT);
                        toast.show();
                        startActivity(new Intent(CadastroRotina2.this, MainScreen.class));
                    }
                    Log.i(TAG, "qt: " + materia);
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "Preencha o campo matéria!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
}
