package cs.naosuke.bmiapplication;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultBMIActivity extends AppCompatActivity {
    TextView tvResult;
    TextView tvSuggestion;
    ImageView imgBMI;
    Button btnClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_bmi);

        initInstance();
        Intent intent = getIntent();
        float weight = intent.getFloatExtra("weight", 0.0f);
        float height = intent.getFloatExtra("height", 0.0f);

        height = height / 100;
        float bmi = weight/(height*height);
        Log.d("Height: ", height + "");
        Log.d("Weight: ", weight + "");
        Log.d("BMI: ", bmi + "");


        String result = "";
        String suggestion = "";
        if(bmi < 18.5){
            result = "BMI: " + bmi + " -> Underweight";
            suggestion = "นำ้หนักน้อยกว่ามาตรฐาน กินเยอะๆ นะ :)";
            imgBMI.setImageResource(R.drawable._underweight);
        }else if(bmi <= 24.9 && bmi >= 18.5){
            result = "BMI: " + bmi + " -> Normal Weight";
            suggestion = "นำ้หนักเป็นปกติ ";
            imgBMI.setImageResource(R.drawable._normalweight);
        }else if(bmi >= 25 && bmi <=29.9){
            result = "BMI: " + bmi + " -> Overweight";
            suggestion = "นำ้หนักเกินแต่ยังไม่เรียกว่าอ้วน อวบไปแล้วนะ";
            imgBMI.setImageResource(R.drawable._overweight);
        }else {
            result = "BMI: " + bmi + " -> Obesity";
            suggestion = "อ้วนเกินไปแล้ว เสี่ยงเกิดโรคที่จะตามมาจากความอ้วน";
            imgBMI.setImageResource(R.drawable._obisity);
        }
        tvResult.setText(result);
        tvSuggestion.setText(suggestion);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //Toast.makeText(this, "Result : " + result, Toast.LENGTH_SHORT).show();
    }

    private void initInstance() {
        btnClose = (Button) findViewById(R.id.btn_close);
        tvResult = (TextView) findViewById(R.id.tv_result);
        tvSuggestion = (TextView) findViewById(R.id.tv_suggestion);
        imgBMI = (ImageView) findViewById(R.id.img_bmi);
    }
}
