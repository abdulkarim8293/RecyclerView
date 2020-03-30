package com.android.abdulkarim.recyclerview.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.android.abdulkarim.recyclerview.model.Person;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Person> personList;

    public PersonAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
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

        return  personList.get(position).getViewType();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof GroupViewHolder){
            GroupViewHolder groupViewHolder = (GroupViewHolder) holder;
            groupViewHolder.text_group_title.setText(personList.get(position).getName());
            groupViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //((Activity)context).startActivityForResult(new Intent(context, AlphabetActivity.class),Common.RESULT_CODE);
                }
            });
        }else if (holder instanceof PersonViewHolder){

            PersonViewHolder personViewHolder = (PersonViewHolder) holder;
            personViewHolder.text_person_name.setText(personList.get(position).getName());
            personViewHolder.text_person_position.setText(personList.get(position).getNumber());

            ColorGenerator generator = ColorGenerator.MATERIAL;
            TextDrawable drawable = TextDrawable.builder().buildRound(String.valueOf(personList.get(position).getName().charAt(0)),generator.getRandomColor());
            personViewHolder.image_person_avatar.setImageDrawable(drawable);

        }

    }

    @Override
    public int getItemCount() {
        return personList.size();
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
