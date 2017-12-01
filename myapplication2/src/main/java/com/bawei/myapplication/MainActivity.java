package com.bawei.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PullToRefreshListView plv;
    private LinkedList<News.DataBean> linkedList=new LinkedList<>();
    private ImageLoader imageLoader;
    private MAdapter mAdapter;
    String s1="http://120.27.23.105/product/getProducts?pscid=39&page=";
    int s2=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageLoader = ImageLoader.getInstance();
        plv = (PullToRefreshListView) findViewById(R.id.plv);
        mAdapter = new MAdapter();
        plv.setMode(PullToRefreshListView.Mode.BOTH);
        plv.setAdapter(mAdapter);
        new MAsyncTask().execute(s1+s2);
        plv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                linkedList.clear();
                new MAsyncTask().execute(s1+1);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                s2++;
                new MAsyncTask().execute(s1+s2);
            }
        });
    }

    class MAdapter extends BaseAdapter{

        int type1=0;
        int type2=1;
        @Override
        public int getCount() {
            return linkedList.size();
        }

        @Override
        public Object getItem(int i) {
            return linkedList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            return position%2;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            int j=i%2;
            if(j==type1){
                view = View.inflate(MainActivity.this, R.layout.layout1, null);
                TextView textView = view.findViewById(R.id.gname);
                textView.setText(linkedList.get(i).getTitle());
            }else{
                view = View.inflate(MainActivity.this, R.layout.layout2, null);
                TextView textView = view.findViewById(R.id.gname);
                ImageView imageView = view.findViewById(R.id.gimg);
                textView.setText(linkedList.get(i).getTitle());
                imageLoader.displayImage(linkedList.get(i).getImages(),imageView);

            }
            return view;
        }
    }
    class MAsyncTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            String string = strings[0];
           // Log.e("URL",string);
            String netjson = NetWordUtil.getNetjson(string);
          //  Log.e("TAG",netjson);
            return netjson;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson=new Gson();
            News news = gson.fromJson(s, News.class);
            List<News.DataBean> data = news.getData();
            linkedList.addAll(data);
            mAdapter.notifyDataSetChanged();
            plv.onRefreshComplete();
        }
    }

}
