package com.Master_Zangetsu.fireflygame;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Beginings extends Activity implements OnClickListener {

	Button Begin;
	Button Instructions;
	Button Join;
	
	
	int healthValue;
	int progressValue;
	
	String nameValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_beginings);

		Begin = (Button) findViewById(R.id.play);
		Instructions = (Button) findViewById(R.id.instructions);
		Join = (Button) findViewById(R.id.jointheteam);

		Begin.setOnClickListener((android.view.View.OnClickListener) this);
		Instructions.setOnClickListener((android.view.View.OnClickListener) this);
		Join.setOnClickListener((android.view.View.OnClickListener) this);
		
		loadPrefs();

	}

	
	private void loadPrefs() {

		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

		healthValue = sp.getInt("PLAYER_HEALTH", 100);
		nameValue = sp.getString("MONSTER_NAME", "Unknown");
		
		progressValue = sp.getInt("PLAYER_PROGRESS", 1);
		


	}
	
	private void savePrefs(String key, int value) {

		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit = sp.edit();
		edit.putInt(key, value);
		edit.commit();

	}

	private void savePrefs(String key, String value) {

		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit = sp.edit();
		edit.putString(key, value);
		edit.commit();

	}
	

	@Override
	public void onClick(View v) {

		if (v.getId() == R.id.play) {

			 Intent intent = new Intent(v.getContext(), CharacterCreation.class);
			 startActivityForResult(intent, 0);
		
		} else if (v.getId() == R.id.instructions) {

			Intent intent = new Intent(v.getContext(), Instructionspage.class);
			startActivityForResult(intent, 0);
			 
		} else if (v.getId() == R.id.jointheteam) {

			Intent intent = new Intent(v.getContext(), JoinTheTeam.class);
			startActivityForResult(intent, 0);
			 
		}

	}

}