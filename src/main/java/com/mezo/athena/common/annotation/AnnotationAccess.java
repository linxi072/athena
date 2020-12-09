package com.mezo.athena.common.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationAccess {

    public static void printClassAnnotations(Class clazz) {
         if (clazz.isAnnotationPresent(AuthorAnnotion.class)) {
             AuthorAnnotion ConstructorAnnotation = (AuthorAnnotion) clazz.getAnnotation(AuthorAnnotion.class);
             System.out.println("作者：" + ConstructorAnnotation.name() + ",公司：" + ConstructorAnnotation.company());
         }
    }

    public static void printConstructorAnnotations(Class clazz) {
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (int i=0;i<declaredConstructors.length;i++) {
            Constructor constructor = declaredConstructors[i];
            if (constructor.isAnnotationPresent(ConstructorAnnotation.class)) {
                ConstructorAnnotation annotation = (ConstructorAnnotation) constructor.getAnnotation(ConstructorAnnotation.class);
                System.out.println(constructor.getName() + ":" + annotation.value());
            }
            Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            printParameterAnnotations(parameterAnnotations);
        }
        System.out.println();
    }

    public static void printFieldAnnotations(Class clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (int i=0;i<declaredFields.length;i++) {
            Field field = declaredFields[i];
            if (field.isAnnotationPresent(CommonAnnotation.class)) {
                CommonAnnotation annotation = field.getAnnotation(CommonAnnotation.class);
                System.out.println("成员变量:" + field.getName() + "   " + annotation.description() + "   " + annotation.type());
            }
        }
    }

    public static void printMethodAnnotations(Class clazz) {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (int i=0;i<declaredMethods.length;i++) {
            Method method = declaredMethods[i];
            if (method.isAnnotationPresent(CommonAnnotation.class)) {
                CommonAnnotation annotation = method.getAnnotation(CommonAnnotation.class);
                System.out.println("成员变量:" + method.getName() + "   " + annotation.description() + "   " + annotation.type());
            }
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            printParameterAnnotations(parameterAnnotations);
        }
    }
    private static void printParameterAnnotations(Annotation[][] parameterAnnotations) {
        for (int i=0;i<parameterAnnotations.length;i++) {
            int length = parameterAnnotations[i].length;
            if (length==0) {
                System.out.println("");
            } else {
                for (int j=0;j<length;j++) {
                    CommonAnnotation annotation = (CommonAnnotation) parameterAnnotations[i][j];
                    System.out.println("第"+i+1+"个参数:" + annotation.description() + ",类型:" + annotation.type());
                }
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("com.mezo.athena.demain.Person");
        printClassAnnotations(clazz);

        printConstructorAnnotations(clazz);

        printMethodAnnotations(clazz);

        printFieldAnnotations(clazz);
    }
}
