package com.example.budgetflow;


import android.text.Editable;
import android.text.TextWatcher;

public class DailyTextWatcher implements TextWatcher {

	PreferenceWrapper pref;
	public DailyTextWatcher(PreferenceWrapper pref) {
		this.pref = pref;
	}
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		
	}

	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}

	public void onTextChanged(CharSequence s, int start, int before, int count) {
		int amount = Integer.parseInt("0" + s.toString());
        pref.setDailyAllowance(amount);
	}

}
