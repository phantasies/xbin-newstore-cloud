package cn.binux.mapper;

import cn.binux.pojo.TbOrderItem;
import org.springframework.stereotype.Component;

/**
 * @Type TbOrderItemMapper.java
 * @Desc
 * @author Tb
 * @date 2018-09-18 上午10:59:54
 * @version
 */
@Component
public interface TbOrderItemMapper {

    int insert(TbOrderItem record);

    TbOrderItem selectByPrimaryKey(Long id);

    int update(TbOrderItem record);
}
