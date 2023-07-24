//package com.cn.smart.util;
//
//import java.io.File;
//import java.io.FileOutputStream;
//
//import com.github.javaparser.JavaParser;
//import com.github.javaparser.ast.CompilationUnit;
//import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
//import com.github.javaparser.ast.body.MethodDeclaration;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//
///**
// * TODO
// *
// * @author xiongyan
// * @date 2023/7/7
// */
//public class Sw {
//
//    public static void main(String[] args) throws Exception {
//        String projectPath = "/Users/xiongyan/Documents/work/fc-cdc/fc-cdc-api/src/main/java/com/fc/cdc/controller";
//        File project = new File(projectPath);
////        ScmAssert.isTrue(project.exists(), "项目路径不存在");
//        // 写入文件到指定位置，获取controller层文件夹位置
//        for (File file : project.listFiles()) {
//            JavaParser javaParser = new JavaParser();
//            CompilationUnit cu = javaParser.parse(file).getResult().orElse(null);
//            if (null == cu) {
//                continue;
//            }
//
//            String classComment;
//            ClassOrInterfaceDeclaration clazz = cu.findFirst(ClassOrInterfaceDeclaration.class).get();
//            if (clazz.getJavadoc().isPresent()) {
//                classComment = clazz.getJavadoc().get().getDescription().toText();
//                if (!clazz.getAnnotationByClass(Api.class).isPresent()) {
//                    clazz.addAndGetAnnotation(Api.class).addPair("value", "\"" + classComment + "\"");
//                }
//            } else {
//                classComment = null;
//            }
//
//            cu.findAll(MethodDeclaration.class).forEach(method -> {
//                if (method.getJavadoc().isPresent()) {
//                    String javadocComment = method.getJavadoc().get().getDescription().toText();
//                    if (!method.getAnnotationByClass(ApiOperation.class).isPresent()) {
//                        method.addAndGetAnnotation(ApiOperation.class).addPair("value", "\"" + classComment + "-" + javadocComment + "\"");
//                    }
//                }
//            });
//
//            FileOutputStream outputStream = new FileOutputStream(file);
//            outputStream.write(cu.toString().getBytes());
//        }
//    }
//
//}
