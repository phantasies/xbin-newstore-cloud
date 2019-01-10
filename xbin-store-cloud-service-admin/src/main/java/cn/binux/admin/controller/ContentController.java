package cn.binux.admin.controller;

import cn.binux.admin.service.ContentService;
import cn.binux.pojo.TbCategorySecondary;
import cn.binux.pojo.XbinResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

/**
 * TestBeanController;
 * @author junyi
 */
@RestController
public class ContentController {

    @Autowired
    @Qualifier("contentServiceImpl")
    ContentService contentService;

    @GetMapping(value = "/getCategoryList")
    public Map<String, Object> getCategoryList(Integer sEcho, Integer iDisplayStart, Integer iDisplayLength) {
        return contentService.getCategoryList(sEcho, iDisplayStart, iDisplayLength);
    }

    @PostMapping("/saveCategory")
    public XbinResult saveCategory(String id, String name, Integer sort_order) {
        return contentService.saveCategory(id, name, sort_order);
    }


    @GetMapping("getCategorySecondaryList")
    public Map<String, Object> getCategorySecondaryList(Integer sEcho, Integer iDisplayStart,
                                                        Integer iDisplayLength) {
        return contentService.getCategorySecondaryList(sEcho, iDisplayStart, iDisplayLength);
    }


    @GetMapping("/getSearchCategorySecondaryList")
    public Map<String, Object> getSearchCategorySecondaryList(String sSearch, Integer sEcho,
                                                              Integer iDisplayStart,
                                                              Integer iDisplayLength) {
        return contentService.getSearchCategorySecondaryList(sSearch, sEcho, iDisplayStart, iDisplayLength);
    }

    @PostMapping("/saveCategorySecondary")
    public XbinResult saveCategorySecondary(@RequestBody TbCategorySecondary categorySecondary) {
        return contentService.saveCategorySecondary(categorySecondary);
    }
}
