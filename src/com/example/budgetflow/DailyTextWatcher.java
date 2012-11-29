package com.example.budgetflow;


import android.content.SharedPreferences.Editor;
import android.text.Editable;
import android.text.TextWatcher;

public class DailyTextWatcher implements TextWatcher {

	Editor prefEditor;
	public DailyTextWatcher(Editor prefedit) {
		this.prefEditor = prefedit;
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
        prefEditor.putFloat("daily allowance", amount);
        prefEditor.commit();
	}

}
