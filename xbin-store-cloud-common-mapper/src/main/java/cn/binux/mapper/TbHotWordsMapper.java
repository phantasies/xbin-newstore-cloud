package cn.binux.mapper;

import cn.binux.pojo.TbHotWords;

/**
 * @Type TbHotWordsMapper.java
 * @Desc
 * @author Tb
 * @date 2018-09-18 上午10:59:54
 * @version
 */
public interface TbHotWordsMapper {
    int insert(TbHotWords record);

    TbHotWords selectByPrimaryKey(Long id);

    int update(TbHotWords record);
}
