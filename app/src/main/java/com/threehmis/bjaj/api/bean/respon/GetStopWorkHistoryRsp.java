package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;

public class GetStopWorkHistoryRsp implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 *"checkDate": null,
	 "customerId": null,
	 "projectCode": "GUANGZJD00043",
	 "projectID": "40298a85513ccb660151563c395f0533",
	 "projectName": "金融城起步区AT090913(A005-2)地块项目（主体结构）",
	 "projectNum": "A2014000011L-1",
	 "projectPart": "具体施工部位",
	 "projectXXJD": "形象进度",
	 "receiveDate": 1482468843000,
	 "reformDate": null,
	 "reformNote": "整改内容",
	 "remark": null,
	 "restartDate": "2016-11-11",
	 "restartNO": "123",
	 "restartSendDate": null,
	 "restartSendMan": null,
	 "stopNO": "123",
	 "stopReason": "停工原因",
	 "stopSendDate": "2016-11-11",
	 "stopSendMan": "黄少英",
	 "stopType": "停工",
	 "unitName": "通知企业",
	 "updateDate": null,
	 */

	public String pk,projectID,stopType,projectPart,stopSendDate,restartDate,isStopSubmit,isRecordSubmit;
}
