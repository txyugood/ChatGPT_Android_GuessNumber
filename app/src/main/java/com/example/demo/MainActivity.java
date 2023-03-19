package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // UI控件
    private TextView tvTitle, tvResult;
    private EditText etGuess;
    private Button btnGuess, btnReset;

    // GameController对象
    private GameController gameController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化UI控件
        tvTitle = findViewById(R.id.tv_title);
        tvResult = findViewById(R.id.tv_result);
        etGuess = findViewById(R.id.et_guess);
        btnGuess = findViewById(R.id.btn_guess);
        btnReset = findViewById(R.id.btn_reset);

        // 设置按钮点击监听器
        btnGuess.setOnClickListener(this);
        btnReset.setOnClickListener(this);

        // 创建GameController对象
        gameController = new GameController();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_guess:
                // 获取玩家输入的猜测值
                String guess = etGuess.getText().toString();
                // 调用GameController对象的guess方法进行猜测并返回结果
                String result = gameController.guess(guess);
                // 将结果显示在TextView上
                tvResult.setText(result);
                // 显示结果TextView并显示重置按钮
                tvResult.setVisibility(View.VISIBLE);
                btnReset.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_reset:
                // 重置EditText、TextView、GameController
                etGuess.setText("");
                tvResult.setText("");
                tvResult.setVisibility(View.GONE);
                btnReset.setVisibility(View.GONE);
                gameController.reset();
                break;
            default:
                break;
        }
    }
}
