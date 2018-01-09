package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;
import java.util.List;

/**
 * 不良行为管理 返回bean
 */
public class GetBadHaviorRsp implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * pk : null
	 * areaCode : null
	 * customerId : null
	 * duty : null
	 * inspectDate : null
	 * personIDCard : null
	 * personName : null
	 * projectCode : null
	 * projectName : null
	 * projectNum : null
	 * punishCode : null
	 * punishNote : null
	 * punishObject : null
	 * punishSort : null
	 * punishType : null
	 * receiveDate : null
	 * recordNO : null
	 * registerDate : null
	 * registerDept : null
	 * registerMan : null
	 * remark : null
	 * status : 0
	 * unitID : null
	 * unitName : null
	 * unitType : null
	 * updatedate : null
	 * projectID : null
	 * unitList : [{"unitType":"勘察单位","unitName":"广东省重工建筑设计院有限公司","duty":"法定代表人,项目负责人,","name":"王健,陈志勇,"},{"unitType":"设计单位","unitName":"广东省建筑设计研究院","duty":"项目负责人,法定代表人,法定代表人,","name":"黄可,曾宪川,赏锦国,"},{"unitType":"监理单位","unitName":"广州市广州工程建设监理有限公司","duty":"总监理工程师,法定代表人,","name":"余维镇,喻东风,"},{"unitType":"施工单位","unitName":"中建三局第一建设有限责任公司","duty":"项目负责人,法定代表人,","name":"袁敬东,陈卫国,"},{"unitType":"建设单位","unitName":"广州市邦杰置业有限公司","duty":"经办人,项目负责人,法定代表人,","name":"张鹰,张鹰,余英,"}]
	 * isSubmit : null
	 */

	public String duty;
	public String inspectDate;
	public String personName;
	public String punishNote;
	public String actionLaw;//违反条纹
	public String punishObject;
	public String punishType;
	public String registerMan;
	public String unitName;
	public List<UnitListBean> unitList;

	public static class UnitListBean {
		/**
		 * unitType : 勘察单位
		 * unitName : 广东省重工建筑设计院有限公司
		 * duty : 法定代表人,项目负责人,
		 * name : 王健,陈志勇,
		 */

		public String unitType;
		public String unitName;
		public String duty;
		public String name;
	}
}
