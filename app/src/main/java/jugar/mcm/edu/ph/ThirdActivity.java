package jugar.mcm.edu.ph;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        String myFName = "Hernan";
        String myLName = "Jugar";

        Button callBackButton = findViewById(R.id.backButton);

        ImageView callAvatar = findViewById(R.id.avatar);
        ImageView callMyPic = findViewById(R.id.myPic);
        callMyPic.setVisibility(View.GONE);
        callAvatar.setVisibility(View.VISIBLE);

        String idNumFinal = getIntent().getStringExtra("callVar1");
        String lnameFinal = getIntent().getStringExtra("callVar2");
        String fnameFinal = getIntent().getStringExtra("callVar3");
        String ageFinal = getIntent().getStringExtra("callVar4");
        String hoursNotFinal = getIntent().getStringExtra("callVar5");
        String sexFinal = getIntent().getStringExtra("callVar6");
        String deptFinal = getIntent().getStringExtra("callVar7");

        int salary = 0;
        int otHours = 0;
        int rate = 0;
        int otRate = 0;
        String deptShow = "";


        TextView callIdText = findViewById(R.id.idDisplay);
        TextView callName = findViewById(R.id.nameDisplay);
        TextView callAgeSex = findViewById(R.id.ageSexDisplay);
        TextView callDept = findViewById(R.id.deptDisplay);
        TextView callHours = findViewById(R.id.hoursDisplay);

        TextView callOtHoursLabel = findViewById(R.id.otHoursLabel);
        TextView callOtHours = findViewById(R.id.otHoursDisplay);
        TextView callRate = findViewById(R.id.rateDisplay);
        TextView callOtRateLabel = findViewById(R.id.otRateLabel);
        TextView callOtRate = findViewById(R.id.otRateDisplay);
        TextView callWage = findViewById(R.id.wageDisplay);

        if(myFName.equalsIgnoreCase(fnameFinal) && myLName.equalsIgnoreCase(lnameFinal)) {
            callMyPic.setVisibility(View.VISIBLE);
        }


        int hoursFinal = Integer.parseInt(hoursNotFinal);

        callIdText.setText(String.valueOf(idNumFinal));
        callName.setText(lnameFinal + ", " + fnameFinal);
        callAgeSex.setText(ageFinal + ", " + sexFinal);

        callHours.setText(hoursNotFinal);

        switch(deptFinal) {
            case "HR":
                rate = 100;
                otRate = 130;
                deptShow = "Human Resources \nDepartment";
                break;
            case "Academic":
                rate = 90;
                otRate = 140;
                deptShow = "Academic \nDepartment";
                break;
            case "Admin":
                rate = 110;
                otRate = 150;
                deptShow = "Administrative \nDepartment";
                break;
        }

        callDept.setText(deptShow);
        callRate.setText("\u20B1"+rate+".00");

        if(hoursFinal <= 8) {
            salary = hoursFinal*rate;
            otHours = 0;
            callOtHoursLabel.setVisibility(View.GONE);
            callOtHours.setVisibility(View.GONE);
            callOtRate.setVisibility(View.GONE);
            callOtRateLabel.setVisibility(View.GONE);
        } else {
            salary = (rate*8) + (hoursFinal - 8) * otRate;
            otHours = hoursFinal - 8;

            String otHoursFinal = String.valueOf(otHours);
            String otRateFinal = String.valueOf(otRate);

            callOtHours.setText(otHoursFinal);
            callOtRate.setText("\u20B1"+otRateFinal+".00");
        }
        callWage.setText("\u20B1"+salary+".00");

        callBackButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent3 = new Intent(ThirdActivity.this, SecActivity.class);
                        startActivity(intent3);
                    }
                }
        );
    }
}
