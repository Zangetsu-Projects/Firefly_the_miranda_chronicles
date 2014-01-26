package com.Master_Zangetsu.fireflygame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;

public class Levelselect extends Activity implements OnClickListener {

	Button Act1;
	Button Act2;
	Button Act3;
	Button Act4;
	Button Act5;
	Button Act6;
	
	RadioButton difficultyEasy;
	RadioButton difficultyNormal;
	RadioButton difficultyHard;
	
	Button Stats;

	int progressValue;
	
	int Easy = 1;
	int Normal = 2;
	int Hard = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.levelselect_activity);

		Act1 = (Button) findViewById(R.id.act1);
		Act2 = (Button) findViewById(R.id.act2);
		Act3 = (Button) findViewById(R.id.act3);
		Act4 = (Button) findViewById(R.id.act4);
		Act5 = (Button) findViewById(R.id.act5);
		Act6 = (Button) findViewById(R.id.act6);
		
		difficultyEasy = (RadioButton) findViewById(R.id.easy);
		difficultyNormal = (RadioButton) findViewById(R.id.normal);
		difficultyHard = (RadioButton) findViewById(R.id.hard);
		
		Stats = (Button) findViewById(R.id.stats);

		Act1.setVisibility(View.INVISIBLE);
		Act2.setVisibility(View.INVISIBLE);
		Act3.setVisibility(View.INVISIBLE);
		Act4.setVisibility(View.INVISIBLE);
		Act5.setVisibility(View.INVISIBLE);
		Act6.setVisibility(View.INVISIBLE);

		Act1.setEnabled(false);
		Act2.setEnabled(false);
		Act3.setEnabled(false);
		Act4.setEnabled(false);
		Act5.setEnabled(false);
		Act6.setEnabled(false);

		Act1.setOnClickListener((android.view.View.OnClickListener) this);
		Act2.setOnClickListener((android.view.View.OnClickListener) this);
		Act3.setOnClickListener((android.view.View.OnClickListener) this);
		Act4.setOnClickListener((android.view.View.OnClickListener) this);
		Act5.setOnClickListener((android.view.View.OnClickListener) this);
		Act6.setOnClickListener((android.view.View.OnClickListener) this);
		
		difficultyEasy.setOnClickListener((android.view.View.OnClickListener) this);
		difficultyNormal.setOnClickListener((android.view.View.OnClickListener) this);
		difficultyHard.setOnClickListener((android.view.View.OnClickListener) this);
		
		Stats.setOnClickListener((android.view.View.OnClickListener) this);

		loadPrefs();

	}
	
	private void savePrefs(String key, int value) {

		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		Editor edit = sp.edit();
		edit.putInt(key, value);
		edit.commit();

	}

	private void loadPrefs() {

		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);

		progressValue = sp.getInt("PLAYER_PROGRESS", 1);

		if (progressValue == 1) {

			Act1.setVisibility(View.VISIBLE);
			Act1.setEnabled(true);

		} else if (progressValue == 2) {

			Act1.setVisibility(View.VISIBLE);
			Act2.setVisibility(View.VISIBLE);

			Act1.setEnabled(true);
			Act2.setEnabled(true);

		} else if (progressValue == 3) {

			Act1.setVisibility(View.VISIBLE);
			Act2.setVisibility(View.VISIBLE);
			Act3.setVisibility(View.VISIBLE);

			Act1.setEnabled(true);
			Act2.setEnabled(true);
			Act3.setEnabled(true);

		} else if (progressValue == 4) {

			Act1.setVisibility(View.VISIBLE);
			Act2.setVisibility(View.VISIBLE);
			Act3.setVisibility(View.VISIBLE);
			Act4.setVisibility(View.VISIBLE);

			Act1.setEnabled(true);
			Act2.setEnabled(true);
			Act3.setEnabled(true);
			Act4.setEnabled(true);

		} else if (progressValue == 5) {

			Act1.setVisibility(View.VISIBLE);
			Act2.setVisibility(View.VISIBLE);
			Act3.setVisibility(View.VISIBLE);
			Act4.setVisibility(View.VISIBLE);
			Act5.setVisibility(View.VISIBLE);

			Act1.setEnabled(true);
			Act2.setEnabled(true);
			Act3.setEnabled(true);
			Act4.setEnabled(true);
			Act5.setEnabled(true);

		} else if (progressValue == 6) {

			Act1.setVisibility(View.VISIBLE);
			Act2.setVisibility(View.VISIBLE);
			Act3.setVisibility(View.VISIBLE);
			Act4.setVisibility(View.VISIBLE);
			Act6.setVisibility(View.VISIBLE);

			Act1.setEnabled(true);
			Act2.setEnabled(true);
			Act3.setEnabled(true);
			Act4.setEnabled(true);
			Act5.setEnabled(true);
			Act6.setEnabled(true);

		}

	}

	@Override
	public void onClick(final View v) {
		
		if (difficultyEasy.isChecked()){
			
			savePrefs("ACT_DIFFICULTY", Easy);
			
		} else if (difficultyNormal.isChecked()){
			
			savePrefs("ACT_DIFFICULTY", Normal);
			
		} else if (difficultyHard.isChecked()){
			
			savePrefs("ACT_DIFFICULTY", Hard);
			
		}

		if (v.getId() == R.id.act1) {

			// Intent intent = new Intent(v.getContext(), Act_1.class);
			// startActivityForResult(intent, 0);

			// Ask the user if they want to quit
			new AlertDialog.Builder(this)
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("Are you sure?")
					.setMessage(
							"Restarting this Act will erase ALL previous completion stats (Kills, Knowledge, Health)" + "\n" + "\n" +  "If this is your first time playing this level, ignore this message")
					.setPositiveButton("yes",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {

									// Do the action
									startActivity(new Intent(v.getContext(), Act_1.class));
								}

							}).setNegativeButton("no", null).show();
		} else if (v.getId() == R.id.stats) {
			
			startActivity(new Intent(v.getContext(), KnowledgeBase.class));
			
		}

	}

}
