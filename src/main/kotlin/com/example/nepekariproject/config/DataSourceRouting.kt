package com.example.nepekariproject.config

import org.springframework.context.annotation.DependsOn
import org.springframework.core.env.Environment
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.stereotype.Component
import javax.sql.DataSource


@Component
@DependsOn("environment")
class DataSourceRouting(
    private val dataSourceContextHolder: DataSourceContextHolder,
    private val env: Environment
) : AbstractRoutingDataSource() {
    init {
        val dataSourceMap: MutableMap<Any, Any> = HashMap()
        dataSourceMap[DataSourceEnum.DATA_SOURCE_UNKNOWN] = dataSourceUnknownConfig()
        dataSourceMap[DataSourceEnum.DATA_SOURCE_AUTH] = dataSourceAuthConfig()
        dataSourceMap[DataSourceEnum.DATA_SOURCE_ADMIN] = dataSourceAdminConfig()
        setTargetDataSources(dataSourceMap)
        setDefaultTargetDataSource(dataSourceAuthConfig())
    }

    override fun determineCurrentLookupKey(): Any? {
        return dataSourceContextHolder.getContext()
    }

    fun dataSourceUnknownConfig(): DataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.url = env.getRequiredProperty("db.dynamic.url")
        dataSource.username = "guest"
        dataSource.password = "guest"
        return dataSource.also { dataSourceCommonConfig(it) }
    }

    fun dataSourceAuthConfig(): DataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.url = env.getRequiredProperty("db.dynamic.url")
        dataSource.username = "authorized"
        dataSource.password = "authorized"
        return dataSource.also { dataSourceCommonConfig(it) }
    }

    fun dataSourceAdminConfig(): DataSource {
        val dataSource = DriverManagerDataSource()
        println(
            "\n\n\n\nrole::" + env.getRequiredProperty("connection.role") + "\n\n\n\n\n"
        )
        dataSource.url = env.getRequiredProperty("db.dynamic.url")
        dataSource.username = "admin"
        dataSource.password = "admin"
        return dataSource.also { dataSourceCommonConfig(it) }
    }

    fun dataSourceCommonConfig(ds: DriverManagerDataSource) = ds.apply {

        setDriverClassName("org.postgresql.Driver")
        catalog = "postgres"
        schema = "public"
    }
}