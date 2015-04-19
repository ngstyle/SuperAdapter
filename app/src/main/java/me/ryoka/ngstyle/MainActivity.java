package me.ryoka.ngstyle;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import me.ryoka.ngstyle.utils.SuperAdapter;
import me.ryoka.ngstyle.view.CustomView;


public class MainActivity extends ActionBarActivity {
    private CustomView customView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        customView = (CustomView)findViewById(R.id.customview);

        List<String> mDatas = new ArrayList<>();
        for (int i = 0;i < 100 ; i++){
            mDatas.add("item position:" + i);
        }

        listView = (ListView) findViewById(R.id.listview);
/*        listView.setAdapter(new SuperBaseAdapter<String>(MainActivity.this,mDatas,R.layout.listview_item) {
            @Override
            protected void convert(ViewHolder holder, String s) {
                holder.setText(R.id.tv_text,s);
            }
        });*/

        listView.setAdapter(new SuperAdapter<String>(MainActivity.this,mDatas,R.layout.listview_item){

            @Override
            public void convert(String s) {
                setText(R.id.tv_text,s);
            }
        });

//        new Thread(customView).start();
    }

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
