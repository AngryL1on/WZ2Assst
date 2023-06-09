package com.example.wz2assist.camo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wz2assist.R;

import java.util.HashMap;
import java.util.List;

public class MainAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listGroup;
    private HashMap<String, List<String>> listItem;

    public MainAdapter(Context context, List<String> listGroup, HashMap<String, List<String>> listItem){
        this.context = context;
        this.listGroup = listGroup;
        this.listItem = listItem;
    }

    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listItem.get(this.listGroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listItem.get(this.listGroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String group = (String) getGroup(groupPosition);
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }

        TextView textView = convertView.findViewById(R.id.list_parent);
        textView.setText(group);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup viewGroup) {
        final String child = (String) getChild(groupPosition, childPosition);
        if(convertView == null){
            LayoutInflater layoutInflater= (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }
        TextView textView = convertView.findViewById(R.id.list_child);
        textView.setText(child);

        //чекбокс на голд(первая позиция)
        CheckBox checkBoxG = (CheckBox) convertView.findViewById(R.id.goldCamo);
        checkBoxG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //прокидываем тост, для проверки
                Toast.makeText(context,"button is pressed", Toast.LENGTH_LONG).show();
            }
        });

        //чекбокс на платину(вторая позиция)
        CheckBox checkBoxP = (CheckBox) convertView.findViewById(R.id.platinumCamo);
        checkBoxP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //прокидываем тост, для проверки
                Toast.makeText(context, "button is pressed", Toast.LENGTH_LONG).show();
            }
        });

        //чекбокс на полиатом(третья позиция)
        CheckBox checkBoxPa = (CheckBox) convertView.findViewById(R.id.polyatomCamo);
        checkBoxPa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //прокидываем тост, для проверки
                Toast.makeText(context, "button is pressed", Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    
}
