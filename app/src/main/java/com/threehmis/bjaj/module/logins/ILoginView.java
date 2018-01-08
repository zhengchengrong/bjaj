package com.threehmis.bjaj.module.logins;

import com.threehmis.bjaj.api.bean.BaseEntity;
import com.threehmis.bjaj.api.bean.LoginInfoBean;
import com.threehmis.bjaj.module.base.IBaseView;

/**ILoginView
 * Created by zhengchengrong on 2017/9/4.
 */

public interface ILoginView extends IBaseView{


    void toActivity(String loginInfoBean);

    void saveLoginInfo(BaseEntity<LoginInfoBean> loginInfoBean);
}
