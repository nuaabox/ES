package com.easyeducation.bean.asks;

import java.util.ArrayList;
import java.util.List;

public class ASK {
	public String askId;
	public String question;
	public String answer;
	public String visitNum;
	public String messageNum;

	public ASK(String askId, String question, String answer, String visitNum,
			String messageNum) {
		super();
		this.question = question;
		this.answer = answer;
		this.visitNum = visitNum;
		this.messageNum = messageNum;
	}

	public static List<ASK> asksList() {

		List<ASK> asks = new ArrayList<ASK>();
		ASK ask = new ASK("123456", "小肠上皮细胞吸收葡萄糖，葡萄糖进出红细胞分别属于什么运输？",
				"主动运输，协助扩散。", "5", "2");
		asks.add(ask);
		ask = new ASK("123456", "小肠上皮细胞吸收葡萄糖，葡萄糖进出红细胞分别属于什么运输？", "主动运输，协助扩散。",
				"5", "2");
		asks.add(ask);
		ask = new ASK("123456", "小肠上皮细胞吸收葡萄糖，葡萄糖进出红细胞分别属于什么运输？", "主动运输，协助扩散。",
				"5", "2");
		asks.add(ask);
		ask = new ASK("123456", "小肠上皮细胞吸收葡萄糖，葡萄糖进出红细胞分别属于什么运输？", "主动运输，协助扩散。",
				"5", "2");
		asks.add(ask);
		ask = new ASK("123456", "小肠上皮细胞吸收葡萄糖，葡萄糖进出红细胞分别属于什么运输？", "主动运输，协助扩散。",
				"5", "2");
		asks.add(ask);

		return asks;

	};
}
