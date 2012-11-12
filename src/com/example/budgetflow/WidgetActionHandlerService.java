package com.example.budgetflow;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import android.widget.TextView;

public class WidgetActionHandlerService extends Service {

	public void onStart(Intent intent, int startId) {
		String command = intent.getAction();
		int widgetId = intent.getExtras().getInt(AppWidgetManager.EXTRA_APPWIDGET_ID);
		AppWidgetManager aw = AppWidgetManager
				.getInstance(getApplicationContext());
		RemoteViews views = new RemoteViews(getApplicationContext()
				.getPackageName(), R.layout.widgetlayout);
		

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Editor editor = preferences.edit();
        
        int tens = preferences.getInt("tens", 0);
        int ones = preferences.getInt("ones", 0);
        int dimes = preferences.getInt("dimes", 0);
        int cents = preferences.getInt("cents", 0);
        
        if (command == "increase tens") {
        	tens++;
        	if (tens > 9) tens = 0;
        	editor.putInt("tens", tens);
        }
        if (command == "increase ones") {
        	ones++;
        	if (ones > 9) ones = 0;
        	editor.putInt("ones",ones);
        }
        if (command == "increase dimes") {
        	dimes++;
        	if (dimes > 9) dimes = 0;
        	editor.putInt("dimes", dimes);
        }
        if (command == "increase cents") {
        	cents+=5;
        	if (cents > 9) cents = 0;
        	editor.putInt("cents", cents);
        }
        
        editor.commit();
		
		
		views.setCharSequence(R.id.tens, "setText", "" + tens);
		views.setCharSequence(R.id.ones, "setText", "" + ones);
		views.setCharSequence(R.id.dimes, "setText", "" + dimes);
		views.setCharSequence(R.id.cents, "setText", "" + cents);
		
		views.setInt(R.id.moneybar, "setProgress", 50);
  		aw.updateAppWidget(widgetId, views);

		Log.v("XX", "Handler launched");
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;

	}

	public static PendingIntent makeControlPendingIntent(Context context,
			String command, int appWidgetId) {
		Intent active = new Intent(context, WidgetActionHandlerService.class);
		active.setAction(command);
		active.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
		// this Uri data is to make the PendingIntent unique, so it wont be
		// updated by FLAG_UPDATE_CURRENT
		// so if there are multiple widget instances they wont override each
		// other
		Uri data = Uri.withAppendedPath(
				Uri.parse("countdownwidget://widget/id/#" + command
						+ appWidgetId), String.valueOf(appWidgetId));
		active.setData(data);
		return (PendingIntent.getService(context, 0, active,
				PendingIntent.FLAG_UPDATE_CURRENT));
	}

}
