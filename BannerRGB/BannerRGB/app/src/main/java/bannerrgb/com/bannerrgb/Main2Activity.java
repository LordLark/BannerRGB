package bannerrgb.com.bannerrgb;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView banner;
    private String str;
    private int rNum;
    private int bNum;
    private int gNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main2);
        banner = findViewById(R.id.Output);
        rNum = getIntent().getExtras().getInt("red");
        bNum = getIntent().getExtras().getInt("blue");
        gNum = getIntent().getExtras().getInt("green");
        str = getIntent().getExtras().getString("text");
        banner.setBackgroundColor(Color.BLACK);
        banner.setMovementMethod(new ScrollingMovementMethod());
        banner.setText(str);
        banner.setTextColor(Color.rgb(rNum,gNum,bNum));
        getSupportActionBar().hide();


    }


}

