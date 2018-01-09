package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;
import java.util.List;

/**
 * 不良行为管理 返回bean
 */
public class GetInspectionRsp {


	/**
	 * pk : f8ccb5bc5c18fbbe015c1ee0af0e0002
	 * projectCode : null
	 * projectID : 402881825697bd850156e8699e7402a7
	 * projectPart : null
	 * projectXXJD : null
	 * projectType : null
	 * projectName : null
	 * projectNum : null
	 * monitors : null
	 * customerId : null
	 * registerDate : null
	 * registerMan : null
	 * userId : null
	 * isSubmit : null
	 * updateDate : null
	 * checkDate : null
	 * acceptDate": "2017-02-01",
	 */

	public String pk;
	public Object projectCode;
	public String projectID;
	public Object projectPart;
	public Object projectXXJD;
	public Object projectType;
	public String projectName;
	public String projectNum;
	public String monitors;
	public Object customerId;
	public Object registerDate;
	public Object registerMan;
	public Object userId;
	public int isSubmit;
	public Object updateDate;
	public String checkDate;
	public String acceptDate;
	public List<GetStopWorkRsp.FileListBean> fileList;

	public static class FileListBean implements Serializable {

		public String id;
		public String type;
		public String url;
	}
}
