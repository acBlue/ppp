/**
 * @Project: cool-base-web
 * @Author: guocp
 * @Date: 2018年5月23日
 * @Copyright: ©2018-2028 www.pscrow.com Inc. All rights reserved.
 */
package com.yw.core.base.request;

import com.yw.core.base.model.UserInfo;

/**
 * ClassName: LocalRequestToken
 * 
 * @Description: 当前请求token
 * @author guocp
 * @date 2018年5月23日
 */
public class LocalRequestUser {

    /**
     * 本地请求token
     */
    private static final ThreadLocal<UserInfo> LOCAL_REQUEST_USER = new ThreadLocal();

    public static void set(UserInfo userInfo) {
        LOCAL_REQUEST_USER.set(userInfo);
    }

    public static UserInfo get() {
        return LOCAL_REQUEST_USER.get();
    }

    public static void remove() {
        LOCAL_REQUEST_USER.remove();
    }

}
