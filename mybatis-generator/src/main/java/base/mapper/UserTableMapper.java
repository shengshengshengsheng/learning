package base.mapper;

import base.model.UserTable;
import base.model.UserTableExample;
import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface UserTableMapper extends Serializable {
    @SelectProvider(type=UserTableSqlProvider.class, method="countByExample")
    int countByExample(UserTableExample example);

    @DeleteProvider(type=UserTableSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserTableExample example);

    @Delete({
        "delete from user_table",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
        "insert into user_table (user_id, user_name, ",
        "user_nick, user_age, ",
        "user_birth)",
        "values (#{userId,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR}, ",
        "#{userNick,jdbcType=VARCHAR}, #{userAge,jdbcType=INTEGER}, ",
        "#{userBirth,jdbcType=TIMESTAMP})"
    })
    int insert(UserTable record);

    @InsertProvider(type=UserTableSqlProvider.class, method="insertSelective")
    int insertSelective(UserTable record);

    @SelectProvider(type=UserTableSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_nick", property="userNick", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_age", property="userAge", jdbcType=JdbcType.INTEGER),
        @Result(column="user_birth", property="userBirth", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserTable> selectByExampleWithRowbounds(UserTableExample example, RowBounds rowBounds);

    @SelectProvider(type=UserTableSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_nick", property="userNick", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_age", property="userAge", jdbcType=JdbcType.INTEGER),
        @Result(column="user_birth", property="userBirth", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserTable> selectByExample(UserTableExample example);

    @Select({
        "select",
        "user_id, user_name, user_nick, user_age, user_birth",
        "from user_table",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_nick", property="userNick", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_age", property="userAge", jdbcType=JdbcType.INTEGER),
        @Result(column="user_birth", property="userBirth", jdbcType=JdbcType.TIMESTAMP)
    })
    UserTable selectByPrimaryKey(Integer userId);

    @UpdateProvider(type=UserTableSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserTable record, @Param("example") UserTableExample example);

    @UpdateProvider(type=UserTableSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserTable record, @Param("example") UserTableExample example);

    @UpdateProvider(type=UserTableSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserTable record);

    @Update({
        "update user_table",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "user_nick = #{userNick,jdbcType=VARCHAR},",
          "user_age = #{userAge,jdbcType=INTEGER},",
          "user_birth = #{userBirth,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserTable record);
}