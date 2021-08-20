package com.mezo.athena.admin.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.dom4j.*;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;

public class FreeMarkerUtils {

    /**
     * 模版绑定数据
     *
     * @param path 文件路径
     * @param name 文件名
     * @param map  数据
     * @return 绑定数据的字符串
     * @throws IOException       文件异常
     * @throws TemplateException 模版异常
     */
    public static String binding(String path, String name, HashMap map) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        FileTemplateLoader loader = new FileTemplateLoader(new File(path));
        cfg.setTemplateLoader(loader);
        Template template = cfg.getTemplate(name);
        StringWriter stringWriter = new StringWriter();
        template.process(map, stringWriter);
        return stringWriter.toString();
    }

    public static JSONObject strXMLToJSON(String xmlStr) throws DocumentException {
        Document doc = DocumentHelper.parseText(xmlStr);
        JSONObject json = new JSONObject();
        dom4j2Json(doc.getRootElement(), json);
        return json;
    }

    /**
     * xml转json
     *
     * @param element xml节点
     * @param json    转化后json对象
     */
    public static void dom4j2Json(Element element, JSONObject json) {
        //如果是属性
        for (Object o : element.attributes()) {
            Attribute attr = (Attribute) o;
            if (!StringUtils.isEmpty(attr.getValue())) {
                json.put("@" + attr.getName(), attr.getValue());
            }
        }
        List<Element> chdEl = element.elements();
        //如果没有子元素,只有一个值
        if (chdEl.isEmpty() && !StringUtils.isEmpty(element.getText())) {
            json.put(element.getName(), element.getText());
        }
        //有子元素
        for (Element e : chdEl) {
            //子元素也有子元素
            if (!e.elements().isEmpty()) {
                JSONObject chdJSON = new JSONObject();
                dom4j2Json(e, chdJSON);
                Object o = json.get(e.getName());
                if (o != null) {
                    JSONArray jsonA = null;
                    //如果此元素已存在,则转为jsonArray
                    if (o instanceof JSONObject) {
                        JSONObject jsonO = (JSONObject) o;
                        json.remove(e.getName());
                        jsonA = new JSONArray();
                        jsonA.add(jsonO);
                        jsonA.add(chdJSON);
                    }
                    if (o instanceof JSONArray) {
                        jsonA = (JSONArray) o;
                        jsonA.add(chdJSON);
                    }
                    json.put(e.getName(), jsonA);
                } else {
                    if (!chdJSON.isEmpty()) {
                        json.put(e.getName(), chdJSON);
                    }
                }
            } else {
                //子元素没有子元素
                for (Object o : element.attributes()) {
                    Attribute attr = (Attribute) o;
                    if (!StringUtils.isEmpty(attr.getValue())) {
                        json.put("@" + attr.getName(), attr.getValue());
                    }
                }
                if (!e.getText().isEmpty()) {
                    json.put(e.getName(), e.getText());
                }
            }
        }
    }
}
