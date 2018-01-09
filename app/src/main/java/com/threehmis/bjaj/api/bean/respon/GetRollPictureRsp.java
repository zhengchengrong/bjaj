package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;

public class GetRollPictureRsp implements Serializable {
	
//	"newsid": "50720",
//    "title": "中国送英国夏洛特小公主的周岁礼物曝光",
//    "notes": "夏洛特小公主在英国夏洛特小公主一岁生日之际，肯辛顿宫公开了过去一年里小公主收到的礼物清单。清单显示，她收到了来自全球64个国家和地区的礼物，包括小毯子、衣服、卡片、书、玩具、手工编织的小靴子，其中还有一个来自中国的以红楼梦人物为原型的丝质娃娃。奥巴马夫妇送给小公主的“厚礼”别看这些",
//    "articletype": "0",
//    "linktype": "0",
//    "breviaryimges": "http://www.zzwb.cn/Picture/20160504/6359795943522965572129533_400x187.jpg",
//    "connectid": 0
//	connecturl

	public int newsid, articletype, linktype, connectid;

	public String title, notes, breviaryimges,connecturl;


}
