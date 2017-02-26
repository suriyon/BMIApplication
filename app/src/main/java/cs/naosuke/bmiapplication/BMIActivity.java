package cs.naosuke.bmiapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BMIActivity extends AppCompatActivity {
    Button btnCalculate;
    EditText edtWeight;
    EditText edtHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        initInstance();

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float weight = Float.parseFloat(edtWeight.getText().toString());
                float height = Float.parseFloat(edtHeight.getText().toString());

                Intent intent = new Intent(BMIActivity.this, ResultBMIActivity.class);
                intent.putExtra("weight", weight);
                intent.putExtra("height", height);
                edtHeight.setText("");
                edtWeight.setText("");
                startActivity(intent);
            }
        });
    }

    private void initInstance() {
        btnCalculate = (Button) findViewById(R.id.btn_calculate);
        edtHeight = (EditText) findViewById(R.id.edt_height);
        edtWeight = (EditText) findViewById(R.id.edt_weight);
    }
}
