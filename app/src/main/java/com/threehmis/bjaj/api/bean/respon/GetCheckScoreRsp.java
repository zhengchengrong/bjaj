package com.threehmis.bjaj.api.bean.respon;

import java.util.List;

public class GetCheckScoreRsp {

	public List<ScoreListBean> scoreList;
	public List<TitleListBean> titleList;

	public static class ScoreListBean {
		/**
		 * type : 安全生产责任制（5分）
		 * itemName : 未建立安全生产责任制，扣5分
		 * scoreValue : 5
		 * checkScore : 0
		 * baseItemPk : AQGL01-01
		 * checkType : 行为管理
		 * pk : null
		 */
		public String type;
		public String itemName;
		public int scoreValue;
		public int checkScore;
		public String baseItemPk;
		public String checkType;
		public String pk;
	}

	public static class TitleListBean {
		/**
		 * itemName : 安全生产责任制（5分）
		 * pk : AQGL01
		 */

		public String itemName;
		public String pk;
	}


}
