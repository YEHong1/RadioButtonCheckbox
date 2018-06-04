package study.liangyehong.android.radiobuttoncheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class checkboxActivity extends AppCompatActivity implements View.OnClickListener,CompoundButton.OnCheckedChangeListener {

    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        initView();
    }

    private void initView() {
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                String choose = "";
                if (cb1.isChecked()){
                    choose += cb1.getText().toString() + "";
                }
                if (cb2.isChecked()){
                    choose += cb2.getText().toString() + "";
                }
                if (cb3.isChecked()){
                    choose += cb3.getText().toString() + "";
                }
                Toast.makeText(getApplicationContext(),"被选中的有"+choose,Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.isChecked()){
            Toast.makeText(getApplicationContext(),buttonView.getText().toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
