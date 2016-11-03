package test.bawei.administrator.mycheckall;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/2.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private String[] str;
    private Bean bean;

    public MyAdapter(Context context, String[] str, Bean bean) {
        this.context = context;
        this.str = str;
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return str.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            //( ViewGroup root)null是一个视图 因为已经加载了一个布局,所以不需要在写一个视图
            view = View.inflate(context, R.layout.list, null);
            //设置控件
            holder.title = (TextView) view.findViewById(R.id.t);
            holder.box = (CheckBox) view.findViewById(R.id.box);
            //给容器 设置一个标记
            view.setTag(holder);
        } else {
            //取出相应的标记
            holder = (ViewHolder) view.getTag();
        }
        holder.title.setText(str[position]);
        holder.box.setChecked(bean.isCheckbox);
        //监听Chebox事件
        holder.box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bean.isCheckbox) {
                    bean.isCheckbox = false;
                } else {
                    bean.isCheckbox = true;
                }
            }
        });
        return view;
    }

    //优化
    class ViewHolder {
        TextView title;
        CheckBox box;
    }
}
