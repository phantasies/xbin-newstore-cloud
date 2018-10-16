package cn.binux.mapper;

import cn.binux.pojo.TbManageUser;

/**
 * @Type TbManageUserMapper.java
 * @Desc
 * @author Tb
 * @date 2018-09-18 上午10:59:54
 * @version
 */
public interface TbManageUserMapper {
    int insert(TbManageUser record);

    TbManageUser selectByPrimaryKey(Long id);

    int update(TbManageUser record);
}
