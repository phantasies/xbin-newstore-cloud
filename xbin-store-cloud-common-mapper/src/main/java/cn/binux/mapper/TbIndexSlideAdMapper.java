package cn.binux.mapper;

import cn.binux.pojo.TbIndexSlideAd;

/**
 * @Type TbIndexSlideAdMapper.java
 * @Desc
 * @author Tb
 * @date 2018-09-18 上午10:59:54
 * @version
 */
public interface TbIndexSlideAdMapper {
    int insert(TbIndexSlideAd record);

    TbIndexSlideAd selectByPrimaryKey(Long id);

    int update(TbIndexSlideAd record);
}
