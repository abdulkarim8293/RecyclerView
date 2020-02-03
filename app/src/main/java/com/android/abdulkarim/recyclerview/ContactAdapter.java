package com.android.abdulkarim.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    private List<Contact> contactList;
    private Context context;
    private String[] iColors = {"#3F51B5","#F44336","#009688","#673AB7"};

    public ContactAdapter(Context context, List<Contact> contactList){
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.MyViewHolder holder, final int position) {

        holder.iconBackground.setBackgroundColor(Color.parseColor(iColors[position % 4]));
        holder.icon.setText(String.valueOf(contactList.get(position).getContactName().charAt(0)));
        holder.contactName.setText(contactList.get(position).getContactName());
        holder.contactNumber.setText(contactList.get(position).getContactNumber());

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView icon,contactName,contactNumber;
        private RelativeLayout iconBackground;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contactNameTextView);
            contactNumber = itemView.findViewById(R.id.contactNumberTextView);
            icon = itemView.findViewById(R.id.iconTextView);
            iconBackground = itemView.findViewById(R.id.iconRL);
        }
    }
}
