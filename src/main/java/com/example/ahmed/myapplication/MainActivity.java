package com.example.ahmed.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView ;

    ArrayList<String> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView =(ListView)findViewById(R.id.listView);




        list.add("ahmed");
        list.add("kamal");
        list.add("eslam");
        list.add("ahmed");

        MyAdapter adapter = new MyAdapter(list);


        listView.setAdapter(adapter);
    }



    private class MyAdapter extends BaseAdapter{


        ArrayList<String> Data = new ArrayList<>();

        MyAdapter( ArrayList<String> list){

            Data = list ;
        }



        @Override
        public int getCount() {

            return Data.size();
        }

        @Override
        public Object getItem(int position) {

            return Data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {


            LayoutInflater inflater = getLayoutInflater();

            View myView =inflater.inflate(R.layout.listview_layout,parent,false);

            TextView t1 = (TextView) myView.findViewById(R.id.textView2);

            Button b1 = (Button) myView.findViewById(R.id.button);

            final String name = Data.get(position);

            t1.setText(name);


            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    remove(position);



                }
            });


            return  myView;

        }
    }


    public void remove(int i){

        list.remove(i);

        MyAdapter adapter = new MyAdapter(list);


        listView.setAdapter(adapter);
    }


    public void check(View v){

        int sum=0;

        for (int i=0; i<listView.getCount() ;i++){

            View view = listView.getChildAt(i) ;

            CheckBox check = (CheckBox)view.findViewById(R.id.checkBox);

            if (check.isChecked()){
                sum++;
            }



        }

        Toast.makeText(this,String.valueOf(sum),Toast.LENGTH_SHORT).show();
    }
}
