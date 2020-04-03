package com.android.abdulkarim.recyclerview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

    private Context context;
    private List<Contact> contactList;

    private OnItemClickListener onItemClickListener;
    private SparseBooleanArray selected_items;
    private int current_selected_idx = -1;

    public ContactAdapter(Context context, List<Contact> contactList,OnItemClickListener onItemClickListener) {
        this.context = context;
        this.contactList = contactList;
        this.onItemClickListener = onItemClickListener;

        selected_items = new SparseBooleanArray();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        if (viewType == Common.VIEW_TYPE_GROUP){
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.group_layout,viewGroup,false);
            GroupViewHolder groupViewHolder = new GroupViewHolder(group);
            return groupViewHolder;
        }else if (viewType == Common.VIEW_TYPE_PERSON){

            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.person_layout,viewGroup,false);
            PersonViewHolder personViewHolder = new PersonViewHolder(group);
            return personViewHolder;
        }
        else {

            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.group_layout,viewGroup,false);
            GroupViewHolder groupViewHolder = new GroupViewHolder(group);
            return groupViewHolder;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return  contactList.get(position).getViewType();
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof GroupViewHolder){
            GroupViewHolder groupViewHolder = (GroupViewHolder) holder;
            groupViewHolder.text_group_title.setText(contactList.get(position).getName());

        }else if (holder instanceof PersonViewHolder){

            PersonViewHolder personViewHolder = (PersonViewHolder) holder;
            personViewHolder.text_person_name.setText(contactList.get(position).getName());
            personViewHolder.text_person_position.setText(contactList.get(position).getNumber());

            if (contactList.get(position).getProfileImage() == null){
                ColorGenerator generator = ColorGenerator.MATERIAL;
                TextDrawable drawable = TextDrawable.builder().buildRound(String.valueOf(contactList.get(position).getName().charAt(0)),generator.getRandomColor());
                personViewHolder.image_person_avatar.setImageDrawable(drawable);
            }else {
                personViewHolder.image_person_avatar.setImageResource(contactList.get(position).getProfileImage());
            }

            toggleCheckedIcon(holder, position);
        }



        final Contact contact = contactList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(contact,holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public void toggleSelection(int pos) {
        current_selected_idx = pos;
        if (selected_items.get(pos, false)) {
            selected_items.delete(pos);
        } else {
            selected_items.put(pos, true);
        }
        notifyItemChanged(pos);
    }

    public int getSelectedItemCount() {
        return selected_items.size();
    }

    public void clearSelections() {
        selected_items.clear();
        notifyDataSetChanged();
    }

    private void toggleCheckedIcon(RecyclerView.ViewHolder holder, int position) {

        PersonViewHolder personViewHolder = (PersonViewHolder) holder;

        if (selected_items.get(position, false)) {

            //personViewHolder.image_person_avatar.setVisibility(View.GONE);
            //holder.lyt_checked.setVisibility(View.VISIBLE);
            if (current_selected_idx == position) resetCurrentIndex();
        } else {
            //holder.lyt_checked.setVisibility(View.GONE);
            //holder.lyt_image.setVisibility(View.VISIBLE);
            if (current_selected_idx == position) resetCurrentIndex();
        }
    }


    private void resetCurrentIndex() {
        current_selected_idx = -1;
    }

    private class GroupViewHolder extends RecyclerView.ViewHolder{

        TextView text_group_title;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            text_group_title = itemView.findViewById(R.id.text_group_title);
        }
    }

    private class PersonViewHolder extends RecyclerView.ViewHolder{

        TextView text_person_name,text_person_position;
        ImageView image_person_avatar;
        LinearLayout linearLayout;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            text_person_name = itemView.findViewById(R.id.text_person_name);
            text_person_position = itemView.findViewById(R.id.text_person_position);
            image_person_avatar = itemView.findViewById(R.id.person_avatar);

            linearLayout = itemView.findViewById(R.id.layout);

        }
    }
}
