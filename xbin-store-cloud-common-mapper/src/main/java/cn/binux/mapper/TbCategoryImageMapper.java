package cn.binux.mapper;

import cn.binux.pojo.TbCategoryImage;

/**
 * @Type TbCategoryImageMapper.java
 * @Desc
 * @author Tb
 * @date 2018-09-18 上午10:59:54
 * @version
 */
public interface TbCategoryImageMapper {
    int insert(TbCategoryImage record);

    TbCategoryImage selectByPrimaryKey(Long id);

    int update(TbCategoryImage record);
}
