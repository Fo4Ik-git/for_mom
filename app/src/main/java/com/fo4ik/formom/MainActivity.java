package com.fo4ik.formom;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.fo4ik.formom.ui.home.HomeBrains;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Button result;
    EditText surface, lakme, powder, oxi, time, discount;
    TextView res;
    Spinner expenses;
    DBHelper dbHelper;


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);



        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_settings, R.id.nav_info)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onCalculate(View view) {

        final HomeBrains homeBrains = new HomeBrains();
        surface = (EditText) findViewById(R.id.surface);
        lakme = (EditText) findViewById(R.id.lakme);
        powder = (EditText) findViewById(R.id.powder);
        oxi = (EditText) findViewById(R.id.oxi);
        time = (EditText) findViewById(R.id.time);
        discount = (EditText) findViewById(R.id.discount);
        res = (TextView) findViewById(R.id.res);
        result = (Button) findViewById(R.id.result);

        homeBrains.calculate(surface, lakme, powder, oxi, time, discount, res);
    }

    public void addExpenses(View view) {

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void writeOnDB(View view) {
        dbHelper = new DBHelper(this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

    }
}
