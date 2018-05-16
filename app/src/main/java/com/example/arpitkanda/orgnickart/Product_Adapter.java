package com.example.arpitkanda.orgnickart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Arpit Kanda on 15-May-18.
 */

public class Product_Adapter extends ArrayAdapter<Get_Items> {
    private int mcolor;
    TextView qty_plus;
    TextView qty_minus;
    TextView qty;
    int number = 0;

    public Product_Adapter(Context context, ArrayList<Get_Items> words, int colorID) {
        super(context, 0, words);
        mcolor = colorID;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.product_list, parent, false);

        }
//        qty = (TextView) listView.findViewById(R.id.qty);
//        qty_plus = (TextView) listView.findViewById(R.id.qty_plus);
//        qty_minus = (TextView) listView.findViewById(R.id.qty_minus);
//        qty_plus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                number = number + 1;
//                qty.setText(String.valueOf(number));
//            }
//        });
//        qty_minus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                number = number - 1;
//                qty.setText(String.valueOf(number));
//            }
//        });
        Get_Items word = getItem(position);
        TextView name = (TextView) listView.findViewById(R.id.all_names);
        name.setText(word.getNames());
        TextView sub_name = (TextView) listView.findViewById(R.id.all_sub_name);
        sub_name.setText(word.getSubNames());
        TextView sub_names = (TextView) listView.findViewById(R.id.all_sub_name);
        ImageView imageView = (ImageView) listView.findViewById(R.id.product_images_id);
        imageView.setImageResource(word.getImage());
//        qtyPlus();
//        qtyMinus();
        return listView;
    }

    public void qtyPlus() {
        qty_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = number + 1;
                qty.setText(String.valueOf(number));
            }
        });
    }

    public void qtyMinus() {
        qty_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = number - 1;
                qty.setText(String.valueOf(number));
                if (number == 0) {
                    number = 0;
                }
            }
        });
    }
}
