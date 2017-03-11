package com.esampaio.apps.multipleandroidtheme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends SuperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_mudar_estilo){
            mudarEstilo();
        }
        return super.onOptionsItemSelected(item);
    }

    public void clickLogin(View view){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

    private void mudarEstilo() {
        SharedPreferences sharedPreferences = getSharedPreferences("default-preferences", MODE_PRIVATE);
        String appTheme = sharedPreferences.getString("app_theme", null);
        if(appTheme==null || appTheme.equals("AppThemeTwo")){
            sharedPreferences.edit().putString("app_theme","AppThemeOne").commit();
        }else{
            sharedPreferences.edit().putString("app_theme","AppThemeTwo").commit();
        }
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}
