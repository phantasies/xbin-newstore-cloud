package cn.binux.mapper;

import cn.binux.pojo.TbContentCategory;

/**
 * @Type TbContentCategoryMapper.java
 * @Desc
 * @author Tb
 * @date 2018-09-18 上午10:59:54
 * @version
 */
public interface TbContentCategoryMapper {
    int insert(TbContentCategory record);

    TbContentCategory selectByPrimaryKey(Long id);

    int update(TbContentCategory record);
}
