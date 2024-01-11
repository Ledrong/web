package com.example.nepekariproject.validation

import com.example.nepekariproject.dto.bonus.BonusBusinessDtoImpl
import com.example.nepekariproject.dto.cake.CakeBusinessDtoImpl
import com.example.nepekariproject.dto.cakePart.CakePartBusinessDto
import com.example.nepekariproject.dto.cakePart.CakePartBusinessDtoImpl
import com.example.nepekariproject.dto.description.DescriptionBusinessDtoImpl
import com.example.nepekariproject.dto.order.OrderBusinessDtoImpl
import com.example.nepekariproject.dto.product.ProductBusinessDto
import com.example.nepekariproject.dto.product.ProductBusinessDtoImpl
import com.example.nepekariproject.dto.user.UserBusinessDtoImpl
import com.example.nepekariproject.enumerations.CakePartType
import com.example.nepekariproject.services.order.OrderService
import com.example.nepekariproject.services.product.ProductService
import com.example.nepekariproject.services.user.UserService
import com.example.nepekariproject.services.validation.order.OrderValidationServiceImpl
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class OrderValidationServiceImplTest {
    @InjectMockKs
    private lateinit var orderValidationService: OrderValidationServiceImpl

    @MockK
    private lateinit var productService: ProductService

    @MockK
    private lateinit var userService: UserService

    @MockK
    private lateinit var orderService: OrderService

    private val cakeBaseParts = listOf<CakePartBusinessDto>(
        CakePartBusinessDtoImpl(
            id = 1,
            name = "База1",
            cost = 1.0,
            type = CakePartType.BASE,
            description = DescriptionBusinessDtoImpl()
        ),
        CakePartBusinessDtoImpl(
            id = 2,
            name = "База2",
            cost = 2.0,
            type = CakePartType.BASE,
            description = DescriptionBusinessDtoImpl()
        ),
    )

    private val creamParts = listOf<CakePartBusinessDto>(
        CakePartBusinessDtoImpl(
            id = 3,
            name = "Крем1",
            cost = 1.0,
            type = CakePartType.CREAM,
            description = DescriptionBusinessDtoImpl()
        ),
        CakePartBusinessDtoImpl(
            id = 4,
            name = "Крем2",
            cost = 2.0,
            type = CakePartType.CREAM,
            description = DescriptionBusinessDtoImpl()
        ),
    )

    private val fillingParts = listOf<CakePartBusinessDto>(
        CakePartBusinessDtoImpl(
            id = 5,
            name = "Начинка1",
            cost = 1.0,
            type = CakePartType.FILLING,
            description = DescriptionBusinessDtoImpl()
        ),
        CakePartBusinessDtoImpl(
            id = 6,
            name = "Начинка2",
            cost = 2.0,
            type = CakePartType.FILLING,
            description = DescriptionBusinessDtoImpl()
        ),
    )

    private val productCatalog = listOf<ProductBusinessDto>(
        ProductBusinessDtoImpl(
            id = 1,
            name = "хлеб1",
            cost = 1.0,
            imageUrl = "someUrl",
            addDescr = DescriptionBusinessDtoImpl(),
            bonus = emptyList()
        ),
        ProductBusinessDtoImpl(
            id = 2,
            name = "хлеб2",
            cost = 2.0,
            imageUrl = "someUrl2",
            addDescr = DescriptionBusinessDtoImpl(),
            bonus = listOf(
                BonusBusinessDtoImpl(
                    1,
                   10.0,
                    true
                )
            )
        )
    )

    private val userDto = UserBusinessDtoImpl(
        123,
        "login",
        "password",
        "Ivan",
        "Ivanov",
        "Ivanovich"
    )

    @BeforeTest
    fun initMock() {
        MockKAnnotations.init(this)
        every { productService.getCakeBaseParts() } returns cakeBaseParts
        every { productService.getCakeCreamParts() } returns creamParts
        every { productService.getCakeFillingParts() } returns fillingParts
        every { productService.getProductCatalog() } returns productCatalog
    }

    @Test
    fun positiveTest() {
        val orderId = "1"

        every { userService.getUser(userDto.getId()) } returns userDto
        every { orderService.getOrder(orderId) } returns null

        val orderDto = OrderBusinessDtoImpl(
            orderId = orderId,
            user = userDto,
            products = listOf(
                ProductBusinessDtoImpl(
                    id = 2,
                    name = "хлеб2",
                    cost = 2.0,
                    imageUrl = "someUrl2",
                    addDescr = DescriptionBusinessDtoImpl(),
                    bonus = listOf(
                        BonusBusinessDtoImpl(
                            1,
                            10.0,
                            true
                        )
                    )
                )
            ),
            cakes = listOf(
                CakeBusinessDtoImpl(
                    base = cakeBaseParts[0],
                    cream = creamParts[0],
                    filling = fillingParts[0]
                )
            )
        )

        assertTrue { orderValidationService.isCorrectOrder(orderDto) }
    }

    @Test
    fun negativeUserDataTest() {
        val orderId = "1"

        every { userService.getUser(userDto.getId()) } returns UserBusinessDtoImpl(
            456,
            "login",
            "password",
            "Ivan",
            "Ivanov",
            "Ivanovich"
        )
        every { orderService.getOrder(orderId) } returns null

        val orderDto = OrderBusinessDtoImpl(
            orderId = orderId,
            user = userDto,
            products = listOf(
                ProductBusinessDtoImpl(
                    id = 2,
                    name = "хлеб2",
                    cost = 2.0,
                    imageUrl = "someUrl2",
                    addDescr = DescriptionBusinessDtoImpl(),
                    bonus = listOf(
                        BonusBusinessDtoImpl(
                            1,
                            10.0,
                            true
                        )
                    )
                )
            ),
            cakes = listOf(
                CakeBusinessDtoImpl(
                    base = cakeBaseParts[0],
                    cream = creamParts[0],
                    filling = fillingParts[0]
                )
            )
        )

        assertFalse { orderValidationService.isCorrectOrder(orderDto) }
    }

    @Test
    fun negativeExistsOrderTest() {
        val orderId = "1"
        val orderDto = OrderBusinessDtoImpl(
            orderId = orderId,
            user = userDto,
            products = listOf(
                ProductBusinessDtoImpl(
                    id = 2,
                    name = "хлеб2",
                    cost = 2.0,
                    imageUrl = "someUrl2",
                    addDescr = DescriptionBusinessDtoImpl(),
                    bonus = listOf(
                        BonusBusinessDtoImpl(
                            1,
                            10.0,
                            true
                        )
                    )
                )
            ),
            cakes = listOf(
                CakeBusinessDtoImpl(
                    base = cakeBaseParts[0],
                    cream = creamParts[0],
                    filling = fillingParts[0]
                )
            )
        )

        every { userService.getUser(userDto.getId()) } returns userDto
        every { orderService.getOrder(orderId) } returns  orderDto



        assertFalse { orderValidationService.isCorrectOrder(orderDto) }
    }

    @Test
    fun negativeNotFoundProductTest() {
        val orderId = "1"
        val orderDto = OrderBusinessDtoImpl(
            orderId = orderId,
            user = userDto,
            products = listOf(
                ProductBusinessDtoImpl(
                    id = 2,
                    name = "хлеб2",
                    cost = 7.0,
                    imageUrl = "someUrl2",
                    addDescr = DescriptionBusinessDtoImpl(),
                    bonus = listOf(
                        BonusBusinessDtoImpl(
                            1,
                            10.0,
                            true
                        )
                    )
                )
            ),
            cakes = listOf(
                CakeBusinessDtoImpl(
                    base = cakeBaseParts[0],
                    cream = creamParts[0],
                    filling = fillingParts[0]
                )
            )
        )

        every { userService.getUser(userDto.getId()) } returns userDto
        every { orderService.getOrder(orderId) } returns  orderDto



        assertFalse { orderValidationService.isCorrectOrder(orderDto) }
    }

    @Test
    fun negativeNotFoundPartCakeTest() {
        val orderId = "1"
        val orderDto = OrderBusinessDtoImpl(
            orderId = orderId,
            user = userDto,
            products = listOf(
                ProductBusinessDtoImpl(
                    id = 2,
                    name = "хлеб2",
                    cost = 7.0,
                    imageUrl = "someUrl2",
                    addDescr = DescriptionBusinessDtoImpl(),
                    bonus = listOf(
                        BonusBusinessDtoImpl(
                            1,
                            10.0,
                            true
                        )
                    )
                )
            ),
            cakes = listOf(
                CakeBusinessDtoImpl(
                    base = CakePartBusinessDtoImpl(
                        id = 999,
                        name = "Unknown",
                        description = DescriptionBusinessDtoImpl()
                    ),
                    cream = creamParts[0],
                    filling = fillingParts[0]
                )
            )
        )

        every { userService.getUser(userDto.getId()) } returns userDto
        every { orderService.getOrder(orderId) } returns  orderDto



        assertFalse { orderValidationService.isCorrectOrder(orderDto) }
    }
}