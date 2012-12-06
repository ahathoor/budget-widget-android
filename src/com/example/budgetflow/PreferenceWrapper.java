package com.example.budgetflow;

import java.util.Calendar;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class PreferenceWrapper {

	Context context;
	SharedPreferences preferences;
	Editor prefEditor;

	public PreferenceWrapper(Context context) {
		this.context = context;
		preferences = PreferenceManager.getDefaultSharedPreferences(context
				.getApplicationContext());
		prefEditor = preferences.edit();
	}

	public void clear() {
		prefEditor.clear();
		prefEditor.commit();
	}

	public void setDailyAllowance(float amount) {
		prefEditor.putFloat("daily allowance", amount);
		prefEditor.commit();
	}

	public int getTens() {
		return preferences.getInt("tens", 0);
	}

	public int getOnes() {
		return preferences.getInt("ones", 0);
	}

	public int getDimes() {
		return preferences.getInt("dimes", 0);
	}

	public int getCents() {
		return preferences.getInt("cents", 0);
	}

	public void setTens(int tens) {
    	prefEditor.putInt("tens", tens);
    	prefEditor.commit();
	}

	public void setOnes(int ones) {
    	prefEditor.putInt("ones", ones);
    	prefEditor.commit();
	}

	public void setDimes(int dimes) {
    	prefEditor.putInt("dimes", dimes);
    	prefEditor.commit();
	}

	public void setCents(int cents) {
    	prefEditor.putInt("cents", cents);
    	prefEditor.commit();
	}
	public float getDailyAllowance() {
		return preferences.getFloat("daily allowance", 0);
	}

	public float getPaymentsToday() {
		return preferences.getFloat(getDate(), 0);
	}
	
	public float getThisMonthSpent() {
    	Calendar c = Calendar.getInstance();
    	int year = c.get(Calendar.YEAR);
    	int month = c.get(Calendar.MONTH);
    	float sum = 0;
    	for (int day = 1; day<=31; day++) {
    		sum += (preferences.getFloat(year + "\\" + month + "\\" + day, 0));
    	}
    	return sum;
	}

	public void setPaymentsToday(float amount) {
		prefEditor.putFloat(getDate(), amount);
		prefEditor.commit();
	}
	
	public String getDate() {
    	Calendar c = Calendar.getInstance();
    	int year = c.get(Calendar.YEAR);
    	int month = c.get(Calendar.MONTH);
    	int day = c.get(Calendar.DAY_OF_MONTH);

    	return year + "\\" + month + "\\" + day;
	}

}
