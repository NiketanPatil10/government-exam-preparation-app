package com.example.indiannaveymr;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indiannaveymr.category.GKGSStaticGKActivity;
import com.example.indiannaveymr.category.GeneralAwarenessActivity;
import com.example.indiannaveymr.category.GeneralIntelligenceandReasoningActivity;
import com.example.indiannaveymr.category.MathematicsActivity;
import com.example.indiannaveymr.category.PreviousYearQuestionPaperActivity;
import com.example.indiannaveymr.category.ReasoningActivity;
import com.example.indiannaveymr.category.SampleQuestionPaperActivity;
import com.example.indiannaveymr.category.ScienceActivity;
import com.example.indiannaveymr.databinding.ActivityMainBinding;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;



public class  MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<SubjectModel> list;
    SubjectAdapter adapter;
    RecyclerView recyclerView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menu;
    View header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        // banners ads

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.adsview.loadAd(adRequest);



        list = new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        binding.recSubject.setLayoutManager(manager);

        list.add(new SubjectModel("Chapter 1"));
        list.add(new SubjectModel("Chapter 2"));
        list.add(new SubjectModel("Chapter 3"));
        list.add(new SubjectModel("Chapter 4"));
        list.add(new SubjectModel("Chapter 5"));
        list.add(new SubjectModel("Chapter 6"));
        list.add(new SubjectModel("Chapter 7"));
        list.add(new SubjectModel("Chapter 8"));
        list.add(new SubjectModel("Chapter 9"));
        list.add(new SubjectModel("Chapter 10"));

        adapter = new SubjectAdapter(this,list);
        //binding.recSubject.setAdapter(adapter);

        header = binding.navView.getHeaderView(0);

        binding.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)){

                    binding.drawerLayout.closeDrawer(GravityCompat.START);

                }else {
                    binding.drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });


        binding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId(); // Get the clicked item's ID

                if (id == R.id.home) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                } else if (id == R.id.share) {
                    String shareBody = "Hey I am using BookApp";
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,shareBody);
                    startActivity(intent);

                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                } else if (id == R.id.rate) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/")));

                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    // Default case for unhandled menu items
                }

                return true;
            }
        });




        binding.GeneralAwareness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GeneralAwarenessActivity.class));
            }
        });


        binding.GKGSStaticGK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GKGSStaticGKActivity.class));
            }
        });


        binding.Mathematics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MathematicsActivity.class));
            }
        });


        binding.Science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScienceActivity.class));
            }
        });


        binding.GeneralIntelligenceandReasoning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GeneralIntelligenceandReasoningActivity.class));
            }
        });


        binding.Reasoning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ReasoningActivity.class));
            }
        });


        binding.PreviousYearQuestionPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PreviousYearQuestionPaperActivity.class));
            }
        });


        binding.SampleQuestionPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SampleQuestionPaperActivity.class));
            }
        });

    }


    @Override
    public void onBackPressed() {

        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)){

            binding.drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {

            super.onBackPressed();
        }
    }
}