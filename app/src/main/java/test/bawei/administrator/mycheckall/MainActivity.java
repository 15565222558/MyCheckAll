package test.bawei.administrator.mycheckall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private MyAdapter adapter;
    private Bean bean;
    private String[] str = new String[]{"大神戒律第1条", "大神戒律第2条", "大神戒律第3条"
            , "大神戒律第4条", "大神戒律第5条", "大神戒律第6条", "大神戒律第7条",
            "大神戒律第8条", "大神戒律第9条", "大神戒律第10条"};
    private Button yi;
    public boolean falg = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        lv = (ListView) findViewById(R.id.lv);
        yi = (Button) findViewById(R.id.yi);
        bean = new Bean();
        adapter = new MyAdapter(this, str, bean);
        //设置适配器
        lv.setAdapter(adapter);
    }

    //全选
    public void all(View view) {
        bean.isCheckbox = true;
        adapter.notifyDataSetChanged();
    }

    //隐藏 (--此效果只是实现了控件的隐藏,没有实现判断CheckBox的状态来隐藏--)
    public void yin(View view) {
        if (falg = !falg) {
            yi.setText("隐藏");
            lv.setVisibility(View.GONE);
        } else {
            yi.setText("显示");
            lv.setVisibility(View.VISIBLE);
        }
    }

    //全不选
    public void notall(View view) {
        bean.isCheckbox = false;
        adapter.notifyDataSetChanged();
        ;
    }

}
