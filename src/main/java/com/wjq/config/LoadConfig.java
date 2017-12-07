package com.wjq.config;

import com.blade.Blade;
import com.blade.event.BeanProcessor;
import com.blade.ioc.annotation.Bean;
import com.blade.jdbc.Base;
import com.blade.mvc.Const;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.stream.Collectors;

@Slf4j
@Bean
public class LoadConfig implements BeanProcessor {

//    public static final String DB_NAME = "test.db";
    public static final String DB_NAME = "tale.db";

    @Override
    public void processor(Blade blade) {
//        Base.open("jdbc:mysql://127.0.0.1:3306/app", "root", "123456");
        Base.open("jdbc:sqlite::resource:db/" + DB_NAME, "", "");
    }

    /**
     * 测试连接并导入数据库
     */
    public static void importSql() {
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (Exception e) {
                log.error("load sqlite driver error", e);
            }
            String DB_SRC = "jdbc:sqlite::resource:db/tele.db";
            Connection con       = DriverManager.getConnection(DB_SRC);
            Statement statement = con.createStatement();
            ResultSet rs        = statement.executeQuery("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='t_options'");
            int        count     = rs.getInt(1);
            if (count == 0) {

            }
            rs.close();
            statement.close();
            con.close();
        } catch (Exception e) {
            log.error("initialize database fail", e);
        }
    }

    public static void main(String[] args){
        importSql();
    }

}