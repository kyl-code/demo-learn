/*
package org.example.wx;

import cn.huolala.common.base.ex.SkillException;
import cn.huolala.common.database.util.RedisUtil;
import cn.huolala.nacos.server.pos.user.controller.vo.LoginVo;
import cn.huolala.nacos.server.pos.user.controller.vo.WXDecryptVo;
import cn.huolala.nacos.server.pos.user.dao.entity.WXLogin;
import cn.huolala.nacos.server.pos.user.kit.WXKit;
import cn.huolala.nacos.server.pos.user.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

*/
/**
 * @author adam.guo
 * @date:2020/9/30
 *//*

public abstract class WXAbstract {
    protected Logger logger = LoggerFactory.getLogger(super.getClass().getName());

    protected static final long EXPIRE_TIME = 60*60;

    protected static final String URL = "https://api.weixin.qq.com/sns/jscode2session?" +
            "appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    protected static final String QRCODE_URL = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?" +
            "access_token=ACCESS_TOKEN";

    protected static final String SESSION_PREFIX = "JSCODESESSION:";

    @Autowired
    protected RestTemplate restTemplate;

    @Autowired
    protected RedisUtil redisUtil;

    @Autowired
    protected LoginService loginService;

    protected LoginVo getWXUserInfo(WXDecryptVo wxDecryptVo, String appId, String appSecret){
        String openId = wxDecryptVo.getOpenId();
        String sessionKey = redisUtil.rc(String.class, String.class).get(SESSION_PREFIX.concat(openId));
        if(StringUtils.isBlank(sessionKey)){
            WXLogin info = getInfo(wxDecryptVo.getCode(), appId, appSecret);
            if(null == info){
                throw new SkillException(500, "Repeat Get SessionKey From WX Exception!");
            }
            sessionKey = info.getSession_key();
        }
        JSONObject userInfo = WXKit.getUserInfo(wxDecryptVo.getEncryptedData(), sessionKey, wxDecryptVo.getIv());
        if(null == userInfo){
            // 可能是sessionKey过期
            WXLogin info = getInfo(wxDecryptVo.getCode(), appId, appSecret);
            userInfo = WXKit.getUserInfo(wxDecryptVo.getEncryptedData(), info.getSession_key(), wxDecryptVo.getIv());
        }
        LoginVo loginVo = convertVo(userInfo, openId, appId);
        return loginVo;
    }

    private LoginVo convertVo(JSONObject userInfo, String openId, String appId){
        LoginVo loginVo = new LoginVo();
        String avatarUrl = userInfo.getString("avatarUrl");
        String city = userInfo.getString("city");
        Integer gender = userInfo.getInteger("gender");
        String nickName = userInfo.getString("nickName");
        String phoneNumber = userInfo.getString("phoneNumber");
        String unionId = userInfo.getString("unionId");
        loginVo.setAppId(appId);
        loginVo.setMobile(phoneNumber);
        loginVo.setOpenId(openId);
        loginVo.setUnionId(unionId);
        loginVo.setNickname(nickName);
        loginVo.setPortrait(avatarUrl);
        loginVo.setCity(city);
        return loginVo;
    }

    protected WXLogin getInfo(String code, String appId, String appSecret) {
        String replace = URL.replace("APPID", appId).replace("SECRET", appSecret).replace("JSCODE", code);
        WXLogin wxLogin = null;
        try {
            String result = restTemplate.getForObject(replace, String.class);
            wxLogin = JSONObject.parseObject(result, WXLogin.class);
        } catch (Exception e) {
            logger.error("WXClientController getInfo has an error:{}", e);
            throw new SkillException(500, e.getMessage());
        }
        if(null != wxLogin.getErrcode() && !wxLogin.getErrcode().equals(0)){
            throw new SkillException(500, wxLogin.getErrmsg());
        }
        redisUtil.rc(String.class, String.class).set(SESSION_PREFIX.concat(wxLogin.getOpenid()), wxLogin.getSession_key(), EXPIRE_TIME);
        // 将sessionKey置空
        wxLogin.setSession_key(null);
        return wxLogin;
    }
}
*/
