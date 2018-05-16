package com.example.arpitkanda.orgnickart;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Item_with_Images extends Fragment{
    TextView qty_plus;
    TextView qty_minus;
    TextView qty;
    int number = 0;
    String[] names={"Apple","Mango","Orange"};
    int[] images={R.drawable.code,R.drawable.code,R.drawable.code,R.drawable.code};
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
//        final View view;
//        view=inflater.inflate(R.layout.item_with_images, container, false);
//        RecyclerView rv= (RecyclerView)view.findViewById(R.id.my_recycler_view);
//        //SET LAYOUT
//        rv.setLayoutManager(new LinearLayoutManager(getContext()));
//        rv.setItemAnimator(new DefaultItemAnimator());
//        //ADAPTER
//        Item_Adapter adapter=new Item_Adapter(getContext(),names,images);
//        rv.setAdapter(adapter);
        View view;
        view=inflater.inflate(R.layout.product_listview, container, false);
        qty = (TextView) view.findViewById(R.id.qty);
        qty_plus = (TextView) view.findViewById(R.id.qty_plus);
        qty_minus = (TextView) view.findViewById(R.id.qty_minus);
        final ArrayList<Get_Items> name=new ArrayList<Get_Items>();
        name.add(new Get_Items("Panda","Apple",R.drawable.code));
        name.add(new Get_Items("Panda Tv","",R.drawable.code));
        name.add(new Get_Items("Panda Enjoy","Apple",R.drawable.code));
        name.add(new Get_Items("Panda Enjoy","Apple",R.drawable.code));
        name.add(new Get_Items("Panda Enjoy","Apple",R.drawable.code));
        name.add(new Get_Items("Panda Enjoy","Apple",R.drawable.code));
        name.add(new Get_Items("Panda Enjoy","Apple",R.drawable.code));
        Product_Adapter adapter=new Product_Adapter(getContext(),name,R.color.grid_color);
        ListView listView=(ListView)view.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return view;
    }

}
