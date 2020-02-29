package com.example.fragmen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView btmNav;
    private Fragment selectedFragment = new MovieFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btmNav = findViewById(R.id.buttom);

        btmNav.setOnNavigationItemSelectedListener(this);
        loadFragment(selectedFragment);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_tvshow:
            selectedFragment = new ItemHero();
            break;

            case R.id.menu_movie:
            selectedFragment = new MovieFragment();
            break;
        }
        return loadFragment (selectedFragment);

    }

    private boolean loadFragment (Fragment SelectedFragment) {
        if(selectedFragment !=null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.tvmain_container,selectedFragment).commit();
            return  true;
        }else {
            return false;
        }

    }
}
