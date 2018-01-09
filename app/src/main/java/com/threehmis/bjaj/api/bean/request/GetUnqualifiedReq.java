package com.threehmis.bjaj.api.bean.request;

import com.ydzf.hhh.hhh_ydzf.responbean.GetUnqualifiedRsp;

public class GetUnqualifiedReq extends BaseBeanReq<GetUnqualifiedRsp> {

//	52.接口地址：http://192.168.2.50:8080/app/projectTj/etlByTj
//	接口：工程 抽检情况统计
//	参数 params={"projectId":"P000007492","itemName":"混凝土抗压试验"}
//
//53.接口地址：http://192.168.2.50:8080/app/projectTj/findAllItemName
//		接口：工程 抽检情况类型
//		参数 params={"projectId":"P000007492"}

	public Object projectId,itemName;

//	@Override
//	public TypeReference<BaseBeanRsp<GetUnqualifiedRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetUnqualifiedRsp>>() {
//		};
//	}

}
