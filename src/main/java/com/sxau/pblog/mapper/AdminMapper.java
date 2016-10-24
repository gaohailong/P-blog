package com.sxau.pblog.mapper;

import com.sxau.pblog.pojo.Admin;
import com.sxau.pblog.pojo.AdminExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * admin的接口
 */
public interface AdminMapper {
    /**
     * 获取admin的总数
     *
     * @param admin
     * @return
     */
    int countByExample(Admin admin);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条数据
     *
     * @param record admin对象
     * @return
     */
    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(Admin example);

//    int selectByAdmin(Admin admin);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    /**
     * 更新sessin
     *
     * @param admin admin对象
     * @return
     */
    int updateSessionByAdmin(Admin admin);

    /**
     * 通过sessionid查找session
     *
     * @param sessionid sessionid
     * @return
     */
    int selectSessionIdBySessionId(String sessionid);
}