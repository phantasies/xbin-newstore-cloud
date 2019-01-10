package cn.binux.homepage.service.hystrix;

import cn.binux.homepage.service.HomepageContentService;
import cn.binux.pojo.TbContent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 首页 熔断处理
 *
 * @author xubin.
 * @create 2017-05-04
 */

@Component(value = "homepageContentServiceHystrix")
public class HomepageContentServiceHystrix implements HomepageContentService {

    @Override
    public List<TbContent> getContentByCid(Long bigAdIndex) {
        return null;
    }
}
