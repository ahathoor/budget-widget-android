package com.example.budgetflow;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BudgetActivity extends Activity {


    PreferenceWrapper pref;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        pref = new PreferenceWrapper(this);
        EditText dailyBudget = (EditText) this.findViewById(R.id.dailyEdit);
        dailyBudget.setText("" + (int) pref.getDailyAllowance());
        dailyBudget.addTextChangedListener(new DailyTextWatcher(pref));
        TextView today = (TextView) findViewById(R.id.todaySpentDisplay);
        today.setText(pref.getPaymentsToday() + "€");

        TextView month = (TextView) findViewById(R.id.thisMonthSpentDisplay);
        month.setText(pref.getThisMonthSpent() + "€");
        
        Button ok = (Button) findViewById(R.id.okbutton);
        ok.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				finish();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_budget, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	super.onOptionsItemSelected(item);
    	switch(item.getItemId()) {
    	case R.id.clear_today :
    		pref.setPaymentsToday(0);
    		onCreate(null);
    	case R.id.menu_clear :
    		pref.clear();
    		pref.setDailyAllowance(10);
    		onCreate(null);
    	}
    	return true;
    }
}
