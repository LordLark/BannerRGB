package bannerrgb.com.bannerrgb;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.icu.util.Output;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button showB;
    public EditText userInput;
    public TextView outPut;
    public SeekBar rBar;
    public SeekBar gBar;
    public SeekBar bBar;
    public int rValue;
    public int bValue;
    public int gValue;
    public String holdText;
    public TextView greenNumber;
    public TextView redNumber;
    public TextView blueNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rBar = findViewById(R.id.redBar);
        bBar = findViewById(R.id.blueBar);
        gBar = findViewById(R.id.greenBar);
        showB = findViewById(R.id.ShowButton);
        greenNumber = findViewById(R.id.gNumber);
        redNumber = findViewById(R.id.rNumber);
        blueNumber = findViewById(R.id.bNumber);
        userInput = findViewById(R.id.UserText);
        outPut = findViewById(R.id.Output);
        SetBars();
        seekBars();
        DeviceChecker();
        showB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OpenNewActivity();
            }
        });

    }
    public void SetBars(){
        rBar.setMin(0);
        rBar.setMax(255);
        bBar.setMin(0);
        bBar.setMax(255);
        gBar.setMin(0);
        gBar.setMax(255);
    }
    public void seekBars(){
        redNumber.setText("" + rBar.getProgress() + "");
        blueNumber.setText("" + bBar.getProgress() + "");
        greenNumber.setText("" + gBar.getProgress() + "");

        rBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int prog;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rValue = progress;
                prog = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                redNumber.setText("" + prog + "");
            }
        });
        bBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int prog;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                bValue = progress;
                prog = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                blueNumber.setText("" + prog + "");

            }
        });
        gBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int prog;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                gValue = progress;
                prog = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                greenNumber.setText("" + prog + "");

            }
        });


    }


    public void DeviceChecker(){
       /* View frameLayoutView = findViewById(R.id.detailFragmentID);
        if(frameLayoutView != null){
        */
        if(findViewById(R.id.main_activity_view).getTag().equals("smallScreen")) {
            //do nothing
        }
        else{
            outPut.setBackgroundColor(Color.BLACK);
            outPut.setTextColor(Color.WHITE);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            outPut.setRotation(270);
        }
    }


    public void OpenNewActivity(){

        if(findViewById(R.id.main_activity_view).getTag().equals("smallScreen")) {
            Intent changeView = new Intent(MainActivity.this, Main2Activity.class);
            holdText = userInput.getText().toString();
            changeView.putExtra("text", holdText);
            changeView.putExtra("red", rValue);
            changeView.putExtra("blue", bValue);
            changeView.putExtra("green", gValue);
            startActivity(changeView);

        }

        else{
            String str = userInput.getText().toString();
            outPut.setText(str);
            outPut.setTextColor(Color.rgb(rValue,gValue,bValue));
            outPut.setMovementMethod(new ScrollingMovementMethod());

        }

    }


}
