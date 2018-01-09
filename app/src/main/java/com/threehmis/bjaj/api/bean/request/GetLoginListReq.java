package com.threehmis.bjaj.api.bean.request;


import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;

public class GetLoginListReq extends BaseBeanReq<GetLoginListRsp> {

//	phone=13808892360&password=123

	public String phone,password;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	@Override
//	public TypeReference<BaseBeanRsp<GetLoginListRsp>> myTypeReference() {
//		// TODO Auto-generated method stub
//		return new TypeReference<BaseBeanRsp<GetLoginListRsp>>() {
//		};
//	}

}
