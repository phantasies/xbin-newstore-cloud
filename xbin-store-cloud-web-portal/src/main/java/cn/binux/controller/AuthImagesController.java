package cn.binux.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.binux.utils.VerifyCodeUtils;
import cn.binux.utils.JedisClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 验证码 Controller
 *
 * @author xubin.
 * @create 2017-05-05
 */

@Api(value = "API - AuthImagesController", description = "验证码 Controller")
@Controller
public class AuthImagesController {

    private static final Logger logger = LoggerFactory.getLogger(AuthImagesController.class);

    @Autowired
    private JedisClient jedisClient;

    @Value("${redisKey.prefix.verifycode}")
    private String VERIFYCODE;

    @Value("${redisKey.expire_time}")
    private Integer EXPIRE_TIME;

    @ApiOperation(value = "生成图片验证码",notes = "需要传递一个uuid作为用户本次登录的唯一表示")
    @ApiImplicitParam(name = "uid",value = "每个 uid 对应一次用户登录",required = true,dataType = "String")
    @RequestMapping(value = "/verify/image", method = RequestMethod.GET)
    public void verifyimage(String uid, HttpServletResponse response) {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入Redis
        String key = VERIFYCODE + uid;
        jedisClient.set(key, verifyCode);
        jedisClient.expire(key, EXPIRE_TIME);
        //生成图片
        int w = 100, h = 30;
        try {
            VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
        } catch (IOException e) {
            logger.error("验证码生成失败", e);
        }

    }

}
