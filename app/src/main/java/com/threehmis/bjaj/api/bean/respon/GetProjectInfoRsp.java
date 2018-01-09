package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;
import java.util.List;

public class GetProjectInfoRsp implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * projectID : 40298a85513ccb660151563c395f0533
	 * projectNum : A2014000011L-1
	 * projectCode : GUANGZJD00043
	 * projectName : 金融城起步区AT090913(A005-2)地块项目（主体结构）
	 * address : 广东省广州市天河区黄埔大道中
	 * projectType : 建筑
	 * structType : 框筒
	 * area : 163352
	 */

	public String projectID;
	public String projectNum;
	public String projectCode;
	public String projectName;
	public String address;
	public String projectType;
	public String structType;
	public String area;
	public String projectCost;
	public List<DataListBean> dataList;

	public static class DataListBean {
		/**
		 * type : 主要参建企业
		 * name : 广东省重工建筑设计院有限公司
		 * duty : 勘察单位
		 */

		public String type;
		public String name;
		public String duty;
	}
}
