package com.example.nepekariproject.controllers

import com.example.nepekariproject.config.DataSourceContextHolder
import com.example.nepekariproject.config.DataSourceEnum
import com.example.nepekariproject.converters.cakePart.cakePartUiAndBusinessConverter.CakePartUiAndBusinessConverter
import com.example.nepekariproject.converters.product.productUiAndBusinessConverter.ProductUiAndBusinessConverter
import com.example.nepekariproject.dto.responseControllers.CatalogGetCakeRs
import com.example.nepekariproject.dto.responseControllers.CatalogGetProductsRs
import com.example.nepekariproject.services.product.ProductService
import com.example.nepekariproject.util.PageItemsConstant
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource


@RestController
@RequestMapping("/catalog")
class CatalogController {
    @Autowired
    private lateinit var productService: ProductService

    @Autowired
    private lateinit var productConverter: ProductUiAndBusinessConverter

    @Autowired
    private lateinit var cakePartConverter: CakePartUiAndBusinessConverter

    @Autowired
    private lateinit var dataSourceContextHolder: DataSourceContextHolder

    @Resource
    private lateinit var env: Environment

    private val logger = LogManager.getLogger(CatalogController::class.java)

    @CrossOrigin
    @GetMapping("/products")
    fun getProducts(
        @RequestParam("page") page: Int
    ): CatalogGetProductsRs {
        if (env.getRequiredProperty("connection.role") == "admin")
            dataSourceContextHolder.setContext(DataSourceEnum.DATA_SOURCE_ADMIN)
        else
            dataSourceContextHolder.setContext(DataSourceEnum.DATA_SOURCE_AUTH)

        return CatalogGetProductsRs(
            PageItemsConstant.amountItemsInProductPage,
            productService.getProductCatalog(page).map { productConverter.convert(it) }
        ).also {
            dataSourceContextHolder.clearContext()
        }
    }

    @CrossOrigin
    @GetMapping("/cakes")
    fun getCakesItems(): CatalogGetCakeRs {
        if (env.getRequiredProperty("connection.role") == "admin")
            dataSourceContextHolder.setContext(DataSourceEnum.DATA_SOURCE_ADMIN)
        else
            dataSourceContextHolder.setContext(DataSourceEnum.DATA_SOURCE_AUTH)

        return CatalogGetCakeRs(
            productService.getAllCakeParts().map { cakePartConverter.convert(it) }
        ).also {
            dataSourceContextHolder.clearContext()
        }
    }
}