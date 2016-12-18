package br.com.wymaze.david.studynow;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

public class CadastroRotina1 extends AppCompatActivity {
    int btn11 = 0, btn12 = 0, btn13 = 0, btn14 = 0, btn15 = 0, btn16 = 0, btn17 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_rotina1);

        final Intent intent = getIntent();

        NumberPicker noPicker1 = (NumberPicker) findViewById(R.id.numberPicker1);
        noPicker1.setMaxValue(24);
        noPicker1.setMinValue(1);
        noPicker1.setWrapSelectorWheel(false);

        NumberPicker noPicker2 = (NumberPicker) findViewById(R.id.numberPicker2);
        noPicker2.setMaxValue(24);
        noPicker2.setMinValue(1);
        noPicker2.setWrapSelectorWheel(false);

        Button btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CadastroRotina1.this, CadastroRotina2.class));
            }
        });

        final Button btn1 = (Button) findViewById(R.id.btn1);
        final Button btn2 = (Button) findViewById(R.id.btn2);
        final Button btn3 = (Button) findViewById(R.id.btn3);
        final Button btn4 = (Button) findViewById(R.id.btn4);
        final Button btn5 = (Button) findViewById(R.id.btn5);
        final Button btn6 = (Button) findViewById(R.id.btn6);
        final Button btn7 = (Button) findViewById(R.id.btn7);

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
