package com.s22009948.birthdaypartyplannerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment{
    //Declare Button variables
    Button btnaddinfo;
    Button btnloc;
    Button btnphoto;
    Button btndeco;
    Button btnhotel;
    Button btncake;
    Button btnmusic;
    Button btncards;
    Button btndress;
    Button btnidea;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Initialize buttons by finding by ID
        btnaddinfo = view.findViewById(R.id.btnaddinfo);
        btnloc = view.findViewById(R.id.btnloc);
        btnphoto = view.findViewById(R.id.btnphoto);
        btndeco = view.findViewById(R.id.btndeco);
        btnhotel = view.findViewById(R.id.btnhotel);
        btncake = view.findViewById(R.id.btncake);
        btnmusic = view.findViewById(R.id.btnmusic);
        btncards = view.findViewById(R.id.btncards);
        btndress = view.findViewById(R.id.btndress);
        btnidea = view.findViewById(R.id.btnidea);

        //set onClickListener for add information button to navigate to AddInformationPage activity
        btnaddinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the add information page
                Intent intent = new Intent(getActivity(), AddInformationPage.class);
                startActivity(intent);
            }
        });
        //set onClickListener for location button to navigate to LocationPage activity
        btnloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the Location page
                Intent intent = new Intent(getActivity(), LocationPage.class);
                startActivity(intent);
            }
        });
        //set onClickListener for photography button to navigate to PhotographyPage activity
        btnphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the photography page
                Intent intent = new Intent(getActivity(), PhotographyPage.class);
                startActivity(intent);
            }
        });
        //set onClickListener for decoration button to navigate to DecorationPage activity
        btndeco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the decoration page
                Intent intent = new Intent(getActivity(), DecorationPage.class);
                startActivity(intent);
            }
        });
        //set onClickListener for hotel button to navigate to HotelPage activity
        btnhotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the hotel page
                Intent intent = new Intent(getActivity(), Hotel.class);
                startActivity(intent);
            }
        });
        //set onClickListener for cake button to navigate to CakePage activity
        btncake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the cake page
                Intent intent = new Intent(getActivity(), CakePage.class);
                startActivity(intent);
            }
        });
        //set onClickListener for music button to navigate to MusicPage activity
        btnmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the music page
                Intent intent = new Intent(getActivity(), MusicPage.class);
                startActivity(intent);
            }
        });
        //set onClickListener for card button to navigate to CardPage activity
        btncards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the card page
                Intent intent = new Intent(getActivity(), CardPage.class);
                startActivity(intent);
            }
        });
        //set onClickListener for dress button to navigate to DressPage activity
        btndress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the Dress page
                Intent intent = new Intent(getActivity(), DressPage.class);
                startActivity(intent);
            }
        });
        //set onClickListener for idea button to navigate to Idea activity
        btnidea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the Idea page
                Intent intent = new Intent(getActivity(), Ideas.class);
                startActivity(intent);
            }
        });
        // Return the view for this fragment
        return view;
    }
}