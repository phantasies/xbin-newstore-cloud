package cn.binux.mapper;

import java.util.List;
import java.util.Map;

import cn.binux.pojo.TbCategory;
import org.springframework.stereotype.Component;

/**
 * @Type TbCategoryMapper.java
 * @Desc
 * @author Tb
 * @date 2018-09-18 上午10:59:54
 * @version
 */
@Component
public interface TbCategoryMapper {
    int insert(TbCategory record);

    TbCategory selectByPrimaryKey(Long id);

    List<TbCategory> selectByCondition(Map<String, Object> condition);

    int update(TbCategory record);
}
