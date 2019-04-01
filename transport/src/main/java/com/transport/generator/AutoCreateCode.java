package com.transport.generator;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;


/**
 * @author zhenglb
 * @time 2019/3/22 11:11
 * @description MyBatisPlus 自动生成代码
 */
public class AutoCreateCode {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("D:\\work\\transport\\transport\\src\\main\\java");
        gc.setAuthor("zhenglb");
        gc.setOpen(false);
        gc.setSwagger2(true);
        gc.setIdType(IdType.AUTO);
        gc.setBaseResultMap(true);
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/transport_test?useSSL=false&useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.transport")
                .setMapper("mapper")
                .setService("service")
                .setServiceImpl("service.impl")
                .setController("controller")
                .setEntity("domain");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 表名生成策略(下划线转驼峰命名)
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 列名生成策略(下划线转驼峰命名)
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 是否启动Lombok配置
        strategy.setEntityLombokModel(true);
        // 是否启动REST风格配置
        strategy.setRestControllerStyle(true);
        // 自定义实体父类
        strategy.setSuperEntityClass("com.baomidou.mybatisplus.extension.activerecord.Model");
        // 自定义service父接口
        strategy.setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService");
        // 自定义service实现类
        strategy.setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
        // 自定义mapper接口
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");
        strategy.setInclude(scanner("表名"));
        strategy.setSuperEntityColumns("id");
        mpg.setStrategy(strategy);

        // 执行
        mpg.execute();

    }
}
