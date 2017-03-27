package br.com.wymaze.david.studynow.controller;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.wymaze.david.studynow.R;
import br.com.wymaze.david.studynow.adapter.RotinaAdapter;
import br.com.wymaze.david.studynow.model.Materia;
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

                PendingIntent pi = PendingIntent.getActivity(MainScreen.this, 0, new Intent(MainScreen.this, CadastroRotina1.class), 0);
                Notification notification = new NotificationCompat.Builder(MainScreen.this)
                        .setTicker("hello")
                        .setSmallIcon(android.R.drawable.ic_menu_report_image)
                        .setContentTitle("estuda")
                        .setContentText("lets go")
                        .setContentIntent(pi)
                        .setAutoCancel(true)
                        .build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0, notification);

               /* NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(MainScreen.this)
                        .setSmallIcon(R.drawable.icon) // notification icon
                        .setContentTitle("Notification!") // title for notification
                        .setContentText("Hello word") // message for notification
                        .setAutoCancel(true); // clear notification after click

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(0, mBuilder.build());
                */

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
                params.putLong("id", rotinas.get(i).getId());
                //params.putSerializable("materias", (Serializable) materias);
                params.putSerializable("h1", rotinas.get(i).getTime1());
                params.putSerializable("h2", rotinas.get(i).getTime2());
                params.putInt("seg", rotinas.get(i).getSeg());
                params.putInt("ter", rotinas.get(i).getTer());
                params.putInt("qua", rotinas.get(i).getQua());
                params.putInt("qui", rotinas.get(i).getQui());
                params.putInt("sex", rotinas.get(i).getSex());
                params.putInt("sab", rotinas.get(i).getSab());
                params.putInt("dom", rotinas.get(i).getDom());
                params.putString("descricao", rotinas.get(i).getDescricao());
                intent.putExtras(params);
                startActivity(intent);
            }
        });
    }
}