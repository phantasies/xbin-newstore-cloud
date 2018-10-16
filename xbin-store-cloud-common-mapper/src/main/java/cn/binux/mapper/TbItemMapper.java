package cn.binux.mapper;

import cn.binux.pojo.TbItem;

/**
 * @Type TbItemMapper.java
 * @Desc
 * @author Tb
 * @date 2018-09-18 上午10:59:54
 * @version
 */
public interface TbItemMapper {
    int insert(TbItem record);

    TbItem selectByPrimaryKey(Long id);

    int update(TbItem record);
}
