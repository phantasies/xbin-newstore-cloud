package cn.binux.mapper;

import java.util.List;
import java.util.Map;

import cn.binux.pojo.TbUser;

/**
 * @Type TbUserMapper.java
 * @Desc
 * @author Tb
 * @date 2018-09-18 上午10:59:54
 * @version
 */
public interface TbUserMapper {

    List<TbUser> selectByCondition(Map<String, Object> condition);

    int insert(TbUser record);

    int update(TbUser record);
}
