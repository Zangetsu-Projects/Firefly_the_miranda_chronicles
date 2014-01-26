package com.Master_Zangetsu.fireflygame;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class KnowledgeBase extends Activity implements OnClickListener {

	Button act1;
	Button act2;
	Button act3;
	Button act4;
	Button act5;
	Button act6;

	boolean InfoValue1;
	boolean InfoValue2;
	boolean InfoValue3;
	boolean InfoValue4;
	boolean InfoValue5;
	boolean InfoValue6;
	boolean InfoValue7;
	boolean InfoValue8;
	boolean InfoValue9;
	boolean InfoValue10;

	boolean InfoValue11;
	boolean InfoValue12;
	boolean InfoValue13;
	boolean InfoValue14;
	boolean InfoValue15;
	boolean InfoValue16;
	boolean InfoValue17;
	boolean InfoValue18;
	boolean InfoValue19;
	boolean InfoValue20;

	int act1Health;
	int act1Damage;
	int act1Kills;
	double act1Progress;
	String nameValue;
	int progressValue;

	TextView incomplete;

	RelativeLayout actGroup;
	TextView actTitle;
	TextView actStats;
	TextView actDetails;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.knowledge_activity);

		act1 = (Button) findViewById(R.id.act1);
		act2 = (Button) findViewById(R.id.act2);
		act3 = (Button) findViewById(R.id.act3);
		act4 = (Button) findViewById(R.id.act4);
		act5 = (Button) findViewById(R.id.act5);
		act6 = (Button) findViewById(R.id.act6);

		act1.setOnClickListener((android.view.View.OnClickListener) this);
		act2.setOnClickListener((android.view.View.OnClickListener) this);
		act3.setOnClickListener((android.view.View.OnClickListener) this);
		act4.setOnClickListener((android.view.View.OnClickListener) this);
		act5.setOnClickListener((android.view.View.OnClickListener) this);
		act6.setOnClickListener((android.view.View.OnClickListener) this);

		incomplete = (TextView) findViewById(R.id.nostats);

		actGroup = (RelativeLayout) findViewById(R.id.actgroup);
		actTitle = (TextView) findViewById(R.id.acttitle);
		actStats = (TextView) findViewById(R.id.actstats);
		actDetails = (TextView) findViewById(R.id.actdetails);

		loadPrefs();

	}

	private void loadPrefs() {

		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);

		act1Damage = sp.getInt("ACT_1_PLAYER_DAMAGE", 0);
		act1Health = sp.getInt("ACT_1_PLAYER_HEALTH", 100);
		act1Kills = sp.getInt("ACT_1_PLAYER_KILLS", 0);
		act1Progress = ((double) sp.getInt("ACT_1_PROGRESS", 0) / 40) * 100;

		nameValue = sp.getString("MONSTER_NAME", "Unknown");

		InfoValue1 = sp.getBoolean("INFO_VALUE_1", false);
		InfoValue2 = sp.getBoolean("INFO_VALUE_2", false);
		InfoValue3 = sp.getBoolean("INFO_VALUE_3", false);
		InfoValue4 = sp.getBoolean("INFO_VALUE_4", false);
		InfoValue5 = sp.getBoolean("INFO_VALUE_5", false);
		InfoValue6 = sp.getBoolean("INFO_VALUE_6", false);
		InfoValue7 = sp.getBoolean("INFO_VALUE_7", false);
		InfoValue8 = sp.getBoolean("INFO_VALUE_8", false);
		InfoValue9 = sp.getBoolean("INFO_VALUE_9", false);
		InfoValue10 = sp.getBoolean("INFO_VALUE_10", false);

		InfoValue11 = sp.getBoolean("INFO_VALUE_1", false);
		InfoValue12 = sp.getBoolean("INFO_VALUE_2", false);
		InfoValue13 = sp.getBoolean("INFO_VALUE_3", false);
		InfoValue14 = sp.getBoolean("INFO_VALUE_4", false);
		InfoValue15 = sp.getBoolean("INFO_VALUE_5", false);
		InfoValue16 = sp.getBoolean("INFO_VALUE_6", false);
		InfoValue17 = sp.getBoolean("INFO_VALUE_7", false);
		InfoValue18 = sp.getBoolean("INFO_VALUE_8", false);
		InfoValue19 = sp.getBoolean("INFO_VALUE_9", false);
		InfoValue20 = sp.getBoolean("INFO_VALUE_10", false);

		progressValue = sp.getInt("PLAYER_PROGRESS", 1);

		actDetails.setText("Aquired Knowledge");

		if (InfoValue1 == true) {
			actDetails.append("\n" + "\n" + getString(R.string.InfoValue1));
		} else {
			act1Progress = act1Progress - 5;
		}

		if (InfoValue2 == true) {

			actDetails.append("\n" + "\n" + getString(R.string.InfoValue2));
		} else {
			act1Progress = act1Progress - 5;
		}

		if (InfoValue4 == true) {
			actDetails.append("\n" + "\n" + getString(R.string.InfoValue4));
		} else {
			act1Progress = act1Progress - 5;
		}

		if (InfoValue5 == true) {
			actDetails.append("\n" + "\n" + getString(R.string.InfoValue5));
		} else {
			act1Progress = act1Progress - 5;
		}

		if (InfoValue6 == true) {
			actDetails.append("\n" + "\n" + getString(R.string.InfoValue6));
		} else {
			act1Progress = act1Progress - 5;
		}

		if (InfoValue7 == true) {
			actDetails.append("\n" + "\n" + getString(R.string.InfoValue7));
		} else {
			act1Progress = act1Progress - 5;
		}

		if (InfoValue8 == true) {
			actDetails.append("\n" + "\n" + getString(R.string.InfoValue8));
		} else {
			act1Progress = act1Progress - 5;
		}

		if (InfoValue9 == true) {
			actDetails.append("\n" + "\n" + getString(R.string.InfoValue9));
		} else {
			act1Progress = act1Progress - 5;
		}

		if (InfoValue10 == true) {
			actDetails.append("\n" + "\n" + getString(R.string.InfoValue10));
		} else {
			act1Progress = act1Progress - 5;
		}

		String percentage = (new DecimalFormat("##.##").format(act1Progress) + "%");
		
		actStats.setText("Percentage Complete: " + percentage + "\n"
				+ "Health: " + act1Health + "\n" + "Kills: " + act1Kills + "\n"
				+ "Lasting Damage: " + act1Damage);

		if (progressValue == 0) {

			incomplete.setVisibility(View.VISIBLE);
			actGroup.setVisibility(View.INVISIBLE);

		} else if (progressValue == 1) {

			actGroup.setVisibility(View.VISIBLE);
			act1.setVisibility(View.VISIBLE);

		} else if (progressValue == 2) {

			act1.setVisibility(View.VISIBLE);
			act2.setVisibility(View.VISIBLE);

		}

	}

	@Override
	public void onClick(View v) {

		if (v.getId() == R.id.act1) {

			actDetails.setText("Aquired Knowledge");

			if (InfoValue1 == true) {
				actDetails.append("\n" + "\n" + getString(R.string.InfoValue1));
			} else {
				act1Progress = act1Progress - 5;
			}

			if (InfoValue2 == true) {

				actDetails.append("\n" + "\n" + getString(R.string.InfoValue2));
			} else {
				act1Progress = act1Progress - 5;
			}

			if (InfoValue4 == true) {
				actDetails.append("\n" + "\n" + getString(R.string.InfoValue4));
			} else {
				act1Progress = act1Progress - 5;
			}

			if (InfoValue5 == true) {
				actDetails.append("\n" + "\n" + getString(R.string.InfoValue5));
			} else {
				act1Progress = act1Progress - 5;
			}

			if (InfoValue6 == true) {
				actDetails.append("\n" + "\n" + getString(R.string.InfoValue6));
			} else {
				act1Progress = act1Progress - 5;
			}

			if (InfoValue7 == true) {
				actDetails.append("\n" + "\n" + getString(R.string.InfoValue7));
			} else {
				act1Progress = act1Progress - 5;
			}

			if (InfoValue8 == true) {
				actDetails.append("\n" + "\n" + getString(R.string.InfoValue8));
			} else {
				act1Progress = act1Progress - 5;
			}

			if (InfoValue9 == true) {
				actDetails.append("\n" + "\n" + getString(R.string.InfoValue9));
			} else {
				act1Progress = act1Progress - 5;
			}

			if (InfoValue10 == true) {
				actDetails.append("\n" + "\n" + getString(R.string.InfoValue10));
			} else {
				act1Progress = act1Progress - 5;
			}

			actStats.setText("Percentage Complete: " + act1Progress + "\n"
					+ "Health: " + act1Health + "\n" + "Kills: " + act1Kills + "\n"
					+ "Lasting Damage: " + act1Damage);

		} else if (v.getId() == R.id.act2) {

		} else if (v.getId() == R.id.act3) {

		} else if (v.getId() == R.id.act4) {

		} else if (v.getId() == R.id.act5) {

		} else if (v.getId() == R.id.act6) {

		}

	}
}
