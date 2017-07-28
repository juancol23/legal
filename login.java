package legal_movil.com.legalmovil.View.Splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import legal_movil.com.legalmovil.Activity.SliderTutorial;
import legal_movil.com.legalmovil.ClasificarUsuario;
import legal_movil.com.legalmovil.LoginSign;
import legal_movil.com.legalmovil.R;

public class Splash extends AppCompatActivity {
    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prefs = getSharedPreferences("legal_movil.com.legalmovil.Activity.PreActiviry", MODE_PRIVATE);


        if (prefs.getBoolean("firstrun", true)) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    prefs.edit().putBoolean("firstrun", false).commit();
                    Toast.makeText(Splash.this, "Esto se mostrará solo una vez al instalar el App", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Splash.this, SliderTutorial.class));
                    finish();
                }
            }, 1000);

        }else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                   /* startActivity(new Intent(Splash.this, Main_Activity_Fragment.class));*/
                    startActivity(new Intent(Splash.this, ClasificarUsuario.class));
                    finish();
                }
            }, 1000);
        }




    }

}
