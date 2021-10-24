package com.yw.ppp.uc.tool;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

/**
 * @author zhangyaowen
 * @date 2021/10/23 8:23 上午
 */
public class CodeGenerator {

    public static void main(String[] args) {

       DataSourceConfig.Builder config =
               new DataSourceConfig.Builder("","","");
        FastAutoGenerator.create(config);


    }
}
