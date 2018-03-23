package com.fantasykai.springboot.mybatisannotation.mapper;

import com.fantasykai.springboot.mybatisannotation.param.UserParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/23 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class UserSql {

    private static final Logger log = LoggerFactory.getLogger(UserSql.class);

    /**
     * Gets list.
     *
     * @param userParam the user param
     * @return the list
     */
    public String getList(UserParam userParam) {
        StringBuilder sql = new StringBuilder("select id, username, password, user_sex, nickname");
        sql.append(" from users where 1 = 1");
        if (null != userParam) {
            if (StringUtils.isNotBlank(userParam.getUsername())) {
                sql.append(" and username = #{username}");
            }
            if (StringUtils.isNotBlank(userParam.getUserSex())) {
                sql.append(" and user_sex = #{userSex}");
            }
        }

        sql.append(" order by id desc");
        sql.append(" limit " + userParam.getBeginLine() + "," + userParam.getPageSize());
        log.info("getList sql is : " + sql.toString());
        return sql.toString();
    }

    /**
     * Gets count.
     *
     * @param userParam the user param
     * @return the count
     */
    public String getCount(UserParam userParam) {
        String sql = new SQL() {{
            SELECT("count(1)");
            FROM("users");
            if (StringUtils.isNotBlank(userParam.getUsername())) {
                WHERE("username = #{username}");
            }
            if (StringUtils.isNotBlank(userParam.getUserSex())) {
                WHERE("user_sex = #{userSex}");
            }
        }}.toString();

        return sql;
    }


}
