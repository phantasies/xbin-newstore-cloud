package cn.binux.admin.service.impl;

import cn.binux.admin.service.ContentService;
import cn.binux.pojo.TbCategory;
import cn.binux.pojo.TbCategorySecondary;
import cn.binux.pojo.XbinResult;
import cn.binux.mapper.TbCategoryMapper;
import cn.binux.mapper.TbCategorySecondaryMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 内容维护 Service
 *
 * @author xubin.
 * @create 2017-04-28
 */


@Service
public class ContentServiceImpl implements ContentService {

    private static final Logger logger = LoggerFactory.getLogger(ContentServiceImpl.class);

    @Autowired
    private TbCategoryMapper categoryMapper;

    @Autowired
    private TbCategorySecondaryMapper categorySecondaryMapper;

    @Override
    public Map<String, Object> getCategoryList(Integer sEcho, Integer iDisplayStart, Integer iDisplayLength) {
        HashMap<String, Object> map = new HashMap<>();
        int pageNum = iDisplayStart / iDisplayLength + 1;
        PageHelper.startPage(pageNum, iDisplayLength);
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("sortOrder", 1);
        List<TbCategory> list = categoryMapper.selectByCondition(condition);
        PageInfo<TbCategory> pageInfo = new PageInfo<>(list);
        map.put("sEcho", sEcho + 1);
        map.put("iTotalRecords", pageInfo.getTotal());
        map.put("iTotalDisplayRecords", pageInfo.getTotal());
        map.put("aData", list);
        return map;
    }

    @Override
    //@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public XbinResult saveCategory(String id, String name, Integer sort_order) {

        TbCategory category = new TbCategory();
        category.setId(id);
        category.setName(name);
        category.setSortOrder(sort_order);
        category.setUpdated(new Date());
        int i = categoryMapper.update(category);
        return i > 0 ? XbinResult.ok() : XbinResult.build(400, "更新失败！");
    }

    @Override
    public Map<String, Object> getCategorySecondaryList(Integer sEcho, Integer iDisplayStart, Integer iDisplayLength) {

        HashMap<String, Object> map = new HashMap<>();
        int pageNum = iDisplayStart / iDisplayLength + 1;
        PageHelper.startPage(pageNum, iDisplayLength);
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("parentId", 0);
        List<TbCategorySecondary> list = categorySecondaryMapper.selectByCondition(condition);
        PageInfo<TbCategorySecondary> pageInfo = new PageInfo<>(list);
        map.put("sEcho", sEcho + 1);
        map.put("iTotalRecords", pageInfo.getTotal());
        map.put("iTotalDisplayRecords", pageInfo.getTotal());
        map.put("aData", list);
        return map;
    }

    @Override
    public Map<String, Object> getSearchCategorySecondaryList(String sSearch, Integer sEcho,
                                                              Integer iDisplayStart,
                                                              Integer iDisplayLength) {

        HashMap<String, Object> map = new HashMap<>();
        int pageNum = iDisplayStart / iDisplayLength + 1;
        PageHelper.startPage(pageNum, iDisplayLength);
        List<TbCategorySecondary> list = categorySecondaryMapper.selectByNameLike(sSearch);
        PageInfo<TbCategorySecondary> pageInfo = new PageInfo<>(list);
        map.put("sEcho", sEcho + 1);
        map.put("iTotalRecords", pageInfo.getTotal());
        map.put("iTotalDisplayRecords", pageInfo.getTotal());
        map.put("aData", list);

        return map;
    }

    @Override
    //@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public XbinResult saveCategorySecondary(@RequestBody TbCategorySecondary categorySecondary) {

        categorySecondary.setUpdated(new Date());
        int i = categorySecondaryMapper.update(categorySecondary);
        return i > 0 ? XbinResult.ok() : XbinResult.build(400, "服务器出错!");
    }
}
