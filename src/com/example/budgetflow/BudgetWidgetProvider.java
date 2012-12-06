package com.example.budgetflow;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class BudgetWidgetProvider extends AppWidgetProvider{
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;

        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];

            // Get the layout for the App Widget and attach on-click listeners
            // to the buttons
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widgetlayout);
            views.setOnClickPendingIntent(R.id.tens, WidgetActionHandlerService.makeControlPendingIntent(context, "increase tens", appWidgetId));
            views.setOnClickPendingIntent(R.id.ones, WidgetActionHandlerService.makeControlPendingIntent(context, "increase ones", appWidgetId));
            views.setOnClickPendingIntent(R.id.dimes, WidgetActionHandlerService.makeControlPendingIntent(context, "increase dimes", appWidgetId));
            views.setOnClickPendingIntent(R.id.cents, WidgetActionHandlerService.makeControlPendingIntent(context, "increase cents", appWidgetId));
            views.setOnClickPendingIntent(R.id.paybutton, WidgetActionHandlerService.makeControlPendingIntent(context, "register payment", appWidgetId));
		

            //Send an update notification to the action handler
            PendingIntent in = WidgetActionHandlerService.makeControlPendingIntent(context, "update", appWidgetId);
            try {
				in.send();
			} catch (CanceledException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
