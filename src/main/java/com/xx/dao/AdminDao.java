package com.xx.dao;

import com.xx.domain.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    /**
     * 验证token是否存在
     * @param token
     * @return
     */
    Admin findAdmin(@Param("token") String token);
}
