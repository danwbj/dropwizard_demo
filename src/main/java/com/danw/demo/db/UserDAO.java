package com.danw.demo.db;

import com.danw.demo.core.User;
import com.danw.demo.core.UserG;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.helpers.MapResultAsBean;

import java.util.List;

public interface UserDAO {
    @SqlUpdate("create table t_user (id serial primary key, name varchar(100),age varchar(100))")
    void createSomethingTable();

    @SqlUpdate("insert into t_user (name,age,group_id) values (:name, :age, :group_id)")
    void insert(@BindBean User user);

    @SqlUpdate("update t_user set name = :name,age = :age,group_id = :group_id where id = :userId")
    void update(@Bind("userId") Long userId,@BindBean User user);

    @SqlQuery("select u.id,u.name,u.age,u.group_id,p.name as group_name from t_user u left join t_group p on u.group_id = p.id where u.id = :id ")
    @MapResultAsBean
    UserG findUserById(@Bind("id") Long id);

    @SqlQuery("select u.id,u.name,u.age,u.group_id,p.name as group_name from t_user u left join t_group p on u.group_id = p.id")
    @MapResultAsBean
    List<UserG> listUsers();

    @SqlUpdate("delete from t_user where id = :userId")
    void delete(@Bind("userId") Long userId);

}