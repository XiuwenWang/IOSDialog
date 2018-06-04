package com.jeffrey.iosdialog;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mingxiu.dialog.dialog.IOSAlert;
import com.mingxiu.dialog.dialog.IOSSheet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_IOSAlert:
                new IOSAlert.Builder(this)
                        .setTitle("标题")
                        .setMessage("消息内容")
                        .setPositiveButton("确定", new IOSAlert.OnClickListener() {
                            @Override
                            public void onClick(IOSAlert dialog) {
                                dialog.dismiss();
                                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消")
                        .setAutoDismiss(false)
                        .show();
                break;
            case R.id.btn_IOSSheet:
                new IOSSheet.Builder(this)
                        .setTitle("标题")
                        .addSheetItem("0")
                        .addSheetItem(new String[]{"1", "2", "3"})
                        .addSheetItem("5", Color.RED,15)
                        .setOnItemClickListener(new IOSSheet.OnItemClickListener() {
                            @Override
                            public void onClick(int position, IOSSheet dialog) {
                                //Item 点击回调
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("取消")
                        .setAutoDismiss(false)
                        .show();
                break;
        }

    }

}
