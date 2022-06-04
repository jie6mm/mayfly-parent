package com.jie6mm.mayfly.core.database.druid;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.jdbc.DataSourceBuilder;

/**
 * DruidDataSourceProperty
 *
 * @author jie6mm(刘杰)
 * @date 2022/6/2
 */
public class MayflyDruidDataSource {

    @SneakyThrows
    public static DruidDataSource getDruidDataSource(String address, String username, String password, String datasourceName) {
        if (StringUtils.isBlank(address)) {
            throw new NullPointerException("请指定数据库连接地址");
        }
        DataSourceBuilder<DruidDataSource> springDataSource = (DataSourceBuilder<DruidDataSource>) DataSourceBuilder.create();
        springDataSource.type(com.alibaba.druid.pool.DruidDataSource.class);
        springDataSource.driverClassName("com.mysql.cj.jdbc.Driver");
        springDataSource.url("jdbc:mysql://" + address + "/" + datasourceName);
        springDataSource.username(StringUtils.isBlank(username) ? "root" : username);
        springDataSource.password(StringUtils.isBlank(password) ? "root" : password);
        DruidDataSource druidDataSource = springDataSource.build();
        druidDataSource.setFilters("stat,wall,log4j2");
        return druidDataSource;
    }
}
