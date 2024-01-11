package com.example.nepekariproject.dao

import org.junit.jupiter.api.BeforeAll
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName


abstract class AbstractTestcontainersTest {
    companion object {

        private val postgresContainer = PostgreSQLContainer(DockerImageName.parse("postgres:9"))
            .apply {
                this.withDatabaseName("testDb")
                    .withUsername("root")
                    .withPassword("123456")
                    .withInitScript("database/init/init_test_db.sql")
            }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("db.url", Companion::jdbcUrl)
            registry.add("db.username", postgresContainer::getUsername)
            registry.add("db.password", postgresContainer::getPassword)
        }

        fun jdbcUrl(): String {
            return "jdbc:postgresql://" +
                    "${postgresContainer.host}:${postgresContainer.getMappedPort(PostgreSQLContainer.POSTGRESQL_PORT)}/" +
                    "${postgresContainer.databaseName}"
        }

        @JvmStatic
        @BeforeAll
        internal fun setUp() {
            postgresContainer.start()
        }
    }

}