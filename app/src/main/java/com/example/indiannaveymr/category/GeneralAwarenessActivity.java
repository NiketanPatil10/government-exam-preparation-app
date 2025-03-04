package com.example.indiannaveymr.category;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indiannaveymr.R;
import com.example.indiannaveymr.SubjectAdapter;
import com.example.indiannaveymr.SubjectModel;
import com.example.indiannaveymr.databinding.ActivityGeneralAwarenessBinding;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class GeneralAwarenessActivity extends AppCompatActivity {

    ArrayList<SubjectModel> list;
    SubjectAdapter adapter;
    RecyclerView recyclerView;

    ActivityGeneralAwarenessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGeneralAwarenessBinding.inflate(getLayoutInflater());
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
        binding.recSubject.setAdapter(adapter);


    }
}