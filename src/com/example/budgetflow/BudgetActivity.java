package com.example.budgetflow;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class BudgetActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Log.v("XX", "Mainwindow launched");
        setContentView(R.layout.activity_budget);
        TextView tw = (TextView)findViewById(R.id.hello);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Editor prefEditor = preferences.edit();
        prefEditor.putInt("money", 50);
        prefEditor.commit();
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_budget, menu);
        return true;
    }
}
