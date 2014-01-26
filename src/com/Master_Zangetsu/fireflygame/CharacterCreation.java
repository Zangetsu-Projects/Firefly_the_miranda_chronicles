package com.Master_Zangetsu.fireflygame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CharacterCreation extends Activity implements OnClickListener{
	
	String charName;
	
	int charStrength;
	int charToughness;
	int charSpeed;
	int charInteligence;
	
	int charDamageValue;
	int charHealthValue;
	
	int charUpgrades;
	
	TextView health;
	TextView damage;
	TextView knowlege;
	
	EditText nameInput;
	
	EditText nameView;
	EditText strengthView;
	EditText defenceView;
	EditText speedView;
	EditText intelligenceView;
	EditText upgradesView;
	
	Button generateStats;
	Button Save;
	
	Button increaseStrength;
	Button increaseDefence;
	Button increaseSpeed;
	Button increaseIntelligence;
	
	LinearLayout playerSpecifics;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.character_sheet);
		
		nameInput = (EditText) findViewById(R.id.editName);
		
		nameView = (EditText) findViewById(R.id.nameField);
		strengthView = (EditText) findViewById(R.id.strengthField);
		defenceView = (EditText) findViewById(R.id.defenceField);
		speedView = (EditText) findViewById(R.id.speedField);
		intelligenceView = (EditText) findViewById(R.id.intelligenceField);
		upgradesView = (EditText) findViewById(R.id.upgradesField);
		
		generateStats = (Button) findViewById(R.id.statsBtn);
		Save = (Button) findViewById(R.id.saveBtn);
		
		increaseStrength = (Button) findViewById(R.id.strengthBtn);
		increaseDefence = (Button) findViewById(R.id.defenceBtn);
		increaseSpeed = (Button) findViewById(R.id.speedBtn);
		increaseIntelligence = (Button) findViewById(R.id.intelligenceBtn);
		
		playerSpecifics = (LinearLayout) findViewById(R.id.playerSpecifics);
		
		health = (TextView) findViewById(R.id.health);
		damage = (TextView) findViewById(R.id.damage);
		knowlege = (TextView) findViewById(R.id.knowledge);
		
		generateStats.setOnClickListener((android.view.View.OnClickListener) this);
		Save.setOnClickListener((android.view.View.OnClickListener) this);
		
		increaseStrength.setOnClickListener((android.view.View.OnClickListener) this);
		increaseDefence.setOnClickListener((android.view.View.OnClickListener) this);
		increaseSpeed.setOnClickListener((android.view.View.OnClickListener) this);
		increaseIntelligence.setOnClickListener((android.view.View.OnClickListener) this);
		
		loadPrefs();
		
		nameInput.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable v) {
				
				nameView.setText(nameInput.getText());
				charName = nameInput.getText().toString();
				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
	}
	
	private void loadPrefs() {

		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		
		charName = sp.getString("PLAYER_NAME", "");
		
		charDamageValue = sp.getInt("PLAYER_DAMAGE", 0);
		charHealthValue = sp.getInt("PLAYER_HEALTH", 100);
		
		charStrength = sp.getInt("PLAYER_STRENGTH", 0);
		charToughness = sp.getInt("PLAYER_TOUGHNESS", 0);
		charSpeed = sp.getInt("PLAYER_SPEED", 0);
		charInteligence = sp.getInt("PLAYER_INTELLIGENCE", 0);

		charUpgrades = sp.getInt("PLAYER_UPGRADES", 0);
		
		if (charName != "" && charHealthValue >= 1){
			nameInput.setVisibility(View.GONE);
			generateStats.setVisibility(View.GONE);
			
			playerSpecifics.setVisibility(View.VISIBLE);
			
			Save.setText("Continue");
			
			health.setText("Health: " + charHealthValue);
			damage.setText("Damage: " + charDamageValue);
			knowlege.setText("");
			
		} else {
			
			nameInput.setVisibility(View.VISIBLE);
			generateStats.setVisibility(View.VISIBLE);
			
			playerSpecifics.setVisibility(View.GONE);
			
			Save.setText("Save");
			
			savePrefs("PLAYER_HEALTH", 100);
			savePrefs("PLAYER_KILLS", 0);
			savePrefs("PLAYER_DAMAGE", 0);
		}
		
		
		
		nameView.setText(charName + "");
		strengthView.setText(charStrength + "");
		defenceView.setText(charToughness + "");
		speedView.setText(charSpeed + "");
		intelligenceView.setText(charInteligence + "");
		
		upgradesView.setText(charUpgrades + "");

	}
	
	private void savePrefs(String key, int value) {

		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		Editor edit = sp.edit();
		edit.putInt(key, value);
		edit.commit();

	}

	private void savePrefs(String key, String value) {

		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		Editor edit = sp.edit();
		edit.putString(key, value);
		edit.commit();

	}

	@Override
	public void onClick(View v) {
		
		if (v.getId() == R.id.statsBtn) {
			
			charStrength = (int) Math.ceil(Math.random() * 3) + 3;
			charToughness = (int) Math.ceil(Math.random() * 3) + 3;
			charSpeed = (int) Math.ceil(Math.random() * 3) + 3;
			charInteligence = (int) Math.ceil(Math.random() * 3) + 3;
			
			charUpgrades = 2;
			
			while ((charStrength + charToughness + charSpeed + charInteligence) > 13){
				
				charStrength --;
				charToughness --;
				charSpeed --;
				
			}
			
			strengthView.setText(charStrength + "");
			defenceView.setText(charToughness + "");
			speedView.setText(charSpeed + "");
			intelligenceView.setText(charInteligence + "");
			
			upgradesView.setText(charUpgrades + "");
			
			
			
		} else if (v.getId() == R.id.saveBtn) {
			
			if (charStrength == 0 || charToughness == 0 || charSpeed == 0 || charInteligence == 0 || charName == null){
				
				Toast.makeText(getApplicationContext(), "Please generate stats and provide character name", Toast.LENGTH_SHORT).show();
				
			} else {
				
				charName = nameView.getText().toString();
				
				savePrefs("PLAYER_NAME", charName);
				savePrefs("PLAYER_STRENGTH", charStrength);
				savePrefs("PLAYER_TOUGHNESS", charToughness);
				savePrefs("PLAYER_SPEED", charSpeed);
				savePrefs("PLAYER_INTELLIGENCE", charInteligence);
				savePrefs("PLAYER_UPGRADES", charUpgrades);

				 Intent intent = new Intent(v.getContext(), Levelselect.class);
				 startActivityForResult(intent, 0);
				
			}
			
		
		} else if (v.getId() == R.id.strengthBtn) {
			
			if (charUpgrades >= 1){
				
				charUpgrades --;
				charStrength ++;
				
				strengthView.setText(charStrength + "");
				upgradesView.setText(charUpgrades + "");
				
			} else {
				Toast.makeText(getApplicationContext(), "Not enough Upgrade Tokens left", Toast.LENGTH_SHORT).show();
			}
			
		} else if (v.getId() == R.id.defenceBtn) {
			
			if (charUpgrades >= 1){
				
				charUpgrades --;
				charToughness ++;
				
				defenceView.setText(charToughness + "");
				upgradesView.setText(charUpgrades + "");
				
			} else {
				Toast.makeText(getApplicationContext(), "Not enough Upgrade Tokens left", Toast.LENGTH_SHORT).show();
			}
			
		} else if (v.getId() == R.id.speedBtn) {
			
			if (charUpgrades >= 1){
				
				charUpgrades --;
				charSpeed ++;
				
				speedView.setText(charSpeed + "");
				upgradesView.setText(charUpgrades + "");
				
			} else {
				Toast.makeText(getApplicationContext(), "Not enough Upgrade Tokens left", Toast.LENGTH_SHORT).show();
			}
			
		} else if (v.getId() == R.id.intelligenceBtn) {
			
			if (charUpgrades >= 1){
				
				charUpgrades --;
				charInteligence ++;
				
				intelligenceView.setText(charInteligence + "");
				upgradesView.setText(charUpgrades + "");
				
			} else {
				Toast.makeText(getApplicationContext(), "Not enough Upgrade Tokens left", Toast.LENGTH_SHORT).show();
			} 
			
		}
		
		
		
	}

}
