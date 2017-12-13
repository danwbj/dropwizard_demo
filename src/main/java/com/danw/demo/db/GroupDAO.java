package com.danw.demo.db;

import com.danw.demo.core.Group;
import com.danw.demo.core.GroupU;
import com.danw.demo.core.User;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.helpers.MapResultAsBean;

import java.util.List;

public interface GroupDAO {

    @SqlQuery("select * from t_group")
    @MapResultAsBean
    List<Group> list();

    @SqlQuery("select * from t_group where id = :id")
    @MapResultAsBean
    GroupU findById(@Bind("id") Long id);

    @SqlQuery("select * from t_user where group_id = :group_id")
    @MapResultAsBean
    List<User> findUsersByGroup(@Bind("group_id") Long group_id);

    default Object groupInfo(Long id){
        GroupU g =  findById(id);
        List<User> users =  findUsersByGroup(g.getId());
        g.setUsers(users);
        return g;


    }
}
