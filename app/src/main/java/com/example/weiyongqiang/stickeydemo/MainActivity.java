package com.example.weiyongqiang.stickeydemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.weiyongqiang.stickeydemo.adapter.TestAdapter;
import com.example.weiyongqiang.stickeydemo.bean.TestEntity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity
{

	private RecyclerView		mRecyclerView;
	private List<TestEntity>	mList	= new ArrayList<>();

	private LinearLayout		hideLinearLayout;

	private TestAdapter			adapter;
	private AppCompatTextView	hideName;
	private View				headview;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initTestData();
		initView();

	}

	/**
	 * 初始化测试数据 需要和后台约定好数据返回格式
	 */
	public void initTestData()
	{
		mList.add(new TestEntity("0", "2018-12-25", ""));
		mList.add(new TestEntity("1", "2018-12-25", "TestData1"));
		mList.add(new TestEntity("1", "2018-12-25", "TestData2"));
		mList.add(new TestEntity("1", "2018-12-25", "TestData3"));
		mList.add(new TestEntity("1", "2018-12-25", "TestData4"));
		mList.add(new TestEntity("1", "2018-12-25", "TestData5"));

		mList.add(new TestEntity("0", "2018-12-26", ""));
		mList.add(new TestEntity("1", "2018-12-26", "TestData1"));
		mList.add(new TestEntity("1", "2018-12-26", "TestData2"));
		mList.add(new TestEntity("1", "2018-12-26", "TestData3"));
		mList.add(new TestEntity("1", "2018-12-26", "TestData4"));
		mList.add(new TestEntity("1", "2018-12-26", "TestData5"));
		mList.add(new TestEntity("1", "2018-12-26", "TestData6"));
		mList.add(new TestEntity("1", "2018-12-26", "TestData7"));
		mList.add(new TestEntity("1", "2018-12-26", "TestData8"));
		mList.add(new TestEntity("1", "2018-12-26", "TestData9"));
		mList.add(new TestEntity("1", "2018-12-26", "TestData10"));
		mList.add(new TestEntity("1", "2018-12-26", "TestData11"));

		mList.add(new TestEntity("0", "2018-12-27", ""));
		mList.add(new TestEntity("1", "2018-12-27", "TestData1"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData2"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData3"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData4"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData5"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData1"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData2"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData3"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData4"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData5"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData1"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData2"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData3"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData4"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData5"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData1"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData2"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData3"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData4"));
		mList.add(new TestEntity("1", "2018-12-27", "TestData5"));

	}

	@SuppressLint("WrongConstant")
	public void initView()
	{
		headview = LayoutInflater.from(this).inflate(R.layout.financial_header, null, false);
		for (int i = 0; i < mList.size(); i++)
		{
			// 表示头布局
			if (mList.get(i).getType().equals("0"))
			{
				mList.get(i).setItemType(TestEntity.HEAD_TYPE);
			}
			else
			{
				mList.get(i).setItemType(TestEntity.ITEM_TYPE);

			}
		}

		adapter = new TestAdapter(mList);

		hideLinearLayout = findViewById(R.id.hideLinearLayout);

		hideName = findViewById(R.id.hideName);
		LinearLayoutManager manager = new LinearLayoutManager(this);
		manager.setOrientation(LinearLayoutManager.VERTICAL);
		mRecyclerView = findViewById(R.id.recyclerView);
		mRecyclerView.setLayoutManager(manager);
		mRecyclerView.setAdapter(adapter);
		adapter.setHeaderView(headview);

		mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
		{
			@Override
			public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy)
			{
				super.onScrolled(recyclerView, dx, dy);
				int position = manager.findFirstVisibleItemPosition();
				Log.e("position", position + "--");
				if (position > 0)
				{
					hideLinearLayout.setVisibility(View.VISIBLE);
					hideName.setText(adapter.getItem(position).getHeadName() + "");
				}
				else
				{
					hideLinearLayout.setVisibility(View.GONE);

				}

			}
		});

	}
}
