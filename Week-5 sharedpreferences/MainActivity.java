import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    EditText editAge;
    EditText editGender;

    Button btnSave;
    TextView textDisplay;

    SharedPreferences sharedPreferences;

    public static final String PREF_NAME = "UserInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Initialize views
        editName = findViewById(R.id.editName);
        editAge = findViewById(R.id.editAge);
        editGender = findViewById(R.id.editGender);

        btnSave = findViewById(R.id.btnSave);
        textDisplay = findViewById(R.id.textDisplay);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(
                PREF_NAME,
                MODE_PRIVATE
        );

        // Load previously saved data
        loadUserData();

        // Save button click listener
        btnSave.setOnClickListener(v -> {
            saveUserData();
        });
    }

    // Save user information
    private void saveUserData() {

        String name = editName.getText().toString();
        String age = editAge.getText().toString();
        String gender = editGender.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Name", name);
        editor.putString("Age", age);
        editor.putString("Gender", gender);

        editor.apply();

        textDisplay.setText(
                "Saved: " + name + ", " + age + ", " + gender
        );
    }

    // Load previously saved user information
    private void loadUserData() {

        String name = sharedPreferences.getString(
                "Name",
                "Not set"
        );

        String age = sharedPreferences.getString(
                "Age",
                "Not set"
        );

        String gender = sharedPreferences.getString(
                "Gender",
                "Not set"
        );

        textDisplay.setText(
                "Loaded: " + name + ", " + age + ", " + gender
        );
    }
}
