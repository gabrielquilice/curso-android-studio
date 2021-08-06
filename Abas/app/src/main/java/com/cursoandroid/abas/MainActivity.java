package com.cursoandroid.abas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.cursoandroid.abas.Fragments.EmAltaFragment;
import com.cursoandroid.abas.Fragments.HomeFragment;
import com.cursoandroid.abas.Fragments.InscricoesFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smartTabLayout = findViewById(R.id.viewpagertab);
        viewPager = findViewById(R.id.viewpager);

        getSupportActionBar().setElevation(0);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Home", HomeFragment.class)
                .add("Inscricoes", InscricoesFragment.class)
                .add("Em alta", EmAltaFragment.class)
                .create());

        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
        
    }
}