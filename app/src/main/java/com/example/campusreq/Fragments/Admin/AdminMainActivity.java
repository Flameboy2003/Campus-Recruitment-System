package com.example.campusreq.Fragments.Admin;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.campusreq.FirstActivity;
import com.example.campusreq.Fragments.Student.ContactUsFragment;
import com.example.campusreq.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class AdminMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);



        Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdminHomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.admin_nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdminHomeFragment()).commit();
        } else if (id == R.id.admin_nav_post) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdminPostJobsFragment()).commit();

        } else if (id == R.id.admin_nav_edit) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdminViewStudentsFragment()).commit();
        } else if (id == R.id.admin_nav_Applied) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdminUpdateFragment()).commit();
        } else if (id == R.id.admin_nav_about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdminAboutFragment()).commit();
        } else if (id == R.id.admin_nav_logout) {
            // Handle Logout item click
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(AdminMainActivity.this, FirstActivity.class));
            finish();

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if (item.getItemId() == R.id.contact_us) {
            // Handle contact us action
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ContactUsFragment()).commit();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
