package cn.binux.mapper;

import java.util.List;
import java.util.Map;

import cn.binux.pojo.TbUserAddr;

/**
 * @Type TbUserAddrMapper.java
 * @Desc
 * @author Tb
 * @date 2018-09-18 上午10:59:54
 * @version
 */
public interface TbUserAddrMapper {
    int insert(TbUserAddr record);

    List<TbUserAddr> selectByCondition(Map<String, Object> condition);

    int update(TbUserAddr record);
}
