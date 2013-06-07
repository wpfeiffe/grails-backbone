dataSource {
    pooled = true
    driverClassName = "org.postgresql.Driver"
    dialect = "org.hibernate.dialect.PostgreSQLDialect"
    username = "postgres"
    password = "postgres"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:postgresql://localhost:5432/Library"
        }
    }
    test {
        dataSource {
            dbCreate = "validate"
            url = "jdbc:postgresql://localhost:5432/Library"
        }
    }
    production {
        dataSource {
            dbCreate = "validate"
            url = "jdbc:postgresql://localhost:5432/Library"
            pooled = true
        }
    }
}
