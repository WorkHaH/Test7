package com.example.test7.activity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test7.R;

public class Task2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        Button queryall = findViewById(R.id.selectall);
        queryall.setOnClickListener(view -> {
            Uri uri = Uri.parse("content://com.example.test7.provider/contacts");
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                    @SuppressLint("Range") String phone = cursor.getString(cursor.getColumnIndex("phone"));
                    @SuppressLint("Range") String sex = cursor.getString(cursor.getColumnIndex("sex"));
                    Log.d("Test7", "---------查询所有记录---------");
                    Log.d("Test7", "联系人的名字是：" + name);
                    Log.d("Test7", "联系人的性别是：" + sex);
                    Log.d("Test7", "联系人的电话是：" + phone);
                    Log.d("Test7", "----------------------------");
                }
                cursor.close();
            }
        });

        Button queryone = findViewById(R.id.selectone);
        EditText nameEdit = findViewById(R.id.edit_name);
        queryone.setOnClickListener(view -> {
            String key = nameEdit.getText().toString();
            Uri uri = Uri.parse("content://com.example.test7.provider/contacts/" + key);
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                if (cursor.moveToNext()) {
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                    @SuppressLint("Range") String phone = cursor.getString(cursor.getColumnIndex("phone"));
                    @SuppressLint("Range") String sex = cursor.getString(cursor.getColumnIndex("sex"));
                    Log.d("Test7", "---------查询单个记录---------");
                    Log.d("Test7", "查询id为：" + key);
                    Log.d("Test7", "联系人的名字是：" + name);
                    Log.d("Test7", "联系人的性别是：" + sex);
                    Log.d("Test7", "联系人的电话是：" + phone);
                    Log.d("Test7", "----------------------------");
                }
            }
            cursor.close();
        });
    }
}