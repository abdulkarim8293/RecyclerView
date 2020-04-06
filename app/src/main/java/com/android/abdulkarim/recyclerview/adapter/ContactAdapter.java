package com.android.abdulkarim.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.android.abdulkarim.recyclerview.R;
import com.android.abdulkarim.recyclerview.common.Common;
import com.android.abdulkarim.recyclerview.interfaces.OnItemClickListener;
import com.android.abdulkarim.recyclerview.model.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Contact> contactList;
    private OnItemClickListener onItemClickListener;

    public ContactAdapter(List<Contact> contactList, OnItemClickListener onItemClickListener) {
        this.contactList = contactList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        if (viewType == Common.VIEW_TYPE_CONTACT_GROUP) {
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.contact_group_item_layout, viewGroup, false);
            ContactGroupViewHolder contactGroupViewHolder = new ContactGroupViewHolder(group);
            return contactGroupViewHolder;
        } else if (viewType == Common.VIEW_TYPE_CONTACT) {
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.contact_item_layout, viewGroup, false);
            ContactViewHolder contactViewHolder = new ContactViewHolder(group);
            return contactViewHolder;
        } else {
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.contact_group_item_layout, viewGroup, false);
            ContactGroupViewHolder contactGroupViewHolder = new ContactGroupViewHolder(group);
            return contactGroupViewHolder;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return contactList.get(position).getViewType();
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {

        final Contact contact = contactList.get(position);

        if (holder instanceof ContactGroupViewHolder) {
            ContactGroupViewHolder contactGroupViewHolder = (ContactGroupViewHolder) holder;
            contactGroupViewHolder.contact_group_title.setText(contactList.get(position).getName());

        } else if (holder instanceof ContactViewHolder) {
            ContactViewHolder contactViewHolder = (ContactViewHolder) holder;
            contactViewHolder.contactName.setText(contactList.get(position).getName());
            contactViewHolder.contactNumber.setText(contactList.get(position).getNumber());

            if (contactList.get(position).getProfileImage() == null) {
                ColorGenerator generator = ColorGenerator.MATERIAL;
                TextDrawable drawable = TextDrawable.builder().buildRound(String.valueOf(contactList.get(position).getName().charAt(0)), generator.getRandomColor());
                contactViewHolder.contactImage.setImageDrawable(drawable);
            } else {
                contactViewHolder.contactImage.setImageResource(contactList.get(position).getProfileImage());
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(contact, holder.getAdapterPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    private class ContactGroupViewHolder extends RecyclerView.ViewHolder {

        TextView contact_group_title;

        public ContactGroupViewHolder(@NonNull View itemView) {
            super(itemView);
            contact_group_title = itemView.findViewById(R.id.contact_group_title_id);
        }
    }

    private class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView contactName, contactNumber;
        ImageView contactImage;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contact_name_id);
            contactNumber = itemView.findViewById(R.id.contact_number_id);
            contactImage = itemView.findViewById(R.id.contact_image_id);
        }
    }
}
