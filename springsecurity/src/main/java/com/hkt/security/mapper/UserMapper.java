package com.hkt.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hkt.security.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.User;

/**
 * @author 794073612@qq.com
 * @time 16:50 2022/6/11
 **/
@Mapper
public interface UserMapper extends BaseMapper<Users> {

}
