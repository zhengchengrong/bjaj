package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;

public class MGetRectificationNotNotificationRsp implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * "pk":"402882b2594940830159494c60ef0001",
	 "acceptDate":null,
	 "acceptMan":null,
	 "answerDate":null,
	 "answerMan":null,
	 "answerNote":null,
	 "areaCode":null,
	 "checkDate":null,
	 "checkMan":null,
	 "checkNote":null,
	 "customerId":null,
	 "noticeName":null,
	 "noticeNO":"123456",
	 "noticeType":null,
	 "planReformDate":null,
	 "projectCode":"GUANGZJD00043",
	 "projectID":"40298a85513ccb660151563c395f0533",
	 "projectName":"金融城起步区AT090913(A005-2)地块项目（主体结构）",
	 "projectNum":"A2014000011L-1",
	 "questionNote":"问题描述",
	 "questionType":null,
	 "receiveDate":null,
	 "registerDate":null,
	 "registerMan":null,
	 "sendDate":null,
	 "sendMan":"签发人",
	 "status":"整改未回复",
	 "unitName":"广东省重工建筑设计院有限公司",
	 "updateDate":null,
	 "userId":null
	 */

	//通知书编号  检查日期 操作
	public String pk;
	public String noticeNO;
	public String planReformDate;
	public String projectID;
	public String isSubmit;


}
