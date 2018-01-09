package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;

/**
 * 形象进度 返回bean
 */
public class GetFormScheduleRsp implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 *  projectXXJD 形象进度
	 *  projectPart  工程部位
	 */

	public String projectXXJD;
	public String projectPart;
	public String remark;
	public String updatedate;

}
