//package com.cn.smart.util;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//import com.fuchuang.scm.common.util.ScmAssert;
//import com.github.javaparser.StaticJavaParser;
//import com.github.javaparser.ast.CompilationUnit;
//import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
//import com.github.javaparser.ast.body.MethodDeclaration;
//
//import cn.hutool.core.util.StrUtil;
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
//        String clientPath = "/Users/xiongyan/Documents/work/fc-cdc/fc-cdc-api/src/main/java/com/fc/cdc/controller";
//        String controllerPath = "/Users/xiongyan/Documents/work/fc-cdc/fc-cdc-api/src/main/java/com/fc/cdc/controller";
//
//        Map<String, ClassOrInterfaceDeclaration> clientMap = Sw.clientMap(clientPath);
//
//        File project = new File(controllerPath);
//        ScmAssert.isTrue(project.exists(), "项目路径不存在");
//        for (File file : project.listFiles()) {
//            CompilationUnit cu = StaticJavaParser.parse(file);
//            ClassOrInterfaceDeclaration classDeclaration = cu.findFirst(ClassOrInterfaceDeclaration.class).orElse(null);
//            if (null == classDeclaration) {
//                continue;
//            }
//
//            String classComment = null;
//            Map<String, String> methodCommentMap = new HashMap<>();
//            if (classDeclaration.getImplementedTypes().size() > 0) {
//                String interfaceName = classDeclaration.getImplementedTypes(0).getNameAsString();
//                ClassOrInterfaceDeclaration interfaceDeclaration = clientMap.get(interfaceName);
//                if (null == interfaceDeclaration) {
//                    continue;
//                }
//                if (interfaceDeclaration.getJavadoc().isPresent()) {
//                    classComment = interfaceDeclaration.getJavadoc().get().getDescription().toText();
//                }
//                for (MethodDeclaration method : interfaceDeclaration.getMethods()) {
//                    if (!method.getJavadoc().isPresent()) {
//                        continue;
//                    }
//                    methodCommentMap.put(method.getNameAsString(), method.getJavadoc().get().getDescription().toText());
//                }
//            }
//
//            if (StrUtil.isEmpty(classComment)) {
//                if (classDeclaration.getJavadoc().isPresent()) {
//                    classComment = classDeclaration.getJavadoc().get().getDescription().toText();
//                } else {
//                    classComment = classDeclaration.getNameAsString();
//                }
//            }
//            if (!classDeclaration.getAnnotationByClass(Api.class).isPresent()) {
//                classDeclaration.addAndGetAnnotation(Api.class).addPair("value", "\"" + classComment + "\"");
//            }
//
//            for (MethodDeclaration method : classDeclaration.getMethods()) {
//                if (method.getAnnotationByClass(ApiOperation.class).isPresent()) {
//                    continue;
//                }
//                String methodComment = methodCommentMap.get(method.getNameAsString());
//                if (StrUtil.isEmpty(methodComment)) {
//                    if (method.getJavadoc().isPresent()) {
//                        methodComment = method.getJavadoc().get().getDescription().toText();
//                    } else {
//                        methodComment = method.getNameAsString();
//                    }
//                }
//                method.addAndGetAnnotation(ApiOperation.class).addPair("value", "\"" + classComment + "-" + methodComment + "\"");
//            }
//
//            FileOutputStream outputStream = new FileOutputStream(file);
//            outputStream.write(cu.toString().getBytes());
//        }
//    }
//
//    private static Map<String, ClassOrInterfaceDeclaration> clientMap(String path) throws FileNotFoundException {
//        File project = new File(path);
//        ScmAssert.isTrue(project.exists(), "项目路径不存在");
//
//        Map<String, ClassOrInterfaceDeclaration> clientMap = new HashMap<>();
//        for (File file : project.listFiles()) {
//            CompilationUnit cu = StaticJavaParser.parse(file);
//            if (null == cu) {
//                continue;
//            }
//            ClassOrInterfaceDeclaration classDeclaration = cu.findFirst(ClassOrInterfaceDeclaration.class).orElse(null);
//            if (null != classDeclaration && classDeclaration.isInterface()) {
//                clientMap.put(classDeclaration.getNameAsString(), classDeclaration);
//            }
//        }
//        return clientMap;
//    }
//}
