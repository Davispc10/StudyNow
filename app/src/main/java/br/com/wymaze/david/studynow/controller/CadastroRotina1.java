package br.com.wymaze.david.studynow.controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.wymaze.david.studynow.R;
import br.com.wymaze.david.studynow.model.Materia;

public class CadastroRotina1 extends AppCompatActivity {
    int btn11 = 0, btn12 = 0, btn13 = 0, btn14 = 0, btn15 = 0, btn16 = 0, btn17 = 0;
    Long id;
    String descS;
    String h1, h2;
    Serializable materias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_rotina1);

        final NumberPicker noPicker1 = (NumberPicker) findViewById(R.id.numberPicker1);
        noPicker1.setMaxValue(24);
        noPicker1.setMinValue(1);
        noPicker1.setWrapSelectorWheel(false);

        final NumberPicker noPicker2 = (NumberPicker) findViewById(R.id.numberPicker2);
        noPicker2.setMaxValue(24);
        noPicker2.setMinValue(1);
        noPicker2.setWrapSelectorWheel(false);

        final Button btn1 = (Button) findViewById(R.id.btn1);
        final Button btn2 = (Button) findViewById(R.id.btn2);
        final Button btn3 = (Button) findViewById(R.id.btn3);
        final Button btn4 = (Button) findViewById(R.id.btn4);
        final Button btn5 = (Button) findViewById(R.id.btn5);
        final Button btn6 = (Button) findViewById(R.id.btn6);
        final Button btn7 = (Button) findViewById(R.id.btn7);
        final EditText desc = (EditText) findViewById(R.id.editText);

        Intent intent = getIntent();
        Bundle args = intent.getExtras();
        id = args.getLong("id");

        if (id != 0) {
            h1 = args.getString("h1");
            h2 = args.getString("h2");
            btn11 = args.getInt("seg");
            btn12 = args.getInt("ter");
            btn13 = args.getInt("qua");
            btn14 = args.getInt("qui");
            btn15 = args.getInt("sex");
            btn16 = args.getInt("sab");
            btn17 = args.getInt("dom");
            //materias = args.getSerializable("materias");
            descS = args.getString("descricao");

            desc.setText(descS);
            noPicker1.setValue(Integer.parseInt(h1));
            noPicker2.setValue(Integer.parseInt(h2));
            if (btn11 == 1) {
                btn1.setBackgroundColor(Color.argb(255, 63, 81, 181));
            }
            if (btn12 == 1) {
                btn2.setBackgroundColor(Color.argb(255, 63, 81, 181));
            }
            if (btn13 == 1) {
                btn3.setBackgroundColor(Color.argb(255, 63, 81, 181));
            }
            if (btn14 == 1) {
                btn4.setBackgroundColor(Color.argb(255, 63, 81, 181));
            }
            if (btn15 == 1) {
                btn5.setBackgroundColor(Color.argb(255, 63, 81, 181));
            }
            if (btn16 == 1) {
                btn6.setBackgroundColor(Color.argb(255, 63, 81, 181));
            }
            if (btn17 == 1) {
                btn7.setBackgroundColor(Color.argb(255, 63, 81, 181));
            }
        }

        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (noPicker1.getValue() >= noPicker2.getValue()) {
                    Context context = getApplicationContext();
                    CharSequence text = "A hora de início deve ser menor que a de término!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else if (btn11 == 0 && btn12 == 0 && btn13 == 0 && btn14 == 0 && btn15 == 0 && btn16 == 0 && btn17 == 0) {
                    Context context = getApplicationContext();
                    CharSequence text = "Voce deve marcar pelo menos um dia para a rotina!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    int qmaterias;
                    qmaterias = noPicker2.getValue() - noPicker1.getValue();
                    Intent intent = new Intent(CadastroRotina1.this, CadastroRotina2.class);
                    Bundle params = new Bundle();
                    params.putLong("id", Long.valueOf(id));
                    params.putInt("qmaterias", qmaterias);
                    params.putString("h1", String.valueOf(noPicker1.getValue()));
                    params.putString("h2", String.valueOf(noPicker2.getValue()));
                    params.putInt("seg", btn11);
                    params.putInt("ter", btn12);
                    params.putInt("qua", btn13);
                    params.putInt("qui", btn14);
                    params.putInt("sex", btn15);
                    params.putInt("sab", btn16);
                    params.putInt("dom", btn17);
                    params.putString("descricao", desc.getText().toString());
                    params.putSerializable("materias", materias);
                    intent.putExtras(params);
                    startActivity(intent);
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn11 == 0) {
                    btn1.setBackgroundColor(Color.argb(255, 63, 81, 181));
                    btn11 = 1;
                }
                else {
                    btn1.setBackgroundColor(Color.argb(255, 255, 255, 255));
                    btn11 = 0;
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn12 == 0) {
                    btn2.setBackgroundColor(Color.argb(255, 63, 81, 181));
                    btn12 = 1;
                }
                else {
                    btn2.setBackgroundColor(Color.argb(255, 255, 255, 255));
                    btn12 = 0;
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn13 == 0) {
                    btn3.setBackgroundColor(Color.argb(255, 63, 81, 181));
                    btn13 = 1;
                }
                else {
                    btn3.setBackgroundColor(Color.argb(255, 255, 255, 255));
                    btn13 = 0;
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn14 == 0) {
                    btn4.setBackgroundColor(Color.argb(255, 63, 81, 181));
                    btn14 = 1;
                }
                else {
                    btn4.setBackgroundColor(Color.argb(255, 255, 255, 255));
                    btn14 = 0;
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn15 == 0) {
                    btn5.setBackgroundColor(Color.argb(255, 63, 81, 181));
                    btn15 = 1;
                }
                else {
                    btn5.setBackgroundColor(Color.argb(255, 255, 255, 255));
                    btn15 = 0;
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn16 == 0) {
                    btn6.setBackgroundColor(Color.argb(255, 63, 81, 181));
                    btn16 = 1;
                }
                else {
                    btn6.setBackgroundColor(Color.argb(255, 255, 255, 255));
                    btn16 = 0;
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn17 == 0) {
                    btn7.setBackgroundColor(Color.argb(255, 63, 81, 181));
                    btn17 = 1;
                }
                else {
                    btn7.setBackgroundColor(Color.argb(255, 255, 255, 255));
                    btn17 = 0;
                }
            }
        });
    }
}
