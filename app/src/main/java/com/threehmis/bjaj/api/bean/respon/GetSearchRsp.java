package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;

public class GetSearchRsp implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * projectID : P000002903
	 * projectGpsX : 0
	 * projectGpsY : 0
	 */

	public String projectID;
	public float projectGpsX;
	public float projectGpsY;
	public String projectName;
	public String userId;
	public String address;

}
