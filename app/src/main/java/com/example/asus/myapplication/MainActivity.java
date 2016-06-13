package com.example.asus.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //food button
        ImageButton food_bt = (ImageButton)findViewById(R.id.imageButton);
        food_bt.setOnClickListener(food_listener);

        ImageButton cloth_bt = (ImageButton)findViewById(R.id.imageButton2);
        cloth_bt.setOnClickListener(cloth_listener);

        ImageButton house_bt = (ImageButton)findViewById(R.id.imageButton3);
        house_bt.setOnClickListener(house_listener);

        ImageButton traffic_bt = (ImageButton)findViewById(R.id.imageButton4);
        traffic_bt.setOnClickListener(traffic_listener);

        ImageButton play_bt = (ImageButton)findViewById(R.id.imageButton5);
        play_bt.setOnClickListener(play_listener);

        ImageButton other_bt = (ImageButton)findViewById(R.id.imageButton6);
        other_bt.setOnClickListener(other_listener);
        //food button intend to class food
    }
    //food listener
    private ImageButton.OnClickListener food_listener = new ImageButton.OnClickListener(){
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, food.class);
            startActivity(intent);
        }
    };
    //cloth listener
    private Button.OnClickListener cloth_listener = new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,cloth.class);
            startActivity(intent);
        }
    };
    //house listener
    private Button.OnClickListener house_listener = new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,house.class);
            startActivity(intent);
        }
    };
    //traffic listener
    private Button.OnClickListener traffic_listener = new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,traffic.class);
            startActivity(intent);
        }
    };
    //play listener
    private Button.OnClickListener play_listener = new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,play.class);
            startActivity(intent);
        }
    };
    //other listener
    private Button.OnClickListener other_listener = new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,other.class);
            startActivity(intent);
        }
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
