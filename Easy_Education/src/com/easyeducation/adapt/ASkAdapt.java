package com.easyeducation.adapt;

import java.util.List;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.easyeducation.bean.asks.ASK;
import com.hwd.cw.test.R;

public class ASkAdapt extends BaseAdapter {

	private List<ASK> dataList;
	private Context ct;
	private ViewHolder holder;

	public ASkAdapt(List<ASK> dataList, Context ct) {
		this.dataList = dataList;
		this.ct = ct;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return null == dataList ? 0 : dataList.size();
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		return dataList.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		// TODO Auto-generated method stub
		return pos;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewgroup) {

		if (null == view) {
			holder = new ViewHolder();
			view = LayoutInflater.from(ct).inflate(R.layout.listview_item_ask,
					null);
			holder.question = (TextView) view
					.findViewById(R.id.lv_ask_question);
			holder.answer = (TextView) view.findViewById(R.id.lv_ask_answer);
			holder.visitNum = (TextView) view
					.findViewById(R.id.lv_ask_visitNum);
			holder.messageNum = (TextView) view
					.findViewById(R.id.lv_ask_messageNum);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		Spanned text = Html.fromHtml("<font color=#FB7097><b>" + "问："
				+ "</b></font>" + dataList.get(position).question);
		holder.question.setText(text);
		holder.answer.setText("答：" + dataList.get(position).answer);
		holder.visitNum.setText("游览" + dataList.get(position).visitNum + "次");
		holder.messageNum.setText(dataList.get(position).messageNum);
		return view;
	}

	class ViewHolder {
		TextView question;
		TextView answer;
		TextView visitNum;
		TextView messageNum;
	}

}
