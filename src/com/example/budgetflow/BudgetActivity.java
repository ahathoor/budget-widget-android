package com.example.budgetflow;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class BudgetActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        TextView tw = (TextView)findViewById(R.id.hello);
        tw.setText(tw.getText() + " " + getIntent().getStringExtra("Amount"));
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_budget, menu);
        return true;
    }
}
