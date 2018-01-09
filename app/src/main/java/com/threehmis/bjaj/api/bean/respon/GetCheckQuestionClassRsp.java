package com.threehmis.bjaj.api.bean.respon;

import java.util.List;

public class GetCheckQuestionClassRsp {
	public List<TitleListBean> titleList;
	public List<QuestionListBean> questionList;

	public static class TitleListBean {
		/**
		 * projectBranch : 施工电梯
		 */

		public String projectBranch;
	}

	public static class QuestionListBean {
		/**
		 * type : 施工电梯
		 * questions : 基础承载力不足
		 * dealNote : 责令改正
		 * pk : AQSTQ01-01-01
		 * questionType : null
		 */

		public String type;
		public String questions;
		public String dealNote;
		public String pk;
		public String questionType;
	}

}
