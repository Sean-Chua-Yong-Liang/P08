package sg.edu.rp.c346.id18015362.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    TextView tvName;
    TextView tvGPA;
    RadioGroup rgGender;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        tvName = findViewById(R.id.textViewName);
        tvGPA = findViewById(R.id.textViewGPA);
        rgGender = findViewById(R.id.radioGroupGender);
        btnSave = findViewById(R.id.buttonSave);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = etName.getText().toString();
                Float gpa = Float.parseFloat(etGPA.getText().toString());
                int rButton = rgGender.getCheckedRadioButtonId();

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

                SharedPreferences.Editor prefEdit = prefs.edit();

                prefEdit.putString("name", strName);
                prefEdit.putFloat("gpa", gpa);
                prefEdit.putInt("rButton", rButton);

                prefEdit.commit();
            }
        });
    }

    @Override
protected void onResume() {
    super.onResume();

    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    String msg = prefs.getString("name", "name not found");
    Float gpa = prefs.getFloat("gpa", 0.0f);
    int rButton = prefs.getInt("rButton", 0);

    tvName.setText(msg);

    String text = "GPA: " + gpa.toString();
    tvGPA.setText(text);

    rgGender.check(rButton);






}

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        Float gpa = Float.parseFloat(etGPA.getText().toString());
        int rButton = rgGender.getCheckedRadioButtonId();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);
        prefEdit.putInt("rButton", rButton);

        prefEdit.commit();
    }
}
