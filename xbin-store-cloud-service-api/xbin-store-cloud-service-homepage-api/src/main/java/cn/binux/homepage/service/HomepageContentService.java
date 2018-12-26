package cn.binux.homepage.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import cn.binux.pojo.TbContent;
import cn.binux.homepage.service.hystrix.HomepageContentServiceHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 首页操作 Service
 *
 * @author gou
 * @create 2017-05-04
 */

@FeignClient(value = "xbin-store-cloud-service-homepage", fallback = HomepageContentServiceHystrix.class)
public interface HomepageContentService {

    @RequestMapping(value = "/getContentByCid", method = RequestMethod.POST)
    List<TbContent> getContentByCid(@RequestParam("bigAdIndex") Long bigAdIndex);
}
