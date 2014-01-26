package com.Master_Zangetsu.fireflygame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Instructionspage extends Activity implements OnClickListener {
	
	Button Back;
	
	// a = 14 - 20, b = 21 - 30, c = 30 - 40.

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.instructions_activity);
		
		Back = (Button) findViewById(R.id.button1);
		
		Back.setOnClickListener((android.view.View.OnClickListener) this);
		
	}

	@Override
	public void onClick(View v) {
		
		Intent intent = new Intent(v.getContext(), Beginings.class);
		startActivityForResult(intent, 0);
		
		
	}

}