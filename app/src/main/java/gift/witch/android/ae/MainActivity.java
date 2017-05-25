package gift.witch.android.ae;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gift.witch.android.ae.animation.AnimationActivity;
import gift.witch.android.ae.base.BaseCompatActivity;
import gift.witch.android.ae.butterKnife.ButterKnifeActivity;
import gift.witch.android.ae.display.DisplayActivity;
import gift.witch.android.ae.draw.DrawActivity;
import gift.witch.android.ae.layout.LayoutActivity;
import gift.witch.android.ae.logger.LoggerActivity;
import gift.witch.android.ae.okhttp.OkHttpActivity;
import gift.witch.android.ae.recyclerview.RecyclerActivity;
import gift.witch.android.ae.retrofit2.Retrofit2Activity;
import gift.witch.android.ae.rxjava.RxJavaActivity;

/**
 *
 */
public class MainActivity extends Activity implements AdapterView.OnItemClickListener {


    private ListView mListViewLV;
    private ListViewAdapter mListViewAdapter;
    private static List<ListViewItemData> mData =new ArrayList<ListViewItemData>();

    static {
        /**
         * 例子列表
         */
        mData.add(new ListViewItemData("ButterKnife", ButterKnifeActivity.class));
        mData.add(new ListViewItemData("Logger", LoggerActivity.class));
        mData.add(new ListViewItemData("OkHttp",OkHttpActivity.class));
        mData.add(new ListViewItemData("Retrofit",Retrofit2Activity.class));
        mData.add(new ListViewItemData("RxJava",RxJavaActivity.class));
        mData.add(new ListViewItemData("Display",DisplayActivity.class));
        mData.add(new ListViewItemData("Layout",LayoutActivity.class));
        mData.add(new ListViewItemData("Draw",DrawActivity.class));
        mData.add(new ListViewItemData("Animation",AnimationActivity.class));
        mData.add(new ListViewItemData("RecyclerView",RecyclerActivity.class));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListViewLV = (ListView)findViewById(R.id.listview);
        mListViewAdapter = new ListViewAdapter();
        mListViewLV.setAdapter(mListViewAdapter);
        mListViewLV.setOnItemClickListener(this);

    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListViewItemData data = (ListViewItemData)parent.getItemAtPosition(position);
        BaseCompatActivity.start(this,data.title,data.classs);
    }


    private class ListViewAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null)
            {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.adapter_mainviewitem, null);
            }
            ListViewItemData data = mData.get(position);
            TextView title = (TextView)convertView.findViewById(R.id.title);
            title.setText(data.title);
            return convertView;
        }
    }

    private static class ListViewItemData{

        public ListViewItemData(String title,Class<?> classs){
            this.title = title;
            this.classs = classs;
        }

        public Class<?> classs;
        public String title;

    }
}
