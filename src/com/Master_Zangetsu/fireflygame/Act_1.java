package com.Master_Zangetsu.fireflygame;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Random;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Act_1 extends Activity implements OnClickListener {

	TextView content;
	TextView health;
	TextView progress;

	ImageView damage;

	Button Option1;
	Button Option2;
	Button Option3;

	int healthValue;
	int damageValue;
	int actProgressValue;
	int killsValue;
	int progressCompleteValue = 40;

	int difficultyLevel;

	String nameValue;

	String Input = "Initialising ...";

	Calendar rightNow = Calendar.getInstance();
	int Month;
	int Day;
	int Year;

	int Hour;
	int Minute;
	int Second;

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

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act1);

		content = (TextView) findViewById(R.id.content);
		health = (TextView) findViewById(R.id.health);
		progress = (TextView) findViewById(R.id.progress);

		damage = (ImageView) findViewById(R.id.damage);

		content.setMovementMethod(new ScrollingMovementMethod());

		Option1 = (android.widget.Button) findViewById(R.id.button1);
		Option2 = (android.widget.Button) findViewById(R.id.button2);
		Option3 = (android.widget.Button) findViewById(R.id.button3);

		Option1.setOnClickListener((android.view.View.OnClickListener) this);
		Option2.setOnClickListener((android.view.View.OnClickListener) this);
		Option3.setOnClickListener((android.view.View.OnClickListener) this);

		actProgressValue = 0;
		damageValue = 0;
		healthValue = 100;
		killsValue = 0;

		savePrefs("ACT_1_PLAYER_DAMAGE", damageValue);
		savePrefs("ACT_1_PLAYER_HEALTH", healthValue);
		savePrefs("ACT_1_PROGRESS", actProgressValue);
		savePrefs("ACT_1_PLAYER_KILLS", killsValue);

		savePrefs("INFO_VALUE_1", false);
		savePrefs("INFO_VALUE_2", false);
		savePrefs("INFO_VALUE_3", false);
		savePrefs("INFO_VALUE_4", false);
		savePrefs("INFO_VALUE_5", false);
		savePrefs("INFO_VALUE_6", false);
		savePrefs("INFO_VALUE_7", false);
		savePrefs("INFO_VALUE_8", false);
		savePrefs("INFO_VALUE_9", false);
		savePrefs("INFO_VALUE_10", false);

		loadPrefs();

		Option2.setText("Start");

		Option1.setVisibility(View.INVISIBLE);
		Option2.setVisibility(View.VISIBLE);
		Option3.setVisibility(View.INVISIBLE);

		Typeface CmdPrompt = Typeface.createFromAsset(getAssets(),
				"fonts/windows_command_prompt.ttf");

		content.setTypeface(CmdPrompt);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_beginings, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.menu_restart:
			Restart_level();
			return true;
		case R.id.menu_bug:
			Report_bug();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void Report_bug() {

		startActivity(new Intent(this, Report.class));

	}

	private void Restart_level() {

		actProgressValue = 0;
		damageValue = 0;
		healthValue = 100;
		killsValue = 0;

		savePrefs("ACT_1_PLAYER_DAMAGE", damageValue);
		savePrefs("ACT_1_PLAYER_HEALTH", healthValue);
		savePrefs("ACT_1_PROGRESS", actProgressValue);
		savePrefs("ACT_1_PLAYER_KILLS", killsValue);

		savePrefs("PLAYER_HEALTH", healthValue);
		savePrefs("ACT_PROGRESS", actProgressValue);
		savePrefs("PLAYER_KILLS", killsValue);
		savePrefs("INFO_VALUE_1", false);
		savePrefs("INFO_VALUE_2", false);
		savePrefs("INFO_VALUE_3", false);
		savePrefs("INFO_VALUE_4", false);
		savePrefs("INFO_VALUE_5", false);
		savePrefs("INFO_VALUE_6", false);
		savePrefs("INFO_VALUE_7", false);
		savePrefs("INFO_VALUE_8", false);
		savePrefs("INFO_VALUE_9", false);
		savePrefs("INFO_VALUE_10", false);

		content.setText("Initialising ...");
		health.setText("Health: " + healthValue);

		Option2.setText("Start");

		Option1.setVisibility(View.INVISIBLE);
		Option2.setVisibility(View.VISIBLE);
		Option3.setVisibility(View.INVISIBLE);

	}

	private void loadPrefs() {

		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);

		damageValue = sp.getInt("ACT_1_PLAYER_DAMAGE", 0);
		healthValue = sp.getInt("ACT_1_PLAYER_HEALTH", 100);
		nameValue = sp.getString("MONSTER_NAME", "Unknown");
		actProgressValue = sp.getInt("ACT_1_PROGRESS", 0);
		killsValue = sp.getInt("ACT_1_PLAYER_KILLS", 0);
		difficultyLevel = sp.getInt("ACT_DIFFICULTY", 2);

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

		Calendar rightNow = Calendar.getInstance();
		Month = rightNow.get(Calendar.MONTH);
		Day = rightNow.get(Calendar.DAY_OF_MONTH);
		Year = rightNow.get(Calendar.YEAR);

		Hour = rightNow.get(Calendar.HOUR);
		Minute = rightNow.get(Calendar.MINUTE);
		Second = rightNow.get(Calendar.SECOND);

		String timeAndDate = ("\n" + Day + "/" + Month + "/" + Year + "  "
				+ Hour + ":" + Minute + ":" + Second + "\n");

		content.append(timeAndDate + Input + "\n");
		// content.append("\n" + Day + "/" + Month + "/" + Year + "  " + Hour +
		// ":" + Minute + ":" + Second + "\n" + "\n");

		health.setText("Health: " + healthValue);
		Double percentage = ((double) actProgressValue / progressCompleteValue) * 100;
		progress.setText(new DecimalFormat("##.##").format(percentage) + "%");

	}

	private void updateContent() {

		if (actProgressValue == 1) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Input = "Eugh! ... Whether it was a blisful dream or a stinking nightmare you gain the overwhelming feeling that it has to have been better than what you feel now.";
			Option1.setText("");
			Option2.setText("Cont.");
			Option3.setText("");

		} else if (actProgressValue == 2) {

			Option1.setVisibility(View.VISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Input = "You find yourself lying on a stone cold floor, a closed blind blocks much of whatever light attempts to creep through the window behind you. You have a headache";
			Option1.setText("Open Blind");
			Option2.setText("Nurse Headache");
			Option3.setText("");
		} else if (actProgressValue == 3) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Input = "Attempting to get up was not a good idea ... eagerly reaching for the drawstring on the blind your head spins and decides to discover if your dream really was better than your current prediciment. You hit your head as you fall";
			Option1.setText("");
			Option2.setText("Cont.");
			Option3.setText("");

			healthValue = healthValue - 10;
			Toast.makeText(getApplicationContext(),
					"Remaining Health: " + healthValue, Toast.LENGTH_SHORT)
					.show();
		} else if (actProgressValue == 4) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Input = "Egh not bad as dreams go";
			Option1.setText("");
			Option2.setText("Wake up");
			Option3.setText("");
		} else if (actProgressValue == 5) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Input = "Slowly sitting up you try and clear your head, as you gather your whitts you feel like you could manage to get up now";
			Option1.setText("");
			Option2.setText("Get up");
			Option3.setText("");
		} else if (actProgressValue == 6) {

			Option1.setVisibility(View.VISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.VISIBLE);

			Input = "Whilst its still hard to see with so little [[light]] you can make out your surroundings. The stone floor is the mid section of a staircase leaving you the choice of [[Up]] or [[Down]]";
			Option1.setText("Open blind");
			Option2.setText("Go up");
			Option3.setText("Go down");
		} else if (actProgressValue == 7) {

			Option1.setVisibility(View.VISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Input = "Let there be light! Opening the blind reveals one hell of a mess, whilst the buildings are still in tact the people they are designed for are not. Spread across the floor off into the distance you can make out flesh covered piles each one a lack of life. Turning from the scene you are once again confronted by the stairs leading [[Up]] and [[Down]]";
			Option1.setText("Go up");
			Option2.setText("Go down");
			Option3.setText("");

			savePrefs("INFO_VALUE_1", true);
			// (Knowledge Gain: I See Dead People)
			Toast.makeText(getApplicationContext(),
					"Knowledge Gain: I See Dead People", Toast.LENGTH_SHORT)
					.show();
		} else if (actProgressValue == 8) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Option1.setText("");
			Option2.setText("Enter the room");
			Option3.setText("");

			// (Knowledge Use: I See Dead People)
			if (InfoValue1 == true) {
				Input = "Moving up the stairs brings you to a large room. By the look of the broken equipment on the desks it must have been a lab. You instincually hold your breath thinking to avoid a chemical fume spill before kicking yourself. By the looks of the equipment its been broken a good few hours, if it was a chemical spill that killed those people any harmful chemicals would have dissapated by now.";
			} else {
				Input = "Moving up the stairs brings you to a large room. By the look of the broken equipment on the desks it must have been a lab.";
			}
		} else if (actProgressValue == 9) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Input = "Inspecting the wrekage you notice that all of the computers are powered down, not what you would expect from room that looks like the people left in a hurry. You boot one up only to find its password protected. Continuing to the otherside of the room you find a single [[exiting door]]";
			Option1.setText("");
			Option2.setText("Try exit");
			Option3.setText("");

			savePrefs("INFO_VALUE_2", true);
			// (Knowledge Gain: Mystery in the Lab)
			Toast.makeText(getApplicationContext(),
					"Knowledge Gain: Mystery in the Lab", Toast.LENGTH_SHORT)
					.show();
		} else if (actProgressValue == 10) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Input = "The door doesn't appear to be locked as it is slightly ajar when you walk up to it. When you try and open it further however it is blocked by something on the other side ... a couple of shoulder barges inches it open a little further but not enough to creep through. You resign yourself to travel back to the stairs and try the other route [[Down]] the stairs.";
			Option1.setText("");
			Option2.setText("Go down stairs");
			Option3.setText("");
		} else if (actProgressValue == 11) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Input = "At the bottom of the stairs there is a corridor, a silent red emergency light spins at the far end above a [[doorway]]";
			Option1.setText("");
			Option2.setText("Approach the doorway");
			Option3.setText("");
		} else if (actProgressValue == 12) {

			Option1.setVisibility(View.VISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.VISIBLE);

			Input = "Inside looks like a storage area, various boxes are piled up making it hard to see how big the room really is. From where you are standing you also cannot see any obvious exits to the room, however it is possible one is being blocked by the crates. Do you [[rush through]] to find an exit quickly, [[Search]] the boxes for anything usefull or [[carefully navigate]] to find an exit.";
			Option1.setText("Rush through");
			Option2.setText("Search the boxes");
			Option3.setText("Navigate");
		} else if (actProgressValue == 13) {

			Option1.setVisibility(View.VISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.VISIBLE);

			Input = "Your searching reveals two exits to the room one closer and one further away hidden behind a rather large stack of boxes";
			Option1.setText("Search the boxes");
			Option2.setText("Take exit one");
			Option3.setText("Take exit two");

			savePrefs("INFO_VALUE_3", true);
			// (Knowledge Gain: The Other Exit)
			Toast.makeText(getApplicationContext(),
					"Knowledge Gain: The Other Exit", Toast.LENGTH_SHORT)
					.show();
		} else if (actProgressValue == 14) {

			Option1.setVisibility(View.VISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.VISIBLE);

			Input = "Searching around and in the boxes you find a table with an abandoned game of cards laid out, left as if the players meant to return. In addition, left on the table is a sandwhich and glass of water ... checking that both seem safe you consume both. you hear footsteps coming towards you, looking around you see a shadow appear from an exit now visible to you";
			Option1.setText("Hide");
			Option2.setText("Ambush");
			Option3.setText("Stand your ground");
			healthValue = healthValue + 10;
			damageValue = damageValue - 1;

			Toast.makeText(getApplicationContext(),
					"Remaining Health: " + healthValue, Toast.LENGTH_SHORT)
					.show();
		} else if (actProgressValue == 15) {

			Option1.setVisibility(View.VISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.VISIBLE);

			Input = "In your eagerness to find an exit you knock into one of the larger piles bringing it cascading down. Fortunatly you are not hurt managing to dodge out of the way quick enough, however you do hear gaited footsteps approaching fast.";
			Option1.setText("Hide");
			Option2.setText("Ambush");
			Option3.setText("Stand your ground");
		} else if (actProgressValue == 16) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Random random = new Random();
			int attackers = (random.nextInt(5) + difficultyLevel);

			Input = "You find a suitible hiding place just in time to see "
					+ attackers
					+ " crouched figures in red enter the room, communicating in grunts they do a quick search before moving off down the passage you came from.";
			Option1.setText("");
			Option2.setText("Go the way they came");
			Option3.setText("");

			if (InfoValue3 == true) {
				Option3.setVisibility(View.VISIBLE);
				Option3.setText("Take the other exit");
			}
		} else if (actProgressValue == 17) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Random random = new Random();
			int attackers = (random.nextInt(5) + difficultyLevel);

			healthValue = healthValue - (30 * attackers);
			killsValue = killsValue + attackers;
			damageValue = damageValue + attackers;

			Toast.makeText(getApplicationContext(),
					"Remaining Health: " + healthValue, Toast.LENGTH_SHORT)
					.show();

			Input = "Preparing to meet whatever comes through the door friend or foe head on you stand your ground in plain sight. The climax of the footsteps reveals "
					+ attackers
					+ " figures in red that instantly charge you. Fighting as best you can you sustain significant injury, including one from a fellow who bit you.";
			Option1.setText("");
			Option2.setText("Go the way they came");
			Option3.setText("");

			if (InfoValue3 == true) {
				Option3.setVisibility(View.VISIBLE);
				Option3.setText("Take the other exit");
			}

			savePrefs("INFO_VALUE_4", true);
			// (Knowledge Gain: Did he just bite me?)
			Toast.makeText(getApplicationContext(),
					"Knowledge Gain: Did he just bite me?", Toast.LENGTH_SHORT)
					.show();
		} else if (actProgressValue == 18) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Random random = new Random();
			int attackers = (random.nextInt(5) + difficultyLevel);

			if (attackers <= 2) {
				killsValue = killsValue + attackers;
				damageValue = damageValue + attackers;
				Input = "Finding a hidden position you lie in wait, ready to strike. The climax of the footsteps reveals "
						+ attackers
						+ " figures in red emerge into the room and start searching. Jumping out you are thankful that so few came and you win the confrontation with minor injury, including one from a fellow who bit you.";
			} else {
				healthValue = healthValue - (30 * (attackers - 2));
				killsValue = killsValue + attackers;
				damageValue = damageValue + attackers;
				Input = "Finding a hidden position you lie in wait, ready to strike. The climax of the footsteps reveals "
						+ attackers
						+ " figures in red emerge into the room and start searching. Jumping out you take out two before any others realise. Despite the advantage of surprise you sustain significant injury, including one from a fellow who bit you.";
			}

			Toast.makeText(getApplicationContext(),
					"Remaining Health: " + healthValue, Toast.LENGTH_SHORT)
					.show();

			Option1.setText("");
			Option2.setText("Go way they came");
			Option3.setText("");

			if (InfoValue3 == true) {
				Option3.setVisibility(View.VISIBLE);
				Option3.setText("Take the other exit");
			}

			savePrefs("INFO_VALUE_4", true);
			// (Knowledge Gain: Did he just bite me?)
			Toast.makeText(getApplicationContext(),
					"Knowledge Gain: Did he just bite me?", Toast.LENGTH_SHORT)
					.show();
		} else if (actProgressValue == 19) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			healthValue = healthValue + 30;

			Toast.makeText(getApplicationContext(),
					"Remaining Health: " + healthValue, Toast.LENGTH_SHORT)
					.show();

			if (InfoValue4 == true) {
				Input = "Inspecting your wounds you confirm that during the fray one of them did indeed bite you although not very deep. And now that you think about it they all looked rather hungry? no .. that didnt quite cover it. You settle on Lustful for food and shudder at the thought. In the room you find yet another storage room, this one the boxes have clear alliance markings on them. A quick search finds most to be empty, however on a self you find the reminants of a food stuff bar. Again with an alliance stamp on the front you quickly eat the remainder of it which turns out to be no more than a mouthfull. It is more than enough to fill you up as the bars themselves are full of proteins, vitamins and immunization supplements. One full bar is enough to feed a family for a month. You also find a short air vent just wide enough to crawl through.";
				Option1.setText("");
				Option2.setText("Crawl through vent");
				Option3.setText("");
			} else {
				Input = "In the room you find yet another storage room, this one the boxes have odd markings on them. A quick search finds most to be empty, however on a shelf you find the reminants of a food stuff bar. Again with the odd stamp on the front you pause, sure you should remember what the marking means. Shrugging you quickly eat the remainder of it which turns out to be no more than a mouthfull. It is more than enough to fill you up as the bars themselves seem full of proteins, vitamins and immunization supplements. One full bar is probably enough to feed a family for a month. You also find a small air vent just wide enough to crawl through.";
				Option1.setText("");
				Option2.setText("Crawl through vent");
				Option3.setText("");
			}
			damageValue = damageValue - 1;
		} else if (actProgressValue == 20) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Input = "Keen to remove yourself from that room in case more appear, you move on quickly. As you go, you attempt to tie up your wounds the best you can ambling off down the passageway that your attackers came from and find a small alcove. Ducking inside you wait to catch your breath. ";
			Option1.setText("");
			Option2.setText("The alcove");
			Option3.setText("");
		} else if (actProgressValue == 21) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Random random = new Random();
			int attackers = (random.nextInt(5) + difficultyLevel);

			Input = "Halfway down the exit you hear footsteps and are lucky enough to find an alcove to hide in. "
					+ attackers
					+ " crouched guys in red go past but dont see you";
			Option1.setText("");
			Option2.setText("The alcove");
			Option3.setText("");
		} else if (actProgressValue == 22) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			if (InfoValue4 == true) {
				Input = "After inspecting your wounds you confirm that during the fray one of them did indeed bite you although not very deep. And now that you think about it they all looked rather hungry? no .. that didnt quite cover it. You settle on Lustful for food and shudder at the thought. After a wait you are sure that the danger has passed and feel safe enough to move on.";
				Option1.setText("");
				Option2.setText("Cont.");
				Option3.setText("");
			} else {
				Input = "After a wait you are sure that the danger has passed and feel safe enough to move on.";
				Option1.setText("");
				Option2.setText("Cont.");
				Option3.setText("");
			}
		} else if (actProgressValue == 23) {

			Option1.setVisibility(View.VISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.VISIBLE);

			Input = "After carefully traversing a corridor you come to flight of stairs leading up ... aware of the narrow and darkened doorway you approach. Stroll through, Dash through to take anything on the other side by surprise or Creep through to go unnoticed";
			Option1.setText("Dash");
			Option2.setText("Creep");
			Option3.setText("Stroll");
		} else if (actProgressValue == 24) {

			Option1.setVisibility(View.VISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Input = "Luckily nothing awaits you on the other side but a long corridor, nothing alive at least. Midway down you see a door on the left slightly open and in front of it lays a body.";
			Option1.setText("Inspect");
			Option2.setText("Avoid");
			Option3.setText("");
		} else if (actProgressValue == 25) {

			Option1.setVisibility(View.VISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Input = "Bending down you expect to find a wound or similar possibly caused by those men in red, but you find nothing of the sort. What you do find is a middle aged man laying peacefully on the ground as if he was simply going to sleep. In fact the only distress to the body you can find is to his right arm where the skin is caught under the door, someone obviously tried to force it open with this guy on the other side. Checking his pockets you also find an ID badge and a peice of paper with the word 'Pa$$w0rd' scrawled on it.";
			Option1.setText("Enter The Room");
			Option2.setText("Continue On");
			Option3.setText("");
			Toast.makeText(getApplicationContext(),
					"Knowledge Gain: The Password", Toast.LENGTH_SHORT).show();
			savePrefs("INFO_VALUE_5", true);
		} else if (actProgressValue == 26) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Input = "Wanting nothing to do with more death you carry on covering your mouth with your sleeve to try and mitigate any infection you might catch from him.";
			Option1.setText("");
			Option2.setText("Continue On");
			Option3.setText("");
		} else if (actProgressValue == 27) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Input = "Moving the not inconsequential weight of the man you realise how tired you are and make a mental note to find somewhere safe to rest for the night soon. Nevertheless you are able to shove him out of the way of the door and enter the room beyond.";
			Option1.setText("");
			Option2.setText("Continue On");
			Option3.setText("");
		} else if (actProgressValue == 28) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			if (InfoValue2 == true) {
				Input = "Its the same lab from before! you suddenly feel sorry that it was probably your shoving of the door that forced the mans arm so far under it. On closer inspection however you realise that something is different, before it was only the beakers and burners that were smashed, now its the computers too, clearly someone didnt want them accessed. Having already searched the room you dont particularly fancy returning to the stairs where you awoke and so return to the corridor.";
				Option1.setText("");
				Option2.setText("Continue On");
				Option3.setText("");

				Toast.makeText(getApplicationContext(),
						"Knowledge Gain: The Plot Thickens", Toast.LENGTH_SHORT)
						.show();
				savePrefs("INFO_VALUE_6", true);
			} else {
				Input = "Its a lab, fairly banged up one though, by the look of the mess whoever left did so in a hurry perhaps they were chased out by those men in red. A quick look down the staircase on the otherside reveals it to be the one where you awoke, you turn around and continue down the corridor.";
				Option1.setText("");
				Option2.setText("Continue On");
				Option3.setText("");

				Toast.makeText(getApplicationContext(),
						"Knowledge Gain: False Information", Toast.LENGTH_SHORT)
						.show();
				savePrefs("INFO_VALUE_7", true);
			}
		} else if (actProgressValue == 29) {

			Option1.setVisibility(View.VISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.VISIBLE);

			Random random = new Random();
			int attackers = (random.nextInt(5) + difficultyLevel);

			if (InfoValue4 == true) {
				Input = "Moving off down the corridor you enter into a circular room, to your left a window warns you of the quickly failing light whilst in front of you is an elevator and a set of stairs.";
				Option1.setText("Window");
				Option2.setText("Stairs");
				Option3.setText("Elevator");

			} else {
				Input = "From the door behind you bursts "
						+ attackers
						+ " foes, taking you completely by surprise. They are almost on top of you when you manage to spin around there is little you can do to defend and are forced to fight as best you can only just making it. Exhausted you know you must push on and stumble into a circular room. At the end exists an elevator and a set of stairs with a window adding more worries to your long list ... through it you can see the sun starting to set.";
				Option1.setText("Window");
				Option2.setText("Stairs");
				Option3.setText("Elevator");

				healthValue = healthValue - (30 * attackers);
				killsValue = killsValue + attackers;
				damageValue = damageValue + attackers;

				Toast.makeText(getApplicationContext(),
						"Knowledge Gain: Did he just bite me?",
						Toast.LENGTH_SHORT).show();
				savePrefs("INFO_VALUE_4", true);

				Toast.makeText(getApplicationContext(),
						"Remaining Health: " + healthValue, Toast.LENGTH_SHORT)
						.show();
			}
		} else if (actProgressValue == 30) {

			Option1.setVisibility(View.VISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			if (InfoValue1 == true && InfoValue5 == true) {
				Input = "Hoping to learn sometihng more posative than the impending night you amble closer to the window. Again the same scattered dead from before, and you realise that many of them look as the sleeping man did, no blood, just as if they layed down and died. From here you can also see over the hill, this draws another group into view neither dead nor ... whatever those men dressed in red were ... seemingly in formation all you can make out from this distance is a bright shade of purple on their mid section. You feel this should mean something to you, but you cant remember.";
				Option1.setText("Stairs");
				Option2.setText("Elevator");
				Option3.setText("");

				savePrefs("INFO_VALUE_8", true);
				Toast.makeText(getApplicationContext(),
						"Knowledge Gain: Purple Belly", Toast.LENGTH_SHORT)
						.show();
			} else if (InfoValue1 == false && InfoValue5 == true) {
				Input = "Hoping to learn sometihng more posative than the impending night you amble closer to the window. Looking out the window reveals one hell of a mess, whilst the buildings are still in tact the people they are designed for are not. Spread across the floor off into the distance you can make out flesh covered piles each one a lack of life. As you look you realise that many of them look as the sleeping man did, no blood, just as if they layed down and died";
				Option1.setText("Stairs");
				Option2.setText("Elevator");
				Option3.setText("");

				savePrefs("INFO_VALUE_1", true);
				Toast.makeText(getApplicationContext(),
						"Knowledge Gain: I see dead people", Toast.LENGTH_SHORT)
						.show();
			} else if (InfoValue1 == true && InfoValue5 == false) {
				Input = "Hoping to learn sometihng more posative than the impending night you amble closer to the window. You see again the same scattered dead from before, but from here you can also see over the hill, this draws another group into view neither dead nor ... whatever those men dressed in red were ... seemingly in formation all you can make out from this distance is a bright shade of purple on their mid section. You feel this should mean something to you, but you cant remember.";
				Option1.setText("Stairs");
				Option2.setText("Elevator");
				Option3.setText("");
			} else {
				Input = "Hoping to learn sometihng more posative than the impending night you amble closer to the window. Looking out the window reveals one hell of a mess, whilst the buildings are still in tact the people they are designed for are not. Spread across the floor off into the distance you can make out flesh covered piles each one a lack of life.";
				Option1.setText("Stairs");
				Option2.setText("Elevator");
				Option3.setText("");

				savePrefs("INFO_VALUE_1", true);
				Toast.makeText(getApplicationContext(),
						"Knowledge Gain: I see dead people", Toast.LENGTH_SHORT)
						.show();
			}
		}

		// Toast.makeText(getApplicationContext(), "" + actProgressValue,
		// Toast.LENGTH_SHORT).show();

		healthValue = healthValue - damageValue;

		savePrefs("ACT_1_PLAYER_DAMAGE", damageValue);
		savePrefs("ACT_1_PLAYER_HEALTH", healthValue);
		savePrefs("ACT_1_PROGRESS", actProgressValue);
		savePrefs("ACT_1_PLAYER_KILLS", killsValue);
		loadPrefs();
	}

	private void savePrefs(String key, boolean value) {

		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		Editor edit = sp.edit();
		edit.putBoolean(key, value);
		edit.commit();

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

		 if (healthValue <= 0) {

				switch (v.getId()) {
				case R.id.button1:
					break;
				case R.id.button2:
					
					savePrefs("PLAYER_HEALTH", 0);
					savePrefs("PLAYER_KILLS", 0);
					savePrefs("PLAYER_DAMAGE", 0);
					
					savePrefs("PLAYER_NAME", null);
					savePrefs("PLAYER_STRENGTH", 0);
					savePrefs("PLAYER_TOUGHNESS", 0);
					savePrefs("PLAYER_SPEED", 0);
					savePrefs("PLAYER_INTELLIGENCE", 0);
					savePrefs("PLAYER_UPGRADES", 0);
					
					Intent intent = new Intent(v.getContext(), Beginings.class);
					  startActivityForResult(intent, 0);
					
					break;
				case R.id.button3:
					break;
				}
				//updateContent();

			} else if (actProgressValue == 0) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 1) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 2) {

			switch (v.getId()) {
			case R.id.button1:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 3;

				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 3) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 4) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue - 3;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 5) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 6) {

			switch (v.getId()) {
			case R.id.button1:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 2;
				break;
			case R.id.button3:
				actProgressValue = actProgressValue + 5;
				break;
			}
			updateContent();

		} else if (actProgressValue == 7) {

			switch (v.getId()) {
			case R.id.button1:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 4;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 8) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 9) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 10) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 11) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 12) {

			switch (v.getId()) {
			case R.id.button1:
				actProgressValue = actProgressValue + 3;
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 2;
				break;
			case R.id.button3:
				actProgressValue = actProgressValue + 1;
				break;
			}
			updateContent();

		} else if (actProgressValue == 13) {

			switch (v.getId()) {
			case R.id.button1:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 8;
				break;
			case R.id.button3:
				actProgressValue = actProgressValue + 6;
				break;
			}
			updateContent();

		} else if (actProgressValue == 14) {

			switch (v.getId()) {
			case R.id.button1:
				actProgressValue = actProgressValue + 2;
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 4;
				break;
			case R.id.button3:
				actProgressValue = actProgressValue + 3;
				break;
			}
			updateContent();

		} else if (actProgressValue == 15) {

			switch (v.getId()) {
			case R.id.button1:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 3;
				break;
			case R.id.button3:
				actProgressValue = actProgressValue + 2;
				break;
			}
			updateContent();

		} else if (actProgressValue == 16) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 4;
				break;
			case R.id.button3:
				actProgressValue = actProgressValue + 3;
				break;
			}
			updateContent();

		} else if (actProgressValue == 17) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 3;
				break;
			case R.id.button3:
				actProgressValue = actProgressValue + 2;
				break;
			}
			updateContent();

		} else if (actProgressValue == 18) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 2;
				break;
			case R.id.button3:
				actProgressValue = actProgressValue + 1;
				break;
			}
			updateContent();

		} else if (actProgressValue == 19) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 4;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 20) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 2;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 21) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 22) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 23) {

			switch (v.getId()) {
			case R.id.button1:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button3:
				actProgressValue = actProgressValue + 1;
				break;
			}
			updateContent();

		} else if (actProgressValue == 24) {

			switch (v.getId()) {
			case R.id.button1:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 2;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 25) {

			switch (v.getId()) {
			case R.id.button1:
				actProgressValue = actProgressValue + 2;
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 4;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 26) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 3;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 27) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 28) {

			switch (v.getId()) {
			case R.id.button1:
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		} else if (actProgressValue == 29) {

			switch (v.getId()) {
			case R.id.button1:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 3;
				break;
			case R.id.button3:
				actProgressValue = actProgressValue + 2;
				break;
			}
			updateContent();

		} else if (actProgressValue == 30) {

			switch (v.getId()) {
			case R.id.button1:
				actProgressValue = actProgressValue + 2;
				break;
			case R.id.button2:
				actProgressValue = actProgressValue + 1;
				break;
			case R.id.button3:
				break;
			}
			updateContent();

		}
		

		if (healthValue <= 0) {

			Option1.setVisibility(View.INVISIBLE);
			Option2.setVisibility(View.VISIBLE);
			Option3.setVisibility(View.INVISIBLE);

			Input = "Your injuries prove too severe to continue on, becoming very sleepy you sit down propping yourself up against the wall. Vowing to find treatment for your injuries in the morning the pain slips away as you drift off." + "\n" + "\n" + "You have Died";
			Option1.setText("");
			Option2.setText("Main Menu");
			Option3.setText("");
			
			savePrefs("ACT_1_PLAYER_DAMAGE", damageValue);
			savePrefs("ACT_1_PLAYER_HEALTH", healthValue);
			savePrefs("ACT_1_PROGRESS", actProgressValue);
			savePrefs("ACT_1_PLAYER_KILLS", killsValue);
			loadPrefs();
			//actProgressValue = 0;

			Toast.makeText(getApplicationContext(), "You have died!",

			Toast.LENGTH_LONG).show();
		} else if (v.getId() == R.id.button3) {

		}
		

		if (damageValue == 0) {
			damage.setImageResource(R.drawable.damage0);
		} else if (damageValue == 1) {
			damage.setImageResource(R.drawable.damage1);
		} else if (damageValue == 2) {
			damage.setImageResource(R.drawable.damage2);
		} else if (damageValue == 3) {
			damage.setImageResource(R.drawable.damage3);
		} else if (damageValue == 4) {
			damage.setImageResource(R.drawable.damage4);
		} else if (damageValue == 5) {
			damage.setImageResource(R.drawable.damage5);
		} else if (damageValue == 6) {
			damage.setImageResource(R.drawable.damage6);
		}
	}
}