package cn.binux.mapper;

import cn.binux.pojo.TbOrder;

/**
 * @Type TbOrderMapper.java
 * @Desc
 * @author Tb
 * @date 2018-09-18 上午10:59:54
 * @version
 */
public interface TbOrderMapper {

    int insert(TbOrder record);

    TbOrder selectByPrimaryKey(Long orderId);

    int update(TbOrder record);
}
