package com.example.administrator.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        adapter = new Adapter();

        adapter.addItem(new SingerItem("선미", "010-1111-1111", 20, R.drawable.singer));
        adapter.addItem(new SingerItem("한지민", "010-2222-2222", 21, R.drawable.hanjimin));
        adapter.addItem(new SingerItem("디오", "010-3333-3333", 22, R.drawable.singer2));
        adapter.addItem(new SingerItem("박초롱", "010-4444-4444", 23, R.drawable.singer3));
        adapter.addItem(new SingerItem("설현", "010-5555-5555", 24, R.drawable.seolhyun));
        adapter.addItem(new SingerItem("이수혁", "010-6666-6666", 25, R.drawable.suhyuk));
        adapter.addItem(new SingerItem("지수", "010-7777-7777", 26, R.drawable.jisu));
        adapter.addItem(new SingerItem("하니", "010-8888-8888", 27, R.drawable.singer4));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택 : "+item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    class Adapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        public void addItem(SingerItem item) {
            items.add(item);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SingerItemView view = new SingerItemView(getApplicationContext());
            SingerItem item = items.get(position);
            view.setProfile(item.getResId());
            view.setName(item.getName());
            view.setPhone(item.getPhone());
            view.setAge(item.getAge());

            return view;
        }
    }
}
