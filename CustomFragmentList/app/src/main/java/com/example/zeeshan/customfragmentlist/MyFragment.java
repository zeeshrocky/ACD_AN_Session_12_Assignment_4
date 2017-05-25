package com.example.zeeshan.customfragmentlist;


import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MyFragment extends ListFragment {
    String[] players = {"Facebook", "PinIt", "YouTube", "twitter"};
    String[] descriptions = {"Facebook Description", "PinIt  Description", "YouTube  Description", "twitter  Description"};

    int[] images = {R.mipmap.facebook,R.mipmap.pinit,R.mipmap.youtube,R.mipmap.twitter};

    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //MAP
        HashMap<String, String> map = new HashMap<String, String>();
        //FILL
        for(int i=0;i<players.length;i++){
            map = new HashMap<String, String>();
            map.put("player",players[i]);
            map.put("image", Integer.toString(images[i]));
            map.put("description",descriptions[i]);

            data.add(map);
        }
        //KEYS IN MAP
        String[] from ={"player","description","image"};

        //IDs of View
        int[] to = {R.id.nameTxt,R.id.nameDescriptionTxt, R.id.imageView1};

        //ADAPTER
        adapter = new SimpleAdapter(getActivity(), data, R.layout.model,from,to);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View view, int position, long id) {
                Toast.makeText(getActivity(),data.get(position).get("player"), Toast.LENGTH_LONG).show();
            }
        });
    }
}