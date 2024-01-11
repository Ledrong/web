package com.example.nepekariproject.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.*
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.io.IOException
import java.util.*
import javax.annotation.Resource
import javax.sql.DataSource


@Configuration
@EnableJpaRepositories(basePackages =  ["com.example.nepekariproject.repository"],
    transactionManagerRef = "transcationManager",
    entityManagerFactoryRef = "entityManager")
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScan("com.example.nepekariproject")
@DependsOn("dataSourceRouting")
class DataBaseConfig(
    private val dataSourceRouting: DataSourceRouting
) {
    @Resource
    private lateinit var env: Environment

    /*@Bean
    fun entityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        //println("\n\n\n\n${env.getRequiredProperty("my.property")}\n\n\n\n\n")
        val emf = LocalContainerEntityManagerFactoryBean()
        emf.dataSource = dataSource()
        emf.setPackagesToScan(env.getRequiredProperty("db.entity.package"))
        emf.jpaVendorAdapter = HibernateJpaVendorAdapter()
        emf.setJpaProperties(getHibernateProperties())

        return emf
    }

    @Bean
    fun transactionManager(): PlatformTransactionManager {
        val tm = JpaTransactionManager()
        tm.entityManagerFactory = entityManagerFactory().`object`

        return tm
    }

    @Bean
    fun dataSource(): DataSource {
        val ds = BasicDataSource()

        ds.url = env.getRequiredProperty("db.dynamic.url")
        ds.driverClassName = env.getRequiredProperty("db.driver")
        ds.username = env.getRequiredProperty("db.username")
        ds.password = env.getRequiredProperty("db.password")

        ds.initialSize = env.getRequiredProperty("db.initialSize").toInt()
        ds.minIdle = env.getRequiredProperty("db.minIdle").toInt()
        ds.maxIdle = env.getRequiredProperty("db.maxIdle").toInt()
        ds.timeBetweenEvictionRunsMillis = env.getRequiredProperty("db.timeBetweenEvictionRunsMills").toLong()
        ds.minEvictableIdleTimeMillis = env.getRequiredProperty("db.minEvictableIdleTimeMills").toLong()
        ds.testOnBorrow = env.getRequiredProperty("db.testOnBorrow").toBoolean()
        ds.validationQuery = env.getRequiredProperty("db.validationQuery")

        return ds
    }

    private fun getHibernateProperties(): Properties {
        try {
            val prop = Properties()
            val inStr = javaClass.classLoader.getResourceAsStream("hibernate.properties")
            prop.load(inStr)

            return prop
        } catch (ex: IOException) {
            throw IllegalArgumentException("Cant find file hibernate.properties", ex)
        }
    }*/

    @Bean
    @Primary
    fun dataSource(): DataSource? {
        return dataSourceRouting
    }

    @Bean(name = ["entityManager"])
    fun entityManagerFactoryBean(builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean? {
        return builder
            .dataSource(dataSource())
            .packages("com.example.nepekariproject")
            .build().apply {
                jpaVendorAdapter = HibernateJpaVendorAdapter()
                setJpaProperties(getHibernateProperties())
            }
    }

    @Bean(name = ["transcationManager"])
    fun transactionManager(
        @Autowired @Qualifier("entityManager") entityManagerFactoryBean: LocalContainerEntityManagerFactoryBean
    ): JpaTransactionManager {
        return JpaTransactionManager(entityManagerFactoryBean.getObject()!!)
    }

    private fun getHibernateProperties(): Properties {
        try {
            val prop = Properties()
            val inStr = javaClass.classLoader.getResourceAsStream("hibernate.properties")
            prop.load(inStr)

            return prop
        } catch (ex: IOException) {
            throw IllegalArgumentException("Cant find file hibernate.properties", ex)
        }
    }
}