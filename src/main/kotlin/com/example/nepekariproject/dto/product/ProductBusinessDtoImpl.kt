package com.example.nepekariproject.dto.product

import com.example.nepekariproject.dto.bonus.BonusBusinessDto
import com.example.nepekariproject.dto.description.DescriptionBusinessDto
import org.springframework.stereotype.Component

@Component
class ProductBusinessDtoImpl(
    private var id: Long = 0L,
    private var name: String = "",
    private var cost: Double = 0.0,
    private var imageUrl: String = "",
    private var addDescr: DescriptionBusinessDto,
    private var bonus: List<BonusBusinessDto>? = null
): ProductBusinessDto {
    override fun getId() = id
    override fun getName() = name
    override fun getCost() = cost
    override fun getImgUrl() = imageUrl
    override fun getDescr() = addDescr
    override fun getBonuses() = bonus

    override fun equals(other: Any?): Boolean {
        val otherProduct = other as? ProductBusinessDto ?: return false
        return this.id == otherProduct.getId() &&
                this.name == otherProduct.getName() &&
                this.cost == otherProduct.getCost() &&
                this.imageUrl == otherProduct.getImgUrl()
    }
}