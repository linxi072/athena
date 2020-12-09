package com.mezo.athena.common.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorAnnotion {

    String name();
    String company();
}
