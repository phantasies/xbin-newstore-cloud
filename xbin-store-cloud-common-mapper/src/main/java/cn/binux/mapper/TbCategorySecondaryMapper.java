package cn.binux.mapper;

import java.util.List;
import java.util.Map;

import cn.binux.pojo.TbCategorySecondary;

/**
 * @Type TbCategorySecondaryMapper.java
 * @Desc
 * @author Tb
 * @date 2018-09-18 上午10:59:54
 * @version
 */
public interface TbCategorySecondaryMapper {
    int insert(TbCategorySecondary record);

    TbCategorySecondary selectByPrimaryKey(Long id);

    List<TbCategorySecondary> selectByCondition(Map<String, Object> condition);

    List<TbCategorySecondary> selectByNameLike(String name);

    int update(TbCategorySecondary record);
}
