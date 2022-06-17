package com.example.test7.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseProvider extends ContentProvider {
    // URI
    private static final String AUTHORITY = "com.example.test7.provider";
    private static final int CONTACTS_DIR = 0;
    private static final int CONTACTS_ITEM = 1;
    private static UriMatcher uriMatcher;
    private DatabaseHelper databaseHelper;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "contacts", CONTACTS_DIR);
        uriMatcher.addURI(AUTHORITY, "contacts/#", CONTACTS_ITEM);
    }

    @Override
    public boolean onCreate() {
        databaseHelper = new DatabaseHelper(getContext(), "db", null, 2);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = null;
        switch (uriMatcher.match(uri)) {
            case CONTACTS_DIR:
                cursor = db.query("Contacts", projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case CONTACTS_ITEM:
                String id = uri.getPathSegments().get(1);
                cursor = db.query("Contacts", projection, "id=?", new String[]{id}, null, null, sortOrder);
            default:
                break;
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)) {
            case CONTACTS_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.test7.provider.contacts";
            case CONTACTS_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.test7.provider.contacts";
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
