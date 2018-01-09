package com.threehmis.bjaj.module.logins;

import com.threehmis.bjaj.api.bean.BaseBeanRsp;
import com.threehmis.bjaj.api.bean.BaseEntity;
import com.threehmis.bjaj.api.bean.LoginInfoBean;
import com.threehmis.bjaj.api.bean.respon.GetLoginListRsp;
import com.threehmis.bjaj.module.base.IBaseView;

/**ILoginView
 * Created by zhengchengrong on 2017/9/4.
 */

public interface ILoginView extends IBaseView{



    // 登陆成功
    void successLogin(BaseBeanRsp<GetLoginListRsp> loginInfoBean);

    // 登陆失败
    void errorLogin();

}
