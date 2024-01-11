package com.example.nepekariproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication


@SpringBootApplication
@EntityScan(basePackages = ["com.example.nepekariproject.entity"])
class NepekariProjectApplication

fun main(args: Array<String>) {
	//TODO выяснить, почему с включенной опцией приложение ломается при получении сущности из БД
	System.setProperty("spring.devtools.restart.enabled", "false")
	runApplication<NepekariProjectApplication>(*args)
}