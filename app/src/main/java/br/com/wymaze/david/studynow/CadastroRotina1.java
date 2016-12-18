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
    int btn11 = 0, btn12 = 0, ibtn13 = 0, btn14 = 0, btn15 = 0, btn16 = 0, btn17 = 0;

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

        final Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);

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
    }
}
