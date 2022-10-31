package com.uta.sie.mbg;

import java.io.InputStream;
import java.util.ArrayList;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jadon
 */
@Slf4j
public class Generator {
    public static void main(String[] args) throws Exception {
        ArrayList<String> warnings = new ArrayList<>();
        boolean overwrite = true;

        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration configuration = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration,callback,warnings);

        myBatisGenerator.generate(null);
        for (String warning : warnings) {
            log.info(warning);
        }
    }
}
