/**
 * Copyright (c) 2011-2016, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.hq.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.*;

/**
 * <p>
 * 代码生成器演示
 * </p>
 *
 * @author hubin
 * @since 2016-12-01
 */
public class MysqlGenerator extends GeneratorTest {

    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        int result = scanner();
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
            // 全局配置
            new GlobalConfig()
                .setOutputDir("D:\\毕业设计\\travel\\src\\main\\java")//输出目录
                .setFileOverride(false)// 是否覆盖文件
                .setActiveRecord(true)// 开启 activeRecord 模式
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(true)// XML columList
                //.setKotlin(true) 是否生成 kotlin 代码
                .setAuthor("hq")
            // 自定义文件命名，注意 %s 会自动填充表实体属性！
            // .setEntityName("%sEntity");
             .setMapperName("%sDao")
            // .setXmlName("%sDao")
             .setServiceName("%sService")
             .setServiceImplName("%sServiceImpl")
            // .setControllerName("%sAction")
        ).setDataSource(
            // 数据源配置
            new DataSourceConfig()
                .setDbType(DbType.MYSQL)// 数据库类型
                //.setTypeConvert(new MySqlTypeConvert() {
                //    // 自定义数据库表字段类型转换【可选】
                //    @Override
                //    public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                //        System.out.println("转换类型：" + fieldType);
                //        // if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
                //        //    return DbColumnType.BOOLEAN;
                //        // }
                //        return super.processTypeConvert(globalConfig, fieldType);
                //    }
                //})
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("123456")
                .setUrl("jdbc:mysql://120.79.15.183:3306/travel?useUnicode=true&characterEncoding=UTF-8&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&useSSL=false")
        ).setStrategy(
            // 策略配置
            new StrategyConfig()
                // .setCapitalMode(true)// 全局大写命名
                // .setDbColumnUnderline(true)//全局下划线命名
                .setTablePrefix(new String[]{"travel_", "mp_"})// 此处可以修改为您的表前缀
                .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                // .setInclude(new String[] { "user" }) // 需要生成的表
                // .setExclude(new String[]{"test"}) // 排除生成的表
                // 自定义实体父类
                // .setSuperEntityClass("com.baomidou.demo.TestEntity")
                // 自定义实体，公共字段
                .setSuperEntityColumns(new String[]{"test_id"})
                .setTableFillList(tableFillList)
            // 自定义 mapper 父类
            // .setSuperMapperClass("com.baomidou.demo.TestMapper")
            // 自定义 service 父类
            // .setSuperServiceClass("com.baomidou.demo.TestService")
            // 自定义 service 实现类父类
            // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
            // 自定义 controller 父类
            // .setSuperControllerClass("com.baomidou.demo.TestController")
            // 【实体】是否生成字段常量（默认 false）
            // public static final String ID = "test_id";
            // .setEntityColumnConstant(true)
            // 【实体】是否为构建者模型（默认 false）
            // public User setName(String name) {this.name = name; return this;}
            // .setEntityBuilderModel(true)
            // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
            // .setEntityLombokModel(true)
            // Boolean类型字段是否移除is前缀处理
            // .setEntityBooleanColumnRemoveIsPrefix(true)
            // .setRestControllerStyle(true)
            // .setControllerMappingHyphenStyle(true)
        ).setPackageInfo(
            // 包配置
            new PackageConfig()
                .setModuleName("travel")
                .setParent("com.hq")// 自定义包路径
                .setController("controller")// 这里是控制器包名，默认 web
                .setEntity("Entity")
                .setMapper("Dao")
                .setService("Service")
                .setServiceImpl("Service.impl")
        ).setCfg(
            // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
            new InjectionConfig() {
                @Override
                public void initMap() {
                    Map<String, Object> map = new HashMap<>();
                    map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                    this.setMap(map);
                }
            }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig(
                "/templates/mapper.xml" + ((1 == result) ? ".ftl" : ".vm")) {
                // 自定义输出文件目录
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return "D:\\毕业设计\\travel\\src\\main\\resources\\mappers\\" + tableInfo.getEntityName() + "Mapper.xml";
                }
            }))
        ).setTemplate(
            // 关闭默认 xml 生成，调整生成 至 根目录
            new TemplateConfig().setXml(null)
            // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
            // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
            // .setController("...");
            // .setEntity("...");
            // .setMapper("...");
            // .setXml("...");
            // .setService("...");
            // .setServiceImpl("...");
        );
        // 执行生成
        if (1 == result) {
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        }
        mpg.execute();

        // 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }

}
