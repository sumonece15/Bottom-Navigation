package com.example.bottomnavigation;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder alterDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_favorites:
                            selectedFragment = new FavoritesFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.shareId){

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String subject = "C Programming App";
            String body = "https://github.com/sumonece15/Recycler-CardView.git.";

            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);

            startActivity(Intent.createChooser(intent,"share with"));
        }

        else if (item.getItemId() == R.id.feedbackId){

            Intent intent = new Intent(getApplicationContext(),FeedbackActivity.class);
            startActivity(intent);


        }

        else if (item.getItemId() == R.id.aboutusId){

            Intent intent = new Intent(getApplicationContext(),AboutUsActivity.class);
            startActivity(intent);


        }

        else if (item.getItemId() == R.id.exitId){


            alterDialogBuilder = new AlertDialog.Builder(MainActivity.this);

            //for setting title
            alterDialogBuilder.setTitle(R.string.title_text);

            //for setting message
            alterDialogBuilder.setMessage(R.string.message_text);

            //for setting icon
            alterDialogBuilder.setIcon(R.mipmap.ic_launcher);

            alterDialogBuilder.setCancelable(false);
            alterDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    //exit
                    finish();
                }
            });

            alterDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  Toast.makeText(MainActivity.this, "You are still inside the app", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
            });

            alterDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {


                    Toast.makeText(MainActivity.this,"Your request has been canceled",Toast.LENGTH_SHORT).show();
                }
            });

            AlertDialog alertDialog = alterDialogBuilder.create();
            alertDialog.show();

        }




        return super.onOptionsItemSelected(item);
    }


}