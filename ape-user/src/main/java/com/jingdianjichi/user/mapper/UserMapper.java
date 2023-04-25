package com.jingdianjichi.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import entity.po.UserPo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserPo> {
}
