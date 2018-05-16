package com.example.arpitkanda.orgnickart;


public class Get_Items {

    private String product_name;
    private String sub_names;
    private int images;
    public Get_Items(String item_names,String item_sub_names,int item_images){
        product_name=item_names;
        sub_names=item_sub_names;
        images=item_images;
    }
    public String getNames(){
        return product_name;
    }
        public String getSubNames(){
        return sub_names;
    }
    public int getImage(){
        return images;
    }

   }
