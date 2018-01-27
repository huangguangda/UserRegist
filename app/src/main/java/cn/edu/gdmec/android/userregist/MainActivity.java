package cn.edu.gdmec.android.userregist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et_password;
    private Button btn_send;
    private EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        //获取相关控件
        et_name = (EditText) findViewById ( R.id.et_name );
        et_password = (EditText) findViewById ( R.id.et_password );
        btn_send = (Button) findViewById ( R.id.btn_send );
        //给按钮设置点击事件
        btn_send.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                //创建方法
                passDate();
            }
        } );

    }

    private void passDate() {
        //创建意图对象
        Intent intent = new Intent ( this,ShowActivity.class );
        //把数据存入intent
        intent.putExtra ( "name",et_name.getText ().toString ().trim () );
        intent.putExtra ( "password",et_password.getText ().toString ().trim () );

        //开启意图
        startActivity ( intent );

    }
}
