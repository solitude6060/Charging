package com.example.asus.myapplication;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class other extends Activity {

    private TextView sqlstring;
    private EditText edday;
    private EditText ednum;
    private EditText edmoney;
    private Button add;
    private Button end;
    private Button clear;
    private static final String TAG = "mylog";

    //初始化db
    private SQLiteDatabase db = null;

    //_id欄位主要目的是唯一值會遞增，如果有兩筆資料一模一樣也會因為_id號碼不同而不會發生錯誤
    private static final String CREATE_TABLE = "CREATE TABLE table01(_id INTEGER PRIMARY KEY,day TEXT,num TEXT,money INTERGER )";
    private String sqls = "";
    private ListView listview01;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlpage);
        sqlstring = (TextView) findViewById(R.id.sqlstring);

        edday = (EditText) findViewById(R.id.edday);
        ednum = (EditText) findViewById(R.id.ednum);
        edmoney = (EditText) findViewById(R.id.edmoney);

        add = (Button) findViewById(R.id.add);
        end = (Button) findViewById(R.id.end);
        clear = (Button) findViewById(R.id.clear);
        listview01 = (ListView) findViewById(R.id.ListView01);

        //打開或是創造一個db
        db = openOrCreateDatabase("db", MODE_PRIVATE, null);
        try {
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {

            //如果打開或是創立db發生錯誤(還沒db.close())則讀取table01資料
            UpdataAdapter();
        }

        add.setOnClickListener(listener);
        end.setOnClickListener(listener);
        clear.setOnClickListener(listener);
    }

    private void UpdataAdapter() {
        // TODO Auto-generated method stub
        Cursor cursor = db.rawQuery("SELECT * FROM table01", null);
        if (cursor != null && cursor.getCount() >= 0) {
            //宣告SimpleCursorAdapter 去存放listview

            //似乎新版的sdk不建議使用此方法
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_2, cursor, new String[] {
                    "day", "num","money" }, new int[] { android.R.id.text1,
                    android.R.id.text1,android.R.id.text2});


            listview01.setAdapter(adapter);
        }

    }

    private OnClickListener listener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            switch (v.getId()) {
                case R.id.add:
                    //edit兩個輸入框其中一個為空
                    if (edday.getText().toString().equals("")
                            || ednum.getText().toString().equals("")) {
                        Log.d(TAG, "Add id = ");
                        Log.d(TAG, "Add day = ");
                        Log.d(TAG, "Add num = ");
                        Log.d(TAG, "Add money = ");
                    } else {
                        sqls = "INSERT INTO table01 (day,num,money) values('"
                                + edday.getText().toString() + "','"
                                + ednum.getText().toString() + "','"
                                + edmoney.getText().toString()+ "')";

                        String sqls2 = "消費日期,購買項目,花費金錢'("
                                + edday.getText().toString() + "','"
                                + ednum.getText().toString() + "','"
                                + edmoney.getText().toString()+ "')";

                        sqlstring.setText(sqls2);
                        try {
                            db.execSQL(sqls);

                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "SQL語法錯誤",
                                    Toast.LENGTH_SHORT).show();
                        }
                        UpdataAdapter();

                        Log.d(TAG, "Add day = " + edday.getText().toString());
                        Log.d(TAG, "Add num = " + ednum.getText().toString());
                        Log.d(TAG, "Add money = " + edmoney.getText().toString());
                    }

                    break;
                case R.id.clear:
                    db.execSQL("DROP TABLE table01");
                    //UpdataAdapter();
                    db.close();
                    finish();
                    break;
                case R.id.end:
                    finish();
            }

        }

    };

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        //關閉app十刪除table01
        //db.execSQL("DROP TABLE table01");
        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}