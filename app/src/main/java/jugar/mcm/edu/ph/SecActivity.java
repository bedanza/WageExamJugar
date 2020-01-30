package jugar.mcm.edu.ph;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class SecActivity extends AppCompatActivity {

    Spinner sexSpin, deptSpin;
    String sex, dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        sexSpin = findViewById(R.id.sexSpinner);
        deptSpin = findViewById(R.id.deptSpinner);
        Button ok = findViewById(R.id.okButton);

        final EditText callIdNum = findViewById(R.id.idNum);
        final EditText callLName = findViewById(R.id.lName);
        final EditText callFName = findViewById(R.id.fName);
        final EditText callAge = findViewById(R.id.age);
        final EditText callHours = findViewById(R.id.hoursRendered);

        sexSpin.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        sex = sexSpin.getSelectedItem().toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );

        deptSpin.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        dept = deptSpin.getSelectedItem().toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );

        ok.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String idNumString = String.valueOf(callIdNum.getText());
                        final String lnameString = String.valueOf(callLName.getText());
                        final String fnameString = String.valueOf(callFName.getText());
                        final String ageString = String.valueOf(callAge.getText());
                        final String hoursString = String.valueOf(callHours.getText());

                        Intent intent2 = new Intent(SecActivity.this, ThirdActivity.class);
                        intent2.putExtra("callVar1", idNumString);
                        intent2.putExtra("callVar2", lnameString);
                        intent2.putExtra("callVar3", fnameString);
                        intent2.putExtra("callVar4", ageString);
                        intent2.putExtra("callVar5", hoursString);
                        intent2.putExtra("callVar6", sex);
                        intent2.putExtra("callVar7", dept);

                        startActivity(intent2);
                    }
                }
        );

    }
}