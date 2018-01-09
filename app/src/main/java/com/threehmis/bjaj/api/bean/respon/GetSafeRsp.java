package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;
import java.util.List;

public class GetSafeRsp  {


	/**
	 *  "pk": "402882b259058ca40159058f20200000",
	 * "projectNum": "A2015000004L",
	 * "projectID": "40298a85513ccb660151563c395f0533",
	 "projectName": "金融城起步区AT090913(A005-2)地块项目（主体结构）",
	 "projectType": "建筑",
	 "checkDate": null,
	 "projectXXJD": "NULL",
	 "checkPart": "检查部位",
	 "dealOpinion": "处理意见",
	 "isReform": null
	 "checkDocument": null,
	 */

	public String pk;
	public String projectNum;
	public String projectID;
	public String projectName;
	public String projectType;
	public String projectXXJD;
	public String checkPart;
	public String dealOpinion;
	public String checkDate;
	public String isReform;
	public String checkDocument;
	public String checkContent;
	public String monitors;
	public int showZG;
//	抽查内容:checkContent 监督员 monitors　提交是否显示
//	showZG;   //“0” 显示　“1”　不显示

	public List<GetStopWorkRsp.FileListBean> fileList;

	public static class FileListBean implements Serializable {

		public String id;
		public String type;
		public String url;
	}


}
