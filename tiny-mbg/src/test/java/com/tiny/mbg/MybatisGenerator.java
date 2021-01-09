package com.tiny.mbg;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
 * <p>
 * 请先配置一下参数
 *
 * @author knox
 * @since 2020-12-15
 */
public class MybatisGenerator {

    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE = "spring-cloud-alibaba-template";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "admin";
    private static final String SUPER_CONTROLLER = "";
    private static final String AUTHOR = "knox";

    /**
     * 读取控制台内容
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!ObjectUtils.isEmpty(ipt)) {
                return ipt.toLowerCase();
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 生成器入口
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 1.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/" + DATABASE + "?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=GMT%2B8");
        dataSourceConfig.setDriverName(DATABASE_DRIVER);
        dataSourceConfig.setUsername(DATABASE_USERNAME);
        dataSourceConfig.setPassword(DATABASE_PASSWORD);
        mpg.setDataSource(dataSourceConfig);

        // 2.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir") + "/tiny-mbg";
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        // 作者
        if (!ObjectUtils.isEmpty(AUTHOR)) {
            globalConfig.setAuthor("knox");
        }
        // 是否覆盖已有文件
        globalConfig.setFileOverride(true);
        // 打开输出文件夹
        globalConfig.setOpen(false);
        // 开启实体属性 Swagger2 注解
        globalConfig.setSwagger2(true);
        // 开启 BaseResultMap
        globalConfig.setBaseResultMap(true);
        // 开启通用查询结果列
        globalConfig.setBaseColumnList(false);
        // 实体命名方式，默认null，例如：%sEntity 生成 UserEntity
        // globalConfig.setEntityName("%sEntity");
        // mapper 命名方式,默认值：null 例如：%sDao 生成 UserDao
        globalConfig.setMapperName("%sMapper");

        globalConfig.setIdType(IdType.ASSIGN_ID);
        mpg.setGlobalConfig(globalConfig);


        // 3.包配置
        PackageConfig packageConfig = new PackageConfig();
        // 业务模块
        packageConfig.setParent(scanner("包路径"));
        // 项目模块,如无不设置
        packageConfig.setModuleName(scanner("模块名").trim());
        mpg.setPackageInfo(packageConfig);

        // 4.自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/"
                        + packageConfig.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper"
                        + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(focList);
        mpg.setCfg(injectionConfig);

        // 5.配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 6.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自定义继承的Entity类全称，带包名
        // strategyConfig.setSuperEntityClass("");
        // 写于父类中的公共字段，如上面不配，这里也不配，否则id不生成
        // strategyConfig.setSuperEntityColumns("id");

        // 开启Lombok
        strategyConfig.setEntityLombokModel(true);
        // 是否为链式模型
        strategyConfig.setChainModel(true);
        // restController注解
        strategyConfig.setRestControllerStyle(true);
        // 是否生成实体时，生成字段注解
        strategyConfig.setEntityTableFieldAnnotationEnable(true);
        // 公共父类,如基类BaseController,你自己的父类控制器,没有就不用设置!
        if (!ObjectUtils.isEmpty(SUPER_CONTROLLER)) {
            strategyConfig.setSuperControllerClass("");
        }

        // 需要生成的表，若全部生成，可不配置
        String tables = scanner("表名，多个英文逗号分割；若生成全部表，请输入all");
        if (!"ALL".equalsIgnoreCase(tables)) {
            strategyConfig.setInclude(tables.trim().split(","));
        }
        // RequestMapping注解
        strategyConfig.setControllerMappingHyphenStyle(true);
        // 表前缀
        strategyConfig.setTablePrefix(packageConfig.getModuleName() + "_");

        mpg.setStrategy(strategyConfig);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
