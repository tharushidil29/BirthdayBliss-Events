package com.s22009948.birthdaypartyplannerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.s22009948.birthdaypartyplannerapp.databinding.ActivityMainBinding;

public class DashboardPage extends AppCompatActivity {
    //Declare BottomNavigationView and FrameLayout variables
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_dashboard_page);
        // Initialize BottomNavigation and FrameLayout by finding views by ID
        bottomNavigationView = findViewById(R.id.bottomNavView);
        frameLayout = findViewById(R.id.frameLayout);

        //set an item selected listener for the BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Get the ID of the selected item
                int itemId = item.getItemId();
                // Load the corresponding fragment based on the selected item
                if (itemId == R.id.navHome){//nav home
                    loadFragment(new HomeFragment(), false);
                }else {//nav menu
                    loadFragment(new MenuFragment(),false);
                }
                return true;
            }
        });
        // Load the HomeFragment by default when the app is initialized
        loadFragment(new HomeFragment(),true);

    }
    //Method to load a fragment
    private void loadFragment(Fragment fragment, boolean isAppInitialized){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //if the app is initialized, add the fragment; otherwise, replace the fragment
        if (isAppInitialized){
            fragmentTransaction.add(R.id.frameLayout, fragment);
        }else {
            fragmentTransaction.replace(R.id.frameLayout, fragment);
        }
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        // Commit the transaction to apply the changes
        fragmentTransaction.commit();
    }
}