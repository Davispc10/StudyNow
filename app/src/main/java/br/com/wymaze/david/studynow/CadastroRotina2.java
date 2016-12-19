package br.com.wymaze.david.studynow;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroRotina2 extends AppCompatActivity {
    int materia = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_rotina2);

        Intent intent = getIntent();
        Bundle args = intent.getExtras();
        final int materias = args.getInt("materias");

        final Button btnSalvar = (Button) findViewById(R.id.btnSalvar);
        final EditText edtMateria = (EditText) findViewById(R.id.edtMateria);

        final String TAG = "MyActivity";
        Log.i(TAG, "qt: " + materias);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtMateria.getText().toString().isEmpty()) {
                    if (materia < materias) {
                        Context context = getApplicationContext();
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
                        CharSequence text = "Rotina Salva!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
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
