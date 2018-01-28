package cn.edu.gdmec.android.userregist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    private ProgressBar mProgressBar1;
    private ProgressBar mProgressBar2;
    private ProgressBar mProgressBar3;
    private TextView mLifeTV;
    private TextView mAttackTV;
    private TextView mSpeedTV;

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

        tv_name.setText ( "用户名:"+name );
        tv_password.setText ( "密  码:"+password );

        mLifeTV = (TextView) findViewById ( R.id.tv_life_progress );
        mAttackTV = (TextView ) findViewById ( R.id.tv_attack_progress );
        mSpeedTV = (TextView ) findViewById ( R.id.tv_speed_progress );


        //初始化进度条
        initProgress();

    }

    private void initProgress() {
        //初始化进度条控件
        mProgressBar1 = (ProgressBar) findViewById ( R.id.progressBar1 );
        mProgressBar2 = (ProgressBar) findViewById ( R.id.progressBar2 );
        mProgressBar3 = (ProgressBar) findViewById ( R.id.progressBar3 );
        //设置进度条的最大值
        mProgressBar1.setMax ( 100 );
        mProgressBar2.setMax ( 100 );
        mProgressBar3.setMax ( 100 );

    }
    //点击按钮，去购买准备
    public void click(View v){
        Intent intent = new Intent ( this,ShopActivity.class );
        startActivityForResult ( intent,1 );

    }

    //当开启的Activity页面关闭的时候执行
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data!=null){
            if (requestCode==1){
                if (resultCode==1){
                    //获取上一个页面返回的数据
                    ItemInfo info = (ItemInfo) data.getSerializableExtra ( "equipment" );
                    //更新ui
                    updateProgress(info);
                }
            }
        }
        super.onActivityResult ( requestCode, resultCode, data );
    }

    //更新Progressbar的值
    private void updateProgress(ItemInfo info) {
        int progress1 = mProgressBar1.getProgress ();
        int progress2 = mProgressBar2.getProgress ();
        int progress3 = mProgressBar3.getProgress ();

        mProgressBar1.setProgress ( progress1+info.getLife () );
        mProgressBar2.setProgress ( progress2+info.getAcctack () );
        mProgressBar3.setProgress ( progress3+info.getSpeed () );

        mLifeTV.setText ( mProgressBar1.getProgress ()+" " );
        mAttackTV.setText ( mProgressBar2.getProgress ()+" " );
        mSpeedTV.setText ( mProgressBar3.getProgress ()+" " );

    }
}
