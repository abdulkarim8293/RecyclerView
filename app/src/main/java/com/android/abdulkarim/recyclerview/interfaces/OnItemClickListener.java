package com.android.abdulkarim.recyclerview.interfaces;

import android.provider.Telephony;
import android.view.View;

import com.android.abdulkarim.recyclerview.model.Contact;

public interface OnItemClickListener {
    void onItemClick(View view, Contact contact, int position);
    void onItemLongClick(View view, Contact contact, int position);
}
