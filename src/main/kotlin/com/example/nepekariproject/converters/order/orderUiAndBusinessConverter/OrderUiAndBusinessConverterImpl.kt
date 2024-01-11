package com.example.nepekariproject.converters.order.orderUiAndBusinessConverter

import com.example.nepekariproject.converters.cake.cakeUiAndBusinessConverter.CakeUiAndBusinessConverter
import com.example.nepekariproject.converters.product.productUiAndBusinessConverter.ProductUiAndBusinessConverter
import com.example.nepekariproject.dao.cake.CakeDao
import com.example.nepekariproject.dao.product.ProductDao
import com.example.nepekariproject.dto.order.OrderBusinessDto
import com.example.nepekariproject.dto.order.OrderBusinessDtoImpl
import com.example.nepekariproject.dto.order.OrderUIDto
import com.example.nepekariproject.dto.order.rqcreate.CreateOrderRqUiDto
import com.example.nepekariproject.dto.user.UserBusinessDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class OrderUiAndBusinessConverterImpl: OrderUiAndBusinessConverter {
    @Autowired
    private lateinit var productConverter: ProductUiAndBusinessConverter

    @Autowired
    private lateinit var cakeConverter: CakeUiAndBusinessConverter

    @Autowired
    private lateinit var productDao: ProductDao

    @Autowired
    private lateinit var cakeDao: CakeDao

    override fun convert(
        uiDto: OrderUIDto,
        userDto: UserBusinessDto
    ) : OrderBusinessDto {
        val productsBusiness = uiDto.products.map {
            try { productDao.getProductById(it.id) }
            catch (ex: Exception) { throw Exception("Not valid product from catalog") }
        }

        val cakesBusiness = uiDto.cakes.map {
            try { cakeDao.getCakeByPartIds(it.base.id, it.filling.id, it.cream.id) }
            catch (ex: Exception) { throw Exception("Not valid cake") }
        }

        return OrderBusinessDtoImpl(
            orderId = uiDto.id,
            user = userDto,
            dateCreate = uiDto.dateCreate,
            dateExpiry = uiDto.dateExpiry,
            addressToSend = uiDto.addressToSend,
            description = uiDto.description,
            products = productsBusiness,
            cakes = cakesBusiness
        )
    }

    override fun convert(uiDto: CreateOrderRqUiDto, userDto: UserBusinessDto): OrderBusinessDto {
        val productsBusiness = uiDto.products.map {
            try { productDao.getProductById(it.id.toLong()) }
            catch (ex: Exception) { throw Exception("Not valid product from catalog") }
        }

        val cakesBusiness = uiDto.cakes.map {
            try { cakeDao.getCakeByPartIds(it.baseId.toLong(), it.fillingId.toLong(), it.creamId.toLong()) }
            catch (ex: Exception) { throw Exception("Not valid cake") }
        }

        return OrderBusinessDtoImpl(
            orderId = UUID.randomUUID().toString(),
            user = userDto,
            dateCreate = Date(),
            dateExpiry = Date(),
            addressToSend = uiDto.addressToSend,
            description = uiDto.description,
            products = productsBusiness,
            cakes = cakesBusiness
        )
    }

    override fun convert(businessDto: OrderBusinessDto) = OrderUIDto(
        id = businessDto.getOrderId(),
        dateCreate = businessDto.getDateCreate(),
        dateExpiry = businessDto.getDateExpiry(),
        addressToSend = businessDto.getAddressToSend(),
        description = businessDto.getDescription(),
        products = businessDto.getProducts().map { productConverter.convert(it) },
        cakes = businessDto.getCakes().map { cakeConverter.convert(it) },
        statusCode = businessDto.getStatusCode()
    )
}