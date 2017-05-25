package gift.witch.android.ae.recyclerview;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gift.witch.android.ae.R;

/**
 *
 * 利用SwipeRefreshLayout进行刷新
 * 
 */
public class BaseRecyclerFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private BaseRecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_baserecycler,null);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new RecyclerViewDecoration(getContext(), RecyclerViewDecoration.VERTICAL_LIST));

        mAdapter = new BaseRecyclerAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);


        /**
         * 判断滚动到最后就开始加载
         */
        mRecyclerView.addOnScrollListener(new EndLessOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                mEndHandler.sendEmptyMessageDelayed(0,3000);
            }
        });


        return view;
    }

    @Override
    public void onRefresh() {
        //mSwipeRefreshLayout.setRefreshing(true);
        mHandler.sendEmptyMessageDelayed(0, 3000);

    }


    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mSwipeRefreshLayout.setRefreshing(false);
        }
    };

    Handler mEndHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mAdapter.add();
        }
    };
}
