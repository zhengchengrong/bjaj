package com.threehmis.bjaj.api.bean.request;

public class GetMainAddressReq {

/*	[]里面的数据表示是否可选项
1.接口地址：http://192.168.2.219:8080/app/monitorunit/getMonitorunit
	接口：根据省和市查询所有监督站
	参数：params={"province":"省","city":"市"}
	返回数据:监督的Bean

	测试参数:params={"province":"广东省","city":"广州市"}

	params={"province":"江西省","city":"南昌市"}


[]里面的数据表示是否可选项
2.接口地址：http://192.168.2.219:8080/app/monitorunit/findByUnitName
	接口：根据监督站名称查询监督站
	参数：params={"unitName":"模糊监督站名称"}
	返回数据:监督的Bean

	测试参数:params={"unitName":"广州市"}
	*/
	public String province,city,unitName;



}
