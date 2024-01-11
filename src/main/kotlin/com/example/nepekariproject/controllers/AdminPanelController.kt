package com.example.nepekariproject.controllers
/*
import com.example.nepekariproject.converters.cake.cakeUiAndBusinessConverter.CakeUiAndBusinessConverter
import com.example.nepekariproject.converters.cakePart.cakePartUiAndBusinessConverter.CakePartUiAndBusinessConverter
import com.example.nepekariproject.converters.product.productUiAndBusinessConverter.ProductUiAndBusinessConverter
import com.example.nepekariproject.dto.cake.CakeUIDto
import com.example.nepekariproject.dto.cakePart.CakePartUIDto
import com.example.nepekariproject.dto.product.ProductUIDto
import com.example.nepekariproject.services.product.ProductService
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@RestController
@RequestMapping("/admin")
class AdminPanelController {
    @Autowired
    private lateinit var productService: ProductService

    @Autowired
    private lateinit var productConverter: ProductUiAndBusinessConverter

    @Autowired
    private lateinit var cakeConverter: CakeUiAndBusinessConverter

    @Autowired
    private lateinit var cakePartConverter: CakePartUiAndBusinessConverter

    private val logger = LogManager.getLogger(OrderController::class.java)

    @GetMapping
    fun getInfoPage(): ModelAndView {
        logger.debug("in getInfo page")
        val productsCatalog = productService.getProductCatalog().map { productConverter.convert(it) }
        val cakes = productService.getAllCakes().map { cakeConverter.convert(it) }
        val baseParts = productService.getCakeBaseParts().map { cakePartConverter.convert(it) }
        val fillingParts = productService.getCakeFillingParts().map { cakePartConverter.convert(it) }
        val creamParts = productService.getCakeCreamParts().map { cakePartConverter.convert(it) }

        return ModelAndView().apply {
            viewName = "admin"
            addObject("products", productsCatalog)
            addObject("baseParts", baseParts)
            addObject("fillingParts", fillingParts)
            addObject("creamParts", creamParts)
            addObject("cakes", cakes)
            addObject("newProduct", ProductUIDto(0, "", 0.0, ""))
            addObject("newCakePart", CakePartUIDto(0, "", 0.0, 0))
        }
    }

    @PostMapping("createProduct")
    fun createNewProduct(
        @ModelAttribute("newProduct") productUiDto: ProductUIDto,
        model: Model
    ): ModelAndView {
        logger.debug("in createNewProduct")
        productService.addProduct(productConverter.convert(productUiDto))

        return ModelAndView().apply {
            viewName = "redirect:/admin/"
        }
    }

    @PostMapping("deleteProduct")
    fun deleteProduct(
        @RequestParam("idProduct") productId: Int
    ) : ModelAndView {
        logger.debug("in deleteProduct")

        productService.deleteProduct(productId.toLong())

        return ModelAndView().apply {
            viewName = "redirect:/admin/"
        }
    }

    @PostMapping("addCakePart")
    fun addCakePart(
        @ModelAttribute("newCakePart") cakePartUIDto: CakePartUIDto
    ): ModelAndView {
        logger.debug("in addCakePart")
        logger.debug("Type part=${cakePartUIDto.type}")
        productService.addCakePart(cakePartConverter.convert(cakePartUIDto))

        return ModelAndView().apply {
            viewName = "redirect:/admin/"
        }
    }

    @PostMapping("deleteCakePart")
    fun deleteCakePart(
        @RequestParam("idCakePart") cakePartId: Int
    ) : ModelAndView {
        logger.debug("in deleteCakePart")

        productService.deleteCakePart(cakePartId.toLong())

        return ModelAndView().apply {
            viewName = "redirect:/admin/"
        }
    }

    @PostMapping("addCake")
    fun addCake(
        @RequestParam("idBasePart") baseId: Int,
        @RequestParam("idFillingPart") fillingId: Int,
        @RequestParam("idCreamPart") creamId: Int
    ): ModelAndView {
        logger.debug("in addCake")

        val cakeUIDto = CakeUIDto(
            CakePartUIDto(baseId.toLong(), "", 0.0, 0),
            CakePartUIDto(fillingId.toLong(), "", 0.0, 0),
            CakePartUIDto(creamId.toLong(), "", 0.0, 0)
        )
        productService.addCake(cakeConverter.convert(cakeUIDto))

        return ModelAndView().apply {
            viewName = "redirect:/admin/"
        }
    }

    @PostMapping("deleteCake")
    fun deleteCake(
        @RequestParam("idCake") cakeId: Int
    ) : ModelAndView {
        logger.debug("in deleteCake")

        productService.deleteCake(cakeId.toLong())

        return ModelAndView().apply {
            viewName = "redirect:/admin/"
        }
    }
}*/