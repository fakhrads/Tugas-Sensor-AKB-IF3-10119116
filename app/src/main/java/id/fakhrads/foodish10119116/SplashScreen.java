/**
 * NAMA : FAKHRI ADI SAPUTRA
 * NIM : 10119116
 * KELAS : IF-3
 */
package id.fakhrads.foodish10119116;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    private int waktu_loading=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent login = new Intent(SplashScreen.this, IntroActivity.class);
                startActivity(login);
                finish();

            }
        },waktu_loading);
    }
}