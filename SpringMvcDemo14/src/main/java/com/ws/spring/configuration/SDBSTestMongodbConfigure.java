package com.ws.spring.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


/**
 * Created by laowang on 16-10-21.
 */
@EnableMongoAuditing
@PropertySource("classpath:mongodb.properties")
public class SDBSTestMongodbConfigure extends AbstractMongoConfiguration {

    @Value("${}")
    private String connectionString;

    @Value("${mongo.dbName}")
    private String dbName;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        MongoClientURI mongoClientURI = new MongoClientURI(connectionString);
        return new MongoClient(mongoClientURI);
    }

    //这里是一个配置类,这里配置的是连接数据库的操作,那么如果我要在SDBSTestDaoImpl里面进行操作的话,是进行怎样操作,直接调用template吗


//    @Override
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception{
//        MongoDbFactory factory = mongoDbFactory();
//        MongoMappingContext mongoMappingContext = new MongoMappingContext();
//        mongoMappingContext.setApplicationContext(applicationContext);
//
//        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(factory),mongoMappingContext);
//        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//
//        return new MongoTemplate(factory,converter);
//    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
