package cn.binux.mapper;

import java.util.List;
import java.util.Map;

import cn.binux.pojo.TbContent;
import org.springframework.stereotype.Component;

/**
 * @Type TbContentMapper.java
 * @Desc
 * @author Tb
 * @date 2018-09-18 上午10:59:54
 * @version
 */
@Component
public interface TbContentMapper {
    int insert(TbContent record);

    TbContent selectByPrimaryKey(Long id);

    List<TbContent> selectByCondition(Map<String, Object> condition);

    int update(TbContent record);
}
