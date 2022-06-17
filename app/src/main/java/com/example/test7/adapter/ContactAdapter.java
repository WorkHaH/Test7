package com.example.test7.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.test7.R;
import com.example.test7.pojo.Contact;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    private int resourceId;

    public ContactAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<Contact> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Contact phone = getItem(position);  // 获取当前项实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);   // 填充布局
            viewHolder = new ViewHolder();
            viewHolder.name = view.findViewById(R.id.name);
            viewHolder.phone = view.findViewById(R.id.phone);
            view.setTag(viewHolder);
        } else {
            // 不重复加载布局
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();    // 重新获取ViewHolder
        }
        // 数据设置
        viewHolder.name.setText(phone.getName());
        viewHolder.phone.setText(phone.getPhone());
        return view;
    }

    static class ViewHolder {
        TextView name;
        TextView phone;
    }
}
