package com.example.test7.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.test7.pojo.Contact;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_CONTACTS = "create table Contacts ("
            + "id integer primary key autoincrement,"
            + "name text,"
            + "phone text,"
            + "sex text)";

    private List<Contact> contactList = new ArrayList<>();

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_CONTACTS);
        initContacts();
        ContentValues values = new ContentValues();
        // 初始化表的数据信息
        for (Contact contact : contactList) {
            values.put("name", contact.getName());
            values.put("phone", contact.getPhone());
            values.put("sex", contact.getSex());
            sqLiteDatabase.insert("Contacts", null, values);
            values.clear();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Contacts");
        onCreate(sqLiteDatabase);
    }

    // 初始化数据
    public void initContacts() {
        Contact contact;
        contact = new Contact("123456789","C++","男");
        contactList.add(contact);
        contact = new Contact("123123123","JAVA","女");
        contactList.add(contact);
        contact = new Contact("456456456","Python","男");
        contactList.add(contact);
        contact = new Contact("789789789","Android","男");
        contactList.add(contact);
        contact = new Contact("234234234","Spring","女");
        contactList.add(contact);
    }
}
