package cn.binux.mapper;

import cn.binux.pojo.TbItemParam;

/**
 * @Type TbItemParamMapper.java
 * @Desc
 * @author Tb
 * @date 2018-09-18 上午10:59:54
 * @version
 */
public interface TbItemParamMapper {
    int insert(TbItemParam record);

    TbItemParam selectByPrimaryKey(Long id);

    int update(TbItemParam record);
}
