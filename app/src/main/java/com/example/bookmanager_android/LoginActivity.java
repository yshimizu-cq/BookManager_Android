package com.example.bookmanager_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private View mFocusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFocusView = findViewById(R.id.loginView);
        mFocusView.requestFocus();

        //  【要対応】キーボード非表示機能の共通化（passwordEditViewもキーボード非表示処理）
        EditText emailEditView = (EditText) findViewById(R.id.emailEditText);
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

        //  アカウント新規作成画面に遷移
        Button singupButton = findViewById(R.id.signupButton);
        singupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  現在のActivity、遷移先のActivityを引数に入れてインスタンス生成
                Intent intent = new Intent(getApplication(), SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mFocusView.requestFocus();
        return super.onTouchEvent(event);
    }
}
