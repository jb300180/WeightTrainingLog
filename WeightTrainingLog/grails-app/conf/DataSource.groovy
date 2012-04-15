dataSource {
	pooled = true
	driverClassName = "org.h2.Driver"
	username = "sa"
	password = ""
}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = true
	cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
	naming_strategy =CustomNamingStrategy
}
// environment specific settings
environments {
	development {
		dataSource {
			dbCreate = "create-drop"
			//			dbCreate = "update"
			url = "jdbc:h2:db/dev;MVCC=TRUE"
			//			logSql = true
		}
	}
	test {
		dataSource {
			dbCreate = "update"
			url = "jdbc:h2:mem:testDb;MVCC=TRUE"
		}
	}
	// jb: beim deploy nach cloudfoundry wird prod ueberschrieben
	//     d.h. url, username, password
	production {
		dataSource {
			dialect= org.hibernate.dialect.MySQLInnoDBDialect
			driverClassName = "com.mysql.jdbc.Driver"
			//			dialect= org.hibernate.dialect.PostgreSQLDialect
			//			driverClassName = "org.postgresql.Driver"
			username = "n/a"
			password = "n/a"
			url = "n/a"
			dbCreate = "update"
		}
	}
}
