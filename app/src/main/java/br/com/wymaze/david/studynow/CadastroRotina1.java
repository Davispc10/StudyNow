package br.com.wymaze.david.studynow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CadastroRotina1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_rotina1);

        Intent intent = getIntent();

        //getActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
