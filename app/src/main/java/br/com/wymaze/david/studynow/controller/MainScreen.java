package br.com.wymaze.david.studynow.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.wymaze.david.studynow.R;
import br.com.wymaze.david.studynow.adapter.RotinaAdapter;
import br.com.wymaze.david.studynow.model.Rotina;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainScreen.this, CadastroRotina1.class);
                intent.putExtra("id", Long.valueOf(0));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista_rotina, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onResume() {
        super.onResume();
        final ArrayList<Rotina> rotinas = (ArrayList<Rotina>) Rotina.listAll(Rotina.class);

        ListView lista = (ListView) findViewById(R.id.lvrotinas);
        ArrayAdapter adapter = new RotinaAdapter(this, rotinas);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainScreen.this, CadastroRotina1.class);
                Bundle params = new Bundle();
                params.putStringArrayList("materias", rotinas.get(i).getMateria());
                params.putSerializable("h1", rotinas.get(i).getHora());
                params.putInt("seg", rotinas.get(i).getSeg());
                params.putInt("ter", rotinas.get(i).getTer());
                params.putInt("qua", rotinas.get(i).getQua());
                params.putInt("qui", rotinas.get(i).getQui());
                params.putInt("sex", rotinas.get(i).getSex());
                params.putInt("sab", rotinas.get(i).getSab());
                params.putInt("dom", rotinas.get(i).getDom());
                intent.putExtras(params);
                startActivity(intent);
            }
        });
    }
}