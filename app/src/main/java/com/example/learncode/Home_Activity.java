package com.example.learncode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;


public class Home_Activity extends AppCompatActivity {

    Button btnHome,btnCategory;
    CardView cardView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        cardView = findViewById(R.id.cardView);
        btnHome = findViewById(R.id.btn_home);

        btnCategory = findViewById(R.id.btn_course_category);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnHome.setAlpha(1);

                btnCategory.setAlpha((float) 0.5);
                FrameLayout frameLayout = findViewById(R.id.fragment_container);
                frameLayout.removeAllViews();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Home_Fragment()).commit();
            }
        });

        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnHome.setAlpha((float) 0.5);

                btnCategory.setAlpha(1);
                FrameLayout frameLayout = findViewById(R.id.fragment_container);
                frameLayout.removeAllViews();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Category_Fragmen()).commit();
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch (id) {
            case R.id.my_profile:
                intent = new Intent(getApplicationContext(), MyProfile_Activity.class);
                startActivity(intent);
                return true;
            case R.id.about_us:
                intent = new Intent(getApplicationContext(),About_Us.class);
                startActivity(intent);
                return true;
            case R.id.contect_us:
                intent = new Intent(getApplicationContext(),Contect_Us.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }


    }


    }



