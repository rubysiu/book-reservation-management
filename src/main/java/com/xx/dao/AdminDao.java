package com.xx.dao;

import com.xx.domain.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    /**
     * ��֤token�Ƿ����
     * @param token
     * @return
     */
    Admin findAdmin(@Param("token") String token);
}
