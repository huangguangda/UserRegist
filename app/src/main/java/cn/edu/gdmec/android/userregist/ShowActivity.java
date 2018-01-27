package cn.edu.gdmec.android.userregist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_show );

        //获取开启次页面的意图对象
        Intent intent = getIntent ();
        //根据key，去除对应的value的值
        String name = intent.getStringExtra ( "name" );
        String password = intent.getStringExtra ( "password" );

        //把用户名和密码显示在控件上
        TextView tv_name = (TextView) findViewById ( R.id.tv_name );
        TextView tv_password = (TextView) findViewById ( R.id.tv_password );

        tv_name.setText ( name );
        tv_password.setText ( password );
    }
}
