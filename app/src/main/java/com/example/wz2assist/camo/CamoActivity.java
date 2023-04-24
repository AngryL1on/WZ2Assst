package com.example.wz2assist.camo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.wz2assist.MainActivity;
import com.example.wz2assist.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CamoActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<String> listGroup;
    HashMap<String, List<String>> listItem;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camo);

        expandableListView = findViewById(R.id.expandable_listview);
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new MainAdapter(this, listGroup, listItem);
        expandableListView.setAdapter(adapter);
        initListData();
    }

    private void initListData() {

        String[] array;

        //формирование родительского списка
        array = getResources().getStringArray(R.array.classWeapons);
        for(String item : array){
            listGroup.add(item);
        }

        //формирование кучи детских списков
        List<String> list1 = new ArrayList<>();
        array = getResources().getStringArray(R.array.assaultRifles);
        for(String item : array){
            list1.add(item);
        }

        List<String> list2 = new ArrayList<>();
        array = getResources().getStringArray(R.array.combatRifles);
        for(String item : array){
            list2.add(item);
        }

        List<String> list3 = new ArrayList<>();
        array = getResources().getStringArray(R.array.smg);
        for(String item : array){
            list3.add(item);
        }

        List<String> list4 = new ArrayList<>();
        array = getResources().getStringArray(R.array.lmg);
        for(String item : array){
            list4.add(item);
        }

        List<String> list5 = new ArrayList<>();
        array = getResources().getStringArray(R.array.shotguns);
        for(String item : array){
            list5.add(item);
        }

        List<String> list6 = new ArrayList<>();
        array = getResources().getStringArray(R.array.sniperRifles);
        for(String item : array){
            list6.add(item);
        }

        List<String> list7 = new ArrayList<>();
        array = getResources().getStringArray(R.array.marksmanRifles);
        for(String item : array){
            list7.add(item);
        }

        List<String> list8 = new ArrayList<>();
        array = getResources().getStringArray(R.array.melees);
        for(String item : array){
            list8.add(item);
        }

        List<String> list9 = new ArrayList<>();
        array = getResources().getStringArray(R.array.pistols);
        for(String item : array){
            list9.add(item);
        }

        List<String> list10 = new ArrayList<>();
        array = getResources().getStringArray(R.array.launchers);
        for(String item : array){
            list10.add(item);
        }

        //формирование хешмапы всех айтемов
        listItem.put(listGroup.get(0),list1);
        listItem.put(listGroup.get(1),list2);
        listItem.put(listGroup.get(2),list3);
        listItem.put(listGroup.get(3),list4);
        listItem.put(listGroup.get(4),list5);
        listItem.put(listGroup.get(5),list6);
        listItem.put(listGroup.get(6),list7);
        listItem.put(listGroup.get(7),list8);
        listItem.put(listGroup.get(8),list9);
        listItem.put(listGroup.get(9),list10);

        adapter.notifyDataSetChanged();
    }

    public void goHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}