package com.danw.demo;

import com.danw.demo.db.GroupDAO;
import com.danw.demo.resource.GroupResource;
import com.danw.demo.resource.HelloWorldResource;
import com.danw.demo.core.User;
import com.danw.demo.db.UserDAO;
import com.danw.demo.resource.UserResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
//import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.migrations.MigrationsBundle;
import org.skife.jdbi.v2.DBI;

/**
 * Hello world!
 *
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

//    private final HibernateBundle<HelloWorldConfiguration> hibernate = new HibernateBundle<HelloWorldConfiguration>(User.class) {
//        @Override
//        public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration configuration) {
//            return configuration.getDataSourceFactory();
//        }
//    };

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
//        bootstrap.addBundle(hibernate);
        /**
         * 清理数据库重构的包装器
         */
        bootstrap.addBundle(new MigrationsBundle<HelloWorldConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );

        //dropwizard-hibernate
//        final UserDAO dao = new UserDAO(hibernate.getSessionFactory());
//        environment.jersey().register(new UserResource(dao));

        //dropwizard-jdbi
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final UserDAO dao = jdbi.onDemand(UserDAO.class);
        environment.jersey().register(new UserResource(dao));
        final GroupDAO g_dao = jdbi.onDemand(GroupDAO.class);
        environment.jersey().register(new GroupResource(g_dao));
    }

}
