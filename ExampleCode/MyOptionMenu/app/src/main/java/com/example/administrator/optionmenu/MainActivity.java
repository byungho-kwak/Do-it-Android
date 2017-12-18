package com.example.administrator.optionmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.administrator.optionmenu.R.id.search;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // 메뉴아이템들 중에서 검색을 위해 정의한 아이템을 뷰 객체로 참조
        View v = menu.findItem(search).getActionView();
        if(v!=null) {
            // 검색을 위해 입력 상자 객체 참조
            editText = (EditText) v.findViewById(R.id.menu_edittext);
            // 입력상자 객체의 리스너 설정
            editText.setOnEditorActionListener(onSearchListener);
        }
        return true;
    }

    private TextView.OnEditorActionListener onSearchListener = new TextView.OnEditorActionListener() {
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                input = editText.getText().toString().trim();
                if(input.equals(""))
                    input=new String("입력값이 없습니다");

                Toast.makeText(getApplicationContext(), input, Toast.LENGTH_SHORT).show();
                editText.setText("");
                return true;
            }
            return false;
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,"옵션 들어옴", Toast.LENGTH_SHORT).show();
        int curId = item.getItemId();
        switch (curId) {

            case R.id.refresh:
                Toast.makeText(this, "새로고침 버튼 클릭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "셋팅 버튼 클릭", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


}
