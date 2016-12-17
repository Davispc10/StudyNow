package br.com.wymaze.david.studynow;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//AppCompatActivity
public class SplashScreen extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(this, 2000);
    }

    @Override
    public  void run() {
        startActivity(new Intent(this, MainScreen.class));
        finish();
    }
}
