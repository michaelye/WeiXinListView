package com.michael.weixinlistview;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * 想比较原来的多了getItemViewType和getViewTypeCount这两个方法，原来循环使用layout布局，起到了优化的作用
 * 
 * 
 * */
public class MyAdapter extends BaseAdapter{

	
	public static final String KEY = "key";
	public static final String VALUE = "value";
	
	public static final int VALUE_TIME_TIP = 0;//7种不同的布局
	public static final int VALUE_LEFT_TEXT = 1;
	public static final int VALUE_LEFT_IMAGE = 2;
	public static final int VALUE_LEFT_AUDIO = 3;
	public static final int VALUE_RIGHT_TEXT = 4;
	public static final int VALUE_RIGHT_IMAGE = 5;
	public static final int VALUE_RIGHT_AUDIO = 6;
	private LayoutInflater mInflater;
	
	private Context context;
	private List<Message> myList;
	public MyAdapter(Context context, List<Message> myList){
		
		this.context = context;
		this.myList = myList;
		
		for(Message msg:myList){
			
			Log.d("myList:", msg.getType()+"");
		}
		
		mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public void addItem(final Message item) {
		myList.add(item);
        notifyDataSetChanged();
    }
	
	@Override
	public int getCount() {
		return myList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return myList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		
		Message msg = myList.get(position);
		int type = getItemViewType(position);
		ViewHolder holder = null;
		if(convertView == null){
			
			holder = new ViewHolder();
				switch (type) {
					case VALUE_TIME_TIP:
						
						convertView = mInflater.inflate(R.layout.list_item_time_tip, null);
						holder.tvTimeTip = (TextView)convertView.findViewById(R.id.tv_time_tip);
						holder.tvTimeTip.setText(msg.getValue());
						break;
								//左边
					case VALUE_LEFT_TEXT:
						
						convertView = mInflater.inflate(R.layout.list_item_left_text, null);
						holder.ivLeftIcon = (ImageView)convertView.findViewById(R.id.iv_icon);
						holder.btnLeftText = (Button)convertView.findViewById(R.id.btn_left_text);
						holder.btnLeftText.setText(msg.getValue());
						break;
						
					case VALUE_LEFT_IMAGE:
						
						convertView = mInflater.inflate(R.layout.list_item_left_iamge, null);
						holder.ivLeftIcon = (ImageView)convertView.findViewById(R.id.iv_icon);
						holder.ivLeftImage = (ImageView)convertView.findViewById(R.id.iv_left_image);
						holder.ivLeftImage.setImageResource(R.drawable.test);
						break;
						
					case VALUE_LEFT_AUDIO:
	
						convertView = mInflater.inflate(R.layout.list_item_left_audio, null);
						holder.ivLeftIcon = (ImageView)convertView.findViewById(R.id.iv_icon);
						holder.btnLeftAudio = (Button)convertView.findViewById(R.id.btn_left_audio);
						holder.tvLeftAudioTime = (TextView)convertView.findViewById(R.id.tv_left_audio_time);
						holder.tvLeftAudioTime.setText(msg.getValue());
						break;
								//右边
					case VALUE_RIGHT_TEXT:
						
						convertView = mInflater.inflate(R.layout.list_item_right_text, null);
						holder.ivRightIcon = (ImageView)convertView.findViewById(R.id.iv_icon);
						holder.btnRightText = (Button)convertView.findViewById(R.id.btn_right_text);
						holder.btnRightText.setText(msg.getValue());
						break;
						
					case VALUE_RIGHT_IMAGE:
						
						convertView = mInflater.inflate(R.layout.list_item_right_iamge, null);
						holder.ivRightIcon = (ImageView)convertView.findViewById(R.id.iv_icon);
						holder.ivRightImage = (ImageView)convertView.findViewById(R.id.iv_right_image);
						holder.ivRightImage.setImageResource(R.drawable.test);
						break;
						
					case VALUE_RIGHT_AUDIO:
	
						convertView = mInflater.inflate(R.layout.list_item_right_audio, null);
						holder.ivRightIcon = (ImageView)convertView.findViewById(R.id.iv_icon);
						holder.btnRightAudio = (Button)convertView.findViewById(R.id.btn_right_audio);
						holder.tvRightAudioTime = (TextView)convertView.findViewById(R.id.tv_right_audio_time);
						holder.tvRightAudioTime.setText(msg.getValue());
						break;
						
					default:
						break;
				}
				convertView.setTag(holder);
			}else{
				holder = (ViewHolder)convertView.getTag();
			}
			return convertView;
		}
	
	/**
	 * 根据数据源的position返回需要显示的的layout的type
	 * 
	 * */
	@Override
	public int getItemViewType(int position) {
		
		Message msg = myList.get(position);
		int type = msg.getType();
		Log.e("TYPE:", ""+type);
		return type;
	}

	/**
	 * 返回所有的layout的数量
	 * 
	 * */
	@Override
	public int getViewTypeCount() {
		return 7;
	}
	
	class ViewHolder{
		
		private TextView tvTimeTip;//时间
		
		private ImageView ivLeftIcon;//左边的头像
		private Button btnLeftText;//左边的文本
		private ImageView ivLeftImage;//左边的图像
		private Button btnLeftAudio;//左边的声音
		private TextView tvLeftAudioTime;//左边的声音时间
		
		private ImageView ivRightIcon;//右边的头像
		private Button btnRightText;//右边的文本
		private ImageView ivRightImage;//右边的图像
		private Button btnRightAudio;//右边的声音
		private TextView tvRightAudioTime;//右边的声音时间
	}

}




























