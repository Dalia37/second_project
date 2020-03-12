package com.example.mypurchases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class type extends AppCompatActivity {
    RecyclerView rv ;
    TextView total_number , total_price  ;
    ArrayList<product> products = new ArrayList<product>();
    RecyclerViewAdapter adapter = new RecyclerViewAdapter (products);
    private AlertDialog.Builder builder;
    private EditText type , price;
    String type_name ,price_num;
    int total=0;
    int sum = 0;
    int range ,add ;
    price pr ;
    int cast;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type);
        rv= findViewById(R.id.rv);
        total_price=findViewById(R.id.total_price);
        total_number = findViewById(R.id.total_number);

        creat_Recycler();
        custom_action_bar();

    }

    public void show_aleart(View view) {
        intioatAleart();

        builder.show();

    }
    public  void intioatAleart(){

       builder = new AlertDialog.Builder(this);
       LayoutInflater inflater = getLayoutInflater();
        View view =inflater.inflate(R.layout.aleart_layout, null);
        builder.setView(view);
        type = view.findViewById(R.id.type_name);
         price =view.findViewById(R.id.price);


        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                price_num=price.getText().toString();
                type_name=type.getText().toString();

                if(price_num.isEmpty()|| type_name.isEmpty()){
                    Toast.makeText(type.this,getResources().getString(R.string.surefromyourtype), Toast.LENGTH_SHORT).show();


                }else {
                    product product = new product(type_name);
                    products.add(product);
                    range=++total;
                    total_number.setText((range)+ "");


                    int actual_price = Integer.parseInt(price_num);
                    pr=new price(actual_price);
                    add = actual_price+sum;
                    sum=add;
                    total_price.setText((add)+"");
                    adapter.notifyDataSetChanged();

                }




            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create();
    }
    public void creat_Recycler(){
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);
        new ItemTouchHelper(simpleCallback).attachToRecyclerView(rv);
        rv.setAdapter(adapter);
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            products.remove(viewHolder.getAdapterPosition());
            int r = --total;
            total_number.setText(r+"");

            cast =   add-pr.getPrice();
            total_price.setText((cast)+"");
            adapter.notifyDataSetChanged();




        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.red))
                    .addSwipeLeftActionIcon(R.drawable.delet)
                    .addSwipeLeftLabel(getResources().getString(R.string.delete))
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

        }
    };

    @SuppressLint("WrongConstant")
    public void custom_action_bar(){
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        View view2 = getSupportActionBar().getCustomView();
        TextView clear = findViewById(R.id.clear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rv.setAdapter(null);
                price_num=0+"";
                type_name=0+"";
                total_price.setText(price_num);
                total_number.setText(type_name);


            }
        });
    }

}

