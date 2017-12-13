package com.danw.demo.db;

import com.danw.demo.core.User;
import com.danw.demo.core.UserG;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.helpers.MapResultAsBean;

import java.util.List;

public abstract class UserDAO {

    @SqlUpdate("create table t_user (id serial primary key, name varchar(100),age varchar(100))")
    public abstract void createSomethingTable();

    @SqlUpdate("insert into t_user (name,age,group_id) values (:name, :age, :group_id)")
    public abstract void insert(@BindBean User user);

    @SqlUpdate("update t_user set name = :name,age = :age,group_id = :group_id where id = :userId")
    public abstract void update(@Bind("userId") Long userId,@BindBean User user);

    @SqlQuery("select u.id,u.name,u.age,u.group_id,p.name as group_name from t_user u left join t_group p on u.group_id = p.id where u.id = :id ")
    @MapResultAsBean
    public abstract UserG findUserById(@Bind("id") Long id);

    @SqlQuery("select u.id,u.name,u.age,u.group_id,p.name as group_name from t_user u left join t_group p on u.group_id = p.id")
    @MapResultAsBean
    public abstract List<UserG> listUsers();

    @SqlUpdate("delete from t_user where id = :userId")
    public abstract void delete(@Bind("userId") Long userId);

    @Transaction
    public void d_c(Long userId,User user){
        delete(userId);
        insert(user);
    }

    @SqlQuery("select * from t_user where group_id = :group_id")
    @MapResultAsBean
    public abstract List<User> findUsersByGroup(@Bind("group_id") Long group_id);
}