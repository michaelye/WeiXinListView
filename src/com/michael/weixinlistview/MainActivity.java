package com.michael.weixinlistview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;


/**
 * 参考链接：
 * http://android.amberfog.com/?p=296
 * http://www.cnblogs.com/devinzhang/archive/2012/07/02/2573554.html
 * http://stackoverflow.com/questions/4777272/android-listview-with-different-layout-for-each-row
 * 
 * */
public class MainActivity extends Activity {

	private ListView lvData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lvData = (ListView)findViewById(R.id.lv_data);
		
		lvData.setAdapter(getAdapter());
	}

	private BaseAdapter getAdapter(){
		
		return new MyAdapter(this, getMyData());
	}
	
	private List<Message> getMyData(){
		
		List<Message> msgList = new ArrayList<Message>();
		Message msg;
		msg = new Message();
		msg.setType(MyAdapter.VALUE_LEFT_TEXT);
		msg.setValue("食堂真难吃啊");
		msgList.add(msg);
		
		msg = new Message();
		msg.setType(MyAdapter.VALUE_TIME_TIP);
		msg.setValue("2012-12-23 下午2:23");
		msgList.add(msg);
		
		msg = new Message();
		msg.setType(MyAdapter.VALUE_RIGHT_TEXT);
		msg.setValue("我就说食堂的饭难吃吧，你不相信！");
		msgList.add(msg);
		
		msg = new Message();
		msg.setType(MyAdapter.VALUE_LEFT_TEXT);
		msg.setValue("好吧，这次听你的了。");
		msgList.add(msg);
		
		msg = new Message();
		msg.setType(MyAdapter.VALUE_TIME_TIP);
		msg.setValue("2012-12-23 下午2:25");
		msgList.add(msg);
		
		msg = new Message();
		msg.setType(MyAdapter.VALUE_RIGHT_TEXT);
		msg.setValue("就要圣诞了，有什么安排没有？");
		msgList.add(msg);

		msg = new Message();
		msg.setType(MyAdapter.VALUE_LEFT_TEXT);
		msg.setValue("没有啊，你呢？");
		msgList.add(msg);
		
		msg = new Message();
		msg.setType(MyAdapter.VALUE_TIME_TIP);
		msg.setValue("2012-12-23 下午3:25");
		msgList.add(msg);
		
		msg = new Message();
		msg.setType(MyAdapter.VALUE_LEFT_IMAGE);
		msg.setValue("7min");
		msgList.add(msg);
		
		msg = new Message();
		msg.setType(MyAdapter.VALUE_RIGHT_TEXT);
		msg.setValue("高帅富有三宝 木耳 跑车 和名表，" +
				"黑木耳有三宝 美瞳 备胎 黑丝脚 ，穷矮挫有三宝 AV 手纸 射得早 ，女神有三宝 干嘛 呵呵 去洗澡 ，宅男有三宝 Dota 基友 破电脑 " +
				"女屌丝有三宝 虎背 熊腰 眼睛小 ， 女屌丝还有三宝 饼脸 花痴 卖萌照");
		msgList.add(msg);
		
		msg = new Message();
		msg.setType(MyAdapter.VALUE_LEFT_TEXT);
		msg.setValue("碉堡了");
		msgList.add(msg);
		
		msg = new Message();
		msg.setType(MyAdapter.VALUE_LEFT_AUDIO);
		msg.setValue("7min");
		msgList.add(msg);
		
		msg = new Message();
		msg.setType(MyAdapter.VALUE_RIGHT_IMAGE);
		msg.setValue("7min");
		msgList.add(msg);
		
		return msgList;
		
	}
	
	
}

