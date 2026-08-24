import androidx.appcompat.app.AppCompatActivity;
import android.view.View; 
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber1, editTextNumber2;

    Button btnAdd;
    Button btnSubtract;
    Button btnMultiply;
    Button btnDivide;

    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Initialize views
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);

        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        textViewResult = findViewById(R.id.textViewResult);

        // Set button click listeners
        btnAdd.setOnClickListener(v -> calculate('+'));
        btnSubtract.setOnClickListener(v -> calculate('-'));
        btnMultiply.setOnClickListener(v -> calculate('*'));
        btnDivide.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operator) {

        // Get input values
        String num1Str = editTextNumber1.getText().toString();
        String num2Str = editTextNumber2.getText().toString();

        // Check if both numbers are entered
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            textViewResult.setText("Please enter both numbers");
            return;
        }

        // Convert strings to numbers
        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);

        double result = 0;

        // Perform calculation
        switch (operator) {

            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                if (num2 == 0) {
                    textViewResult.setText("Cannot divide by zero");
                    return;
                }

                result = num1 / num2;
                break;
        }

        // Display result
        textViewResult.setText("Result: " + result);
    }
}
