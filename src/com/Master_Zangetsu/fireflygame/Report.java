package com.Master_Zangetsu.fireflygame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Report extends Activity implements OnClickListener {

	RadioGroup Type;
	RadioButton Spelling;
	RadioButton Game;
	RadioButton Other;

	Spinner Act;
	Spinner Progress;

	EditText Extra;

	Button Submit;

	String EMAIL = "Master.Zangetsu@googlemil.com";

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report_activity);

		Type = (RadioGroup) findViewById(R.id.bugtype);
		Spelling = (RadioButton) findViewById(R.id.spelling);
		Game = (RadioButton) findViewById(R.id.game);
		Other = (RadioButton) findViewById(R.id.other);

		Act = (Spinner) findViewById(R.id.actspinner);
		Progress = (Spinner) findViewById(R.id.progressspinner);

		Extra = (EditText) findViewById(R.id.extra);

		Submit = (Button) findViewById(R.id.submit);

		Spelling.setOnClickListener((android.view.View.OnClickListener) this);
		Game.setOnClickListener((android.view.View.OnClickListener) this);
		Other.setOnClickListener((android.view.View.OnClickListener) this);
		Submit.setOnClickListener((android.view.View.OnClickListener) this);

	}

	@Override
	public void onClick(View v) {

		if (v.getId() == R.id.submit) {

			Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

			String aEmailList[] = { EMAIL };

			String actValue = Act.getSelectedItem().toString();
			String progressValue = Progress.getSelectedItem().toString();
			String additional = Extra.getText().toString();

			emailIntent
					.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);

			String requestType;

			switch (Type.getCheckedRadioButtonId()) {
			case R.id.spelling:
				requestType = "Spelling Error";
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
						requestType);
				break;
			case R.id.game:
				requestType = "Game Play";
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
						requestType);
				break;
			case R.id.other:
				requestType = "Other";
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
						requestType);
				break;
			}

			emailIntent.setType("plain/text");
			emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Act: "
					+ actValue + "\n" + "Progress: " + progressValue + "\n"
					+ "Details: " + additional);
			startActivity(Intent.createChooser(emailIntent,
					"Send your email in:"));
		}
	}

}
