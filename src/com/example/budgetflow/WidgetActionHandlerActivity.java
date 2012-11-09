package com.example.budgetflow;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class WidgetActionHandlerActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	Intent incomingIntent = getIntent();
	String action = incomingIntent.getStringExtra("action");
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
