/**
 * NAMA : FAKHRI ADI SAPUTRA
 * NIM : 10119116
 * KELAS : IF-3
 */
package id.fakhrads.foodish10119116;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class IntroActivity extends AppCompatActivity {

    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private DotsIndicator dotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getSupportActionBar().hide();
        viewPager = findViewById(R.id.viewpager);

        // setting up the adapter
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // add the fragments
        viewPagerAdapter.add(new intro_page1(), "");
        viewPagerAdapter.add(new intro_page2(), "");
        viewPagerAdapter.add(new intro_page3(), "");

        // Set the adapter

        // The Page (fragment) titles will be displayed in the
        // tabLayout hence we need to  set the page viewer
        // we use the setupWithViewPager().
        dotsIndicator = (DotsIndicator) findViewById(R.id.dots_indicator);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(viewPagerAdapter);
        dotsIndicator.setViewPager(viewPager);


    }
    public void toMain(View view) {

        Intent Profile = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(Profile);
    }
}