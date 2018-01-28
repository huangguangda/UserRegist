package cn.edu.gdmec.android.userregist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener{

    private ItemInfo itemInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_shop );

        itemInfo = new ItemInfo ( "金剑", 100, 20, 20 );
        findViewById ( R.id.rl ).setOnClickListener ( this );

        TextView mlifeTV = (TextView) findViewById ( R.id.tv_life );
        TextView mNameTV = (TextView) findViewById ( R.id.tv_name );
        TextView mSpeedTV = (TextView) findViewById ( R.id.tv_speed );
        TextView mAttackTV = (TextView) findViewById ( R.id.tv_attack );

        //设置值
        mNameTV.setText ( itemInfo.getName ()+" " );

        mlifeTV.setText ( "生命值"+itemInfo.getLife () );
        mAttackTV.setText ( "攻击力"+itemInfo.getAcctack () );
        mSpeedTV.setText ( "敏捷度"+itemInfo.getSpeed () );

    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()){
            case R.id.rl:
                //创建意图对象
                Intent intent = new Intent (  );
                //存储数据到意图
                intent.putExtra ( "equipment",itemInfo );
                //把数据返回 第一个结果码
                setResult ( 1, intent );
                //把当前页面关闭
                finish ();

                break;
        }
    }
}
