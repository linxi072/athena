package com.mezo.athena.demain;

import com.mezo.athena.common.annotation.AuthorAnnotion;
import com.mezo.athena.common.annotation.CommonAnnotation;
import com.mezo.athena.common.annotation.ConstructorAnnotation;

@AuthorAnnotion(name = "Tom",company = "互通网络")
public class Person {
    @CommonAnnotation(type = String.class,description = "名称")
    private String mame;
    @CommonAnnotation(type = Integer.class,description = "年龄")
    private Integer age;

    @ConstructorAnnotation
    public Person(){
        this("unknown",0);
    }

    @ConstructorAnnotation("带参数构造器方法")
    public Person(@CommonAnnotation(type = String.class,description = "名称") String name,
                  @CommonAnnotation(type = Integer.class,description = "年龄") Integer age) {
        this.mame = name;
        this.age = age;
    }
    @CommonAnnotation(type = String.class,description = "获得名称")
    public String getMame() {
        return mame;
    }
    @CommonAnnotation(description = "设置名称")
    public void setMame(@CommonAnnotation(type = String.class,description = "名称")String mame) {
        this.mame = mame;
    }
    @CommonAnnotation(type = Integer.class,description = "获得年龄")
    public Integer getAge() {
        return age;
    }
    @CommonAnnotation(description = "设置年龄")
    public void setAge(@CommonAnnotation(type = Integer.class,description = "年龄")Integer age) {
        this.age = age;
    }
}
