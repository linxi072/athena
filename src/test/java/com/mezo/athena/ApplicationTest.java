package com.mezo.athena;

import com.mezo.athena.common.util.FreeMarkerUtils;
import com.mezo.athena.demain.AthenaUser;
import com.mezo.athena.mapper.AthenaRoleMapper;
import com.mezo.athena.mapper.AthenaUserMapper;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class ApplicationTest {

    public static String PROJECT_PATH = System.getProperty("user.dir");
    @Autowired(required = false)
    AthenaRoleMapper athenaRoleMapper;
    @Autowired(required = false)
    AthenaUserMapper athenaUserMapper;

    @Test
    public void test01() {
        AthenaUser athenaUser = athenaUserMapper.selectByPrimaryKey(1);
        Assert.assertNotNull(athenaUser);
    }
    @Test
    public void test02() throws IOException, TemplateException {
        HashMap map = new HashMap();
        map.put("hello", "Hello FreeMarker!");
        HashMap c = new HashMap();
        c.put("name","张三");
        c.put("age","21");
        map.put("c",c);
        String binding = FreeMarkerUtils.binding(PROJECT_PATH + "/src/main/resources/freemarker", "baojia.ftl",map);
        System.out.println(binding);
    }
}