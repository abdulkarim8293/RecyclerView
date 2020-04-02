package com.android.abdulkarim.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

    public ContactAdapter(Context context, List<Contact> contactList,OnItemClickListener onItemClickListener) {
        this.context = context;
        this.contactList = contactList;
        this.onItemClickListener = onItemClickListener;
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
        }

        final Contact contact = contactList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v,contact,holder.getAdapterPosition());
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemClickListener.onItemLongClick(v, contact, holder.getAdapterPosition());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
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

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            text_person_name = itemView.findViewById(R.id.text_person_name);
            text_person_position = itemView.findViewById(R.id.text_person_position);
            image_person_avatar = itemView.findViewById(R.id.person_avatar);

        }
    }
}
