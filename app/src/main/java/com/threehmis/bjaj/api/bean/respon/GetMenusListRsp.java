package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;
import java.util.List;

public class GetMenusListRsp implements Serializable {

	/**
	 * menuCode : APP-01-03
	 * menuNameShow : 安全监督
	 * menuUrl : assets/img/menu/安全监督.png
	 * parentCode : null
	 * orderId : 3
	 * interfaceType : 0 表示对内使用,1表示对外使用
	 */

	public String menuCode;
	public String menuNameShow;
	public String menuUrl;
	public String parentCode;
	public int orderId;
	public int interfaceType;
	public List<ChildListBean> childList;

	public static class ChildListBean implements Serializable {
		/**
		 * menuCode : APP-01-03-01
		 * menuNameShow : 行为登记
		 * menuUrl : assets/img/menu/小行为登记.png
		 * parentCode : APP-01-03
		 * orderId : 4
		 * interfaceType : 0
		 */

		public String menuCode;
		public String menuNameShow;
		public String menuUrl;
		public String parentCode;
		public int orderId;
		public String interfaceType;
	}
}
