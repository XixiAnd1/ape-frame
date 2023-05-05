package com.jingdianjichi.user.convert;

import com.jingdianjichi.user.entity.po.SysUser;
import com.jingdianjichi.user.entity.req.SysUserReq;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-05T23:11:21+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_372 (Amazon.com Inc.)"
)
public class SysUserConverterImpl implements SysUserConverter {

    @Override
    public SysUser convertReqToSysUser(SysUserReq sysUserReq) {
        if ( sysUserReq == null ) {
            return null;
        }

        SysUser sysUser = new SysUser();

        return sysUser;
    }
}
