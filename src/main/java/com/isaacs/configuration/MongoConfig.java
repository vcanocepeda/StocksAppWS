package com.isaacs.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

@Configuration
//@ComponentScan
@EnableMongoRepositories(basePackages = "com.isaacs.dao")
public class MongoConfig extends AbstractMongoConfiguration {

//	@Autowired
//	private List<Converter<?, ?>> converters;

	@Override
	protected String getDatabaseName() {
		return "stocks";
	}
	 
	@Override
	public Mongo mongo() throws Exception {

		/* Mongo mongo = new Mongo();
		mongo.setWriteConcern(WriteConcern.SAFE);
		return mongo; */
		
		return new MongoClient("127.0.0.1");
	}

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#customConversions()
	
	@Override
	public CustomConversions customConversions() {
		return new CustomConversions(converters);
	} */
}