package br.com.wymaze.david.studynow.controller;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.wymaze.david.studynow.R;
import br.com.wymaze.david.studynow.model.Materia;
import br.com.wymaze.david.studynow.model.Rotina;

import static android.R.attr.data;
import static android.R.attr.imageButtonStyle;

public class CadastroRotina2 extends AppCompatActivity {
    int iMateria = 0, qmaterias;
    String h1, h2;
    int btn11 = 0, btn12 = 0, btn13 = 0, btn14 = 0, btn15 = 0, btn16 = 0, btn17 = 0;
    String descricao;
    List<String> listMaterias2;
    List<Materia> listMaterias;
    EditText edtMateria;
    Long id;

    AlarmManager alarm_manager;
    //TimePicker alarm_timepicker;
    //TextView update_text;
    Context context;
    PendingIntent pending_intent;
    //int choose_whale_sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_rotina2);

        final Intent intent = getIntent();
        Bundle args = intent.getExtras();
        id = args.getLong("id");
        qmaterias = args.getInt("qmaterias");
        h1 = args.getString("h1");
        h2 = args.getString("h2");
        btn11 = args.getInt("seg");
        btn12 = args.getInt("ter");
        btn13 = args.getInt("qua");
        btn14 = args.getInt("qui");
        btn15 = args.getInt("sex");
        btn16 = args.getInt("sab");
        btn17 = args.getInt("dom");
        descricao = args.getString("descricao");

        // initialize our alarm manager
        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(h1));

        // create an intent to the Alarm Receiver class
        //final Intent my_intent = new Intent(this.context, AlarmReceiver.class);

        final Button btnSalvar = (Button) findViewById(R.id.btnSalvar);
        edtMateria = (EditText) findViewById(R.id.edtMateria);

        if (id != 0) {
            //listMaterias = args.getStringArrayList("materias");
            listMaterias = Materia.find(Materia.class, "rotina = ?", String.valueOf(id));
            //listMaterias = (ArrayList<String>) args.getSerializable("materias");
            if (listMaterias.size() > 0)
                edtMateria.setText(listMaterias.get(iMateria).getDescricao());
        }
        listMaterias2 = new ArrayList<>();

        final String TAG = "MyActivity";
        Log.i(TAG, "qt: " + qmaterias);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (!edtMateria.getText().toString().isEmpty()) {
                iMateria += 1;
                if (iMateria <= qmaterias) {
                    Context context = getApplicationContext();
                    listMaterias2.add(edtMateria.getText().toString());
                    if (id != 0 && listMaterias.size() > 0 &&  iMateria < listMaterias.size()) {
                        edtMateria.setText(listMaterias.get(iMateria).getDescricao());
                    }
                    else {
                        edtMateria.setText("");
                        edtMateria.setHint("Matéria " + (iMateria+1));
                    }
                    CharSequence text = "Matéria Salva";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                if (iMateria == qmaterias) {
                    Context context = getApplicationContext();
//                        DateFormat formatter = new SimpleDateFormat("hh");
//                        try {
//                            time1 = formatter.parse(String.valueOf(h1));
//                            time2 = formatter.parse(String.valueOf(h2));
//                        } catch (ParseException e) {
//                            e.printStackTrace();
//                        }

                    if (id != 0) {
                        Rotina rotina = Rotina.findById(Rotina.class, id);
                        rotina.setTime1(h1);
                        rotina.setTime2(h2);
                        rotina.setSeg(btn11);
                        rotina.setTer(btn12);
                        rotina.setQua(btn13);
                        rotina.setQui(btn14);
                        rotina.setSex(btn15);
                        rotina.setSab(btn16);
                        rotina.setDom(btn17);
                        rotina.setDescricao(descricao);
                        rotina.save();

                        for (int i = 0; i < qmaterias; i++) {
                            if (listMaterias.size() > i) {
                                Materia materia = listMaterias.get(i);
                                materia.setDescricao(listMaterias2.get(i));
                                materia.save();
                            }
                            else {
                                Materia materia = new Materia(rotina.getId(), listMaterias2.get(i), rotina);
                                materia.save();
                            }
                        }

                        for (int i = iMateria; i < listMaterias.size(); i++) {
                            listMaterias.get(i).delete();
                        }
                    }
                    else {
                        Rotina rotina = new Rotina(h1, h2, btn11, btn12, btn13, btn14, btn15, btn16, btn17, descricao);
                        rotina.save();
                        for (int i = 0; i < listMaterias2.size(); i++) {
                            Log.i(TAG, "lista: " + listMaterias2.get(i).toString() + "id: " + rotina.getId().toString());
                            Materia materia = new Materia(rotina.getId(), listMaterias2.get(i), rotina);
                            materia.save();
                        }
                    }

                    pending_intent = PendingIntent.getBroadcast(context, 0,
                            intent, PendingIntent.FLAG_UPDATE_CURRENT);

                    // set the alarm manager
                    alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                            pending_intent);

                    // make the notification parameters
                    Notification notification_popup = new Notification.Builder(context)
                            .setContentTitle("Vamos Estudar!")
                            .setContentText(qmaterias + " matérias para estudar!")
                            .setSmallIcon(R.drawable.icon)
                            .setContentIntent(pending_intent)
                            .setAutoCancel(true)
                            .build();

                    NotificationManager notify_manager = (NotificationManager)
                            getSystemService(NOTIFICATION_SERVICE);

                    // set up the start command for the notification
                    notify_manager.notify(0, notification_popup);

                    Toast toast = Toast.makeText(context, "Rotina Salva!", Toast.LENGTH_SHORT);
                    toast.show();
                    startActivity(new Intent(CadastroRotina2.this, MainScreen.class));
                }
                Log.i(TAG, "qt: " + iMateria);
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
