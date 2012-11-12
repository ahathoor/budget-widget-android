package com.example.budgetflow;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.RemoteViews;

public class BudgetWidgetProvider extends AppWidgetProvider{
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;

        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];

            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widgetlayout);
            views.setOnClickPendingIntent(R.id.tens, WidgetActionHandlerService.makeControlPendingIntent(context, "increase tens", appWidgetId));
//            views.setOnClickPendingIntent(R.id.ones, onesPending);
//            views.setOnClickPendingIntent(R.id.dimes, dimesPending);
//            views.setOnClickPendingIntent(R.id.cents, centsPending);
//            views.setOnClickPendingIntent(R.id.paybutton, payPending);
		

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
