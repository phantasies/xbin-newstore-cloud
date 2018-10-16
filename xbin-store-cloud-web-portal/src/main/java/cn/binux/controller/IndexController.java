package cn.binux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.binux.homepage.service.HomepageContentService;
import io.swagger.annotations.Api;

/**
 * 首页 Controller
 * @create 2017-05-04
 */

@Api(value = "API - IndexController", description = "首页Controller")
@Controller
@RefreshScope
public class IndexController {

    @Autowired
    private HomepageContentService homepageContentService;

    @Value("${big_ad_index}")
    private long Big_AD_INDEX;


    @RequestMapping("/index")
    public String index(Model model) {


        return "homepage/index";
    }

    @RequestMapping("/sideBar/popupLogin")
    public String popupLogin() {

        return "homepage/popupLogin";
    }


}
