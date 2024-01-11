package com.example.nepekariproject.dto.cakePart

import com.example.nepekariproject.dto.cake.CakeBusinessDto
import com.example.nepekariproject.dto.description.DescriptionBusinessDto
import com.example.nepekariproject.enumerations.CakePartType
import org.springframework.stereotype.Component

@Component
class CakePartBusinessDtoImpl(
    private var id: Long = 0,
    private var name: String = "",
    private var cost: Double = 0.0,
    private var type: CakePartType = CakePartType.BASE,
    private var description: DescriptionBusinessDto
): CakePartBusinessDto {
    override fun getId() = id
    override fun getName() = name
    override fun getCost() = cost
    override fun getType() = type
    override fun getDescription() = description

    override fun equals(other: Any?): Boolean {
        val otherPart = other as? CakePartBusinessDto ?: return false

        return this.id == otherPart.getId() &&
                this.name == otherPart.getName() &&
                this.cost == otherPart.getCost() &&
                this.type == otherPart.getType()
    }
}