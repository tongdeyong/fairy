package com.fairy.system.component;

import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author deyong_tong
 */
@Component
@Slf4j
public class CodeGenComponent {

    private VelocityEngine velocityEngine;

    public ByteArrayOutputStream generateCode(List<Map<String, Object>> data, String packageName, String module) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(byteArrayOutputStream);
        data.forEach(item -> {
            VelocityContext context = new VelocityContext();
            Set<String> set = item.keySet();
            for (String key : set) {
                context.put(key, item.get(key));
            }
            File file = new File(Objects.requireNonNull(this.getClass().getClassLoader().getResource("tpl")).getPath());
            String[] templateFileList = file.list();
            if (templateFileList != null) {
                Arrays.asList(templateFileList).forEach(templateFile -> {
                    //加载模板，设定模板编码
                    Template template = velocityEngine.getTemplate("tpl/" + templateFile, "utf-8");
                    //设置输出
                    StringWriter stringWriter = new StringWriter();
                    //将环境数据转化输出
                    template.merge(context, stringWriter);
                    log.info(packageName + File.separator + module + File.separator + getFilePath(templateFile) + File.separator + getFile(templateFile, item.get("ClassName").toString()));
                    log.info(stringWriter.toString());
                    try {
                        //添加到zip
                        if ("mapper.vm".equals(templateFile)) {
                            zip.putNextEntry(new ZipEntry("src/main/resource/mybatis/" + module + File.separator + getFile(templateFile, item.get("ClassName").toString())));
                        } else if ("vue.vm".equals(templateFile)) {
                            zip.putNextEntry(new ZipEntry("fe/src/view/" + module + File.separator + getFile(templateFile, item.get("ClassName").toString())));
                        } else if ("api.vm".equals(templateFile)) {
                            zip.putNextEntry(new ZipEntry("fe/src/api/" + module + File.separator + getFile(templateFile, item.get("ClassName").toString())));
                        } else {
                            zip.putNextEntry(new ZipEntry("src/main/java/" + packageName + File.separator + module + File.separator + getFilePath(templateFile) + File.separator + getFile(templateFile, item.get("ClassName").toString())));
                        }
                        zip.write(stringWriter.toString().getBytes());
                    } catch (IOException e) {
                        log.error(e.getMessage(), e);
                    }
                });
            }
        });
        try {
            zip.close();
        } catch (IOException e) {
            log.error("流关闭异常", e);
        }
        return byteArrayOutputStream;
    }

    private String getFile(String templateFile, String className) {
        switch (templateFile) {
            case "controller.vm":
                return className + "Controller.java";
            case "dao.vm":
                return className + "Dao.java";
            case "service.vm":
                return className + "Service.java";
            case "serviceImpl.vm":
                return className + "ServiceImpl.java";
            case "vo.vm":
                return className + "VO.java";
            case "mapper.vm":
                return className + "Mapper.xml";
            case "vue.vm":
                return "index.vue";
            case "api.vm":
                return className + ".js";
            default:
                return className + ".java";
        }
    }

    private String getFilePath(String templateFile) {
        switch (templateFile) {
            case "controller.vm":
                return "controller";
            case "dao.vm":
                return "dao";
            case "service.vm":
                return "service";
            case "serviceImpl.vm":
                return "service/impl";
            case "model.vm":
                return "model";
            case "vo.vm":
                return "vo";
            case "mapper.vm":
                return "mapper";
            default:
                return "";
        }
    }

    @PostConstruct
    public void init() {
        velocityEngine = new VelocityEngine();
        //设置模板加载路径，这里设置的是class下
        velocityEngine.setProperty(Velocity.RESOURCE_LOADER, "class");
        velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        //进行初始化操作
        velocityEngine.init();
    }

    public static void main(String[] args) throws IOException {
        CodeGenComponent codeGenComponent = new CodeGenComponent();
        codeGenComponent.init();
        List<Map<String, Object>> param = new ArrayList<>();
        Map<String, Object> data = new HashMap<>(12);
        data.put("ClassName", "Dept");
        data.put("tableName", "sys_dept");
        data.put("className", "dept");
        data.put("module", "system");
        data.put("packageName", "com.fairy");
        data.put("primaryKeyType", "Integer");
        data.put("hasDate", false);
        List<Map<String, String>> columns = new ArrayList<>();
        Map<String, String> column = new HashMap<>(5);
        column.put("attributeName", "id");
        column.put("name", "id");
        column.put("comment", "主键");
        column.put("type", "Integer");
        columns.add(column);
        column = new HashMap<>(5);
        column.put("attributeName", "name");
        column.put("name", "name");
        column.put("comment", "姓名");
        column.put("type", "String");
        columns.add(column);
        data.put("columns", columns);
        param.add(data);
        ByteArrayOutputStream byteArrayOutputStream = codeGenComponent.generateCode(param, "com/fairy", "system");
        byte[] bytes = byteArrayOutputStream.toByteArray();
        FileOutputStream fileOutputStream = new FileOutputStream("D:/code.zip");
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
