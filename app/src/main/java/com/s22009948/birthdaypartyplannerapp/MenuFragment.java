package com.s22009948.birthdaypartyplannerapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.s22009948.birthdaypartyplannerapp.databinding.FragmentMenuBinding;


public class MenuFragment extends Fragment {
    //Declare Button variables
    Button btnabout;
    Button btnlogout;

    Button btnsetting;

    Button btnprofile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        // Initialize buttons by finding by ID
        btnabout = view.findViewById(R.id.btnabout);
        btnlogout = view.findViewById(R.id.btnlogout);
        btnsetting = view.findViewById(R.id.btnsetting);
        btnprofile = view.findViewById(R.id.btnprofile);

        //set onClickListener for about button to navigate to color change sensor activity
        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the color ChangeSensor page
                Intent intent = new Intent(getActivity(), ColorChangeSensor.class);
                startActivity(intent);
            }
        });
        //set onClickListener for Logout button to navigate to LogoutPage activity
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the LogOut page
                Intent intent = new Intent(getActivity(), LogoutPage.class);
                startActivity(intent);
            }
        });
        //set onClickListener for setting button to navigate to SettingPage activity
        btnsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the setting page
                Intent intent = new Intent(getActivity(), SettingPage.class);
                startActivity(intent);
            }
        });
        //set onClickListener for profile button to navigate to ProfilePage activity
        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the profile page
                Intent intent = new Intent(getActivity(), ProfilePage.class);
                startActivity(intent);
            }
        });
        // Return the view for this fragment
        return view;
    }
}



