package com.danw.demo.db;

import com.danw.demo.core.Group;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.helpers.MapResultAsBean;

import java.util.List;

public interface GroupDAO {

    @SqlQuery("select * from t_group")
    @MapResultAsBean
    List<Group> list();
}
