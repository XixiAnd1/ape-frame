package com.jingdianjichi.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.jingdianjichi.user.DemoApplication;
import com.jingdianjichi.user.designPattern.responsibilityChainPattern.ArticleInfo;
import com.jingdianjichi.user.designPattern.responsibilityChainPattern.RuleCheckComponent;
import com.jingdianjichi.user.designPattern.responsibilityChainPattern.RuleCheckResult;
import com.jingdianjichi.user.entity.po.SysUser;
import com.jingdianjichi.user.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class SysUserServiceTest {

    @Resource
    private SysUserService sysUserService;

    @Resource
    private RuleCheckComponent ruleCheckComponent;

    @Test
    public void testQuery() {
        SysUser sysUser = sysUserService.queryById(1L);
        System.out.println(sysUser);
    }

    @Test
    public void testAopUtils() {
        Class<?> targetClass = AopUtils.getTargetClass(sysUserService);
        System.out.println(targetClass);
    }

    @Test
    public void testArticle() {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setTitle("jichi");
        articleInfo.setContent("经典鸡翅");
        RuleCheckResult ruleCheckResult = ruleCheckComponent.checkArticle(articleInfo);
        System.out.println(JSON.toJSON(ruleCheckResult));
    }


    public static void main(String[] args) {

       JSONObject jsonObj = JSON.parseObject("{root:{data:{MSG:{DFLT:\"[\"apple\", \"orange\", \"banana\"]\"}}}}");

    }





}
