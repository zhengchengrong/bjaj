package com.threehmis.bjaj.api.bean.respon;

import java.util.List;

public class GetCheckQuestionHistoryRsp {


	/**
	 *  "pk": "402882b25929a7d3015929a80f960000",
	 "areaCode": null,
	 "checkType": "行为管理",
	 "customerId": null,
	 "dealNote": "整改",
	 "inspectionPK": "402882b2590b748101590b79cbb60000",
	 "questions": "占道施工未办理手续",
	 "questionType": "道及交通要道施工",
	 "receiveDate": 1482462597000,
	 "registerDate": 1482462597000,
	 "registerMan": null,
	 "remark": null,
	 "updateDate": 1482462597000,
	 "photoIds": ""
	 */

	public String questionType;
	public String pk;
	public String questions;
	public String dealNote;
	public String photoIds;
	public List<FilesBean> files;

	public static class FilesBean{
		public String id;
		public String type;
		public String url;
	}

}
