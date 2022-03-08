package com.yw.ppp.uc.tool;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;

/**
 * @author zhangyaowen
 * @date 2021/10/23 8:23 上午
 */
public class CodeGenerator {

    public static void main(String[] args) {

       DataSourceConfig.Builder config =
               new DataSourceConfig.Builder("","","");
        FastAutoGenerator.create(config)
        .globalConfig(builder -> {
            builder.author("yaowen.zhang")
                    .fileOverride()
                    .enableSwagger()
                    .dateType(DateType.TIME_PACK)
                    .commentDate("yyyy-MM-dd")
                    .outputDir("");
        }).packageConfig(builder -> {
                    builder
                    .parent("com.baomidou.mybatisplus.samples.generator")
                    .moduleName("sys")
                    .entity("po")
                    .service("service")
                    .serviceImpl("service.impl")
                    .mapper("mapper")
                    .xml("mapper.xml")
                    .controller("controller")
                    .other("other")
                    .build();
        });


    }
}
