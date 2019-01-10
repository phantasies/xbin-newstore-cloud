package cn.binux.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.binux.homepage.service.HomepageContentService;

/**
 * 首页 Controller
 *
 * @author gou
 * @create 2017-05-04
 */
@Api(value = "API - IndexController", description = "首页Controller")
@Controller
public class IndexController {

    @Autowired
    @Qualifier("homepageContentServiceHystrix")
    private HomepageContentService homepageContentService;

    @Value("${big_ad_index}")
    private long Big_AD_INDEX;

    /**
     * 跳转到默认首页;
     *
     * @return String
     */
    @RequestMapping(value = {"/index","/"})
    public String index() {
        return "homepage/index";
    }



    /**
     * 跳转到 popupLogin 页面
     *
     * @return String
     */
    @RequestMapping("/sideBar/popupLogin")
    public String popupLogin() {
        return "homepage/popupLogin";
    }


}
