package com.example.budgetflow;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class BudgetActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Editor prefEditor = preferences.edit();
        prefEditor.clear();
        prefEditor.putFloat("daily allowance", 20);
        prefEditor.commit();
        EditText dailyBudget = (EditText) this.findViewById(R.id.dailyEdit);
        dailyBudget.setText("" + (int) preferences.getFloat("daily allowance", 10));
        dailyBudget.addTextChangedListener(new DailyTextWatcher(prefEditor));
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_budget, menu);
        return true;
    }
}
