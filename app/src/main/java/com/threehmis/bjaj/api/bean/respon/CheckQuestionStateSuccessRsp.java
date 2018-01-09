package com.threehmis.bjaj.api.bean.respon;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/7/27 0027.
 */
public class CheckQuestionStateSuccessRsp {


    /**
     * questionPk : 402882b2599697eb0159969c63cb0000
     * files : [{"id":"587879fdbbea8916f4d1fb9c","type":null}]
     */

    public String pk;
    public String questionPk;
    public String photoIds;
    public List<FilesBean> files;

    public static class FilesBean implements Serializable {
        /**
         * id : 587879fdbbea8916f4d1fb9c
         * type : null
         */

        public String id;
        public String type;
        public String url;
    }
}
