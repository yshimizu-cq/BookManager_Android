package com.example.bookmanager_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private View mFocusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFocusView = findViewById(R.id.focusView);
        mFocusView.requestFocus();

        //  【要対応】キーボード非表示機能の共通化（passwordEditViewもキーボード非表示処理）
        EditText emailEditView = (EditText) findViewById(R.id.emailEditView);
        emailEditView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    //  フォーカスが外れた場合、キーボードを非表示にする
                    InputMethodManager inputMethodMgr = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    inputMethodMgr.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mFocusView.requestFocus();
        return super.onTouchEvent(event);
    }
}
