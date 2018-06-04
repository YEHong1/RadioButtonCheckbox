package study.liangyehong.android.radiobuttoncheckbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.rg);
        //第一种获得单选按钮值得方法
        //为RadioGroup设置一个监听器：setOnCheckedChanged()
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton)findViewById(checkedId);
                Toast.makeText(getApplicationContext(),"按钮组值发生改变,你选了"+radioButton.getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        //第二种
        Button btn1 = (Button) findViewById(R.id.bt1);
        final RadioGroup radioGroup1 = (RadioGroup)findViewById(R.id.rg1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0; i < radioGroup1.getChildCount(); i++){
                    RadioButton radioButton1 = (RadioButton)radioGroup1.getChildAt(i);
                    if (radioButton1.isChecked()){
                        Toast.makeText(getApplicationContext(),"按钮组值发生改变,你选了"+radioButton1.getText(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Button checkbox = (Button)findViewById(R.id.checkbox);
        checkbox.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.checkbox:
                Intent intent = new Intent(MainActivity.this,checkboxActivity.class);
                startActivity(intent);
                break;
        }
    }
}
