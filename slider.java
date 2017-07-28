package legal_movil.com.legalmovil.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

import legal_movil.com.legalmovil.ClasificarUsuario;
import legal_movil.com.legalmovil.LoginSign;
import legal_movil.com.legalmovil.R;

public class SliderTutorial extends AppCompatActivity {
    SharedPreferences clasificarInter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_tutorial);
        final ViewPager pager = (ViewPager) findViewById(R.id.pagerSlider);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        // Bind the tabs to the ViewPager
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabsSlider);
        tabs.setViewPager(pager);
        clasificarInter = getSharedPreferences("legal_movil.com.legalmovil", MODE_PRIVATE);

    }

    public void onClickOmitir(View v){
        clasificarInter.edit().putInt("firstrunClasificacion",0).commit();
        LoginManager.getInstance().logOut();
        FirebaseAuth.getInstance().signOut();

        Intent i = new Intent(SliderTutorial.this,LoginSign.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(i);

    }



}
