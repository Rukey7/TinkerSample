package com.dl7.sample.tinker;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvTest;
    private Button mBtnTest;
    private LinearLayout mActivityMain;
    private Button mBtnLoad;
    private Button mBtnKill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTvTest = (TextView) findViewById(R.id.tv_test);
        mBtnTest = (Button) findViewById(R.id.btn_test);
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);

        mBtnTest.setOnClickListener(this);
        mBtnLoad = (Button) findViewById(R.id.btn_load);
        mBtnLoad.setOnClickListener(this);
        mBtnKill = (Button) findViewById(R.id.btn_kill);
        mBtnKill.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                Toast.makeText(this, "嘿嘿", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_load:
                TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),
                        Environment.getExternalStorageDirectory().getAbsolutePath() +
                                "/patch_signed_7zip.apk");
                break;
            case R.id.btn_kill:
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
        }
    }
}
