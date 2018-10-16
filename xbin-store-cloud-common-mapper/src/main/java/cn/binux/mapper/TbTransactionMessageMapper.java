package cn.binux.mapper;

import cn.binux.pojo.TbTransactionMessage;

/**
 * @Type TbTransactionMessageMapper.java
 * @Desc
 * @author Tb
 * @date 2018-09-18 上午10:59:54
 * @version
 */
public interface TbTransactionMessageMapper {
    int insert(TbTransactionMessage record);

    TbTransactionMessage selectByPrimaryKey(Long id);

    int update(TbTransactionMessage record);
}
