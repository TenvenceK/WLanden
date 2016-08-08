package com.tenvence.wlanden;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_opensidebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_opensidebar = (Button) findViewById(R.id.btn_opensidebar);

        btn_opensidebar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(WLan.GetWiFiName(MainActivity.this));
                System.out.println(WLan.GetIP(MainActivity.this));
                System.out.println(WLan.GetMac(MainActivity.this));
            }
        });
    }
}