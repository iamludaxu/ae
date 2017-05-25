package gift.witch.android.ae.recyclerview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;

public class RecyclerActivity extends BaseCompatActivity {




    private final String[] TITLE = new String[] { "base", "loadmore", "pull_and_loadmore" };
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        fragments.add(new BaseRecyclerFragment());
        fragments.add(new LoadMoreRecyclerFragment());
        fragments.add(new PullAndLoadMoreRecyclerFragment());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new TabPageIndicatorAdapter(getSupportFragmentManager()));
        //实例化TabPageIndicator然后设置ViewPager与之关联
        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(pager);







    }




    /**
    Handler mLoadMoreHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mBaseRecyclerAdapter.add();
            if(mBaseRecyclerAdapter.getItemCount()>100){
                mRecyclerView.setLoadMoreStatus(LoadMoreRecyclerView.STATUS_EMPTY);
            }else{
                mRecyclerView.setLoadMoreStatus(LoadMoreRecyclerView.STATUS_PREPARE);
            }
        }
    };
     */



    /**
     * ViewPager适配器
     * @author len
     *
     */
    class TabPageIndicatorAdapter extends  FragmentPagerAdapter{

        public TabPageIndicatorAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //新建一个Fragment来展示ViewPager item的内容，并传递参数
            return fragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLE[position % TITLE.length];
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
