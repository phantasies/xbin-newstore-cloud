package cn.binux.mapper;

import cn.binux.pojo.TbItemParamItem;

/**
 * @Type TbItemParamItemMapper.java
 * @Desc
 * @author Tb
 * @date 2018-09-18 上午10:59:54
 * @version
 */
public interface TbItemParamItemMapper {
    int insert(TbItemParamItem record);

    TbItemParamItem selectByPrimaryKey(Long id);

    int update(TbItemParamItem record);
}
