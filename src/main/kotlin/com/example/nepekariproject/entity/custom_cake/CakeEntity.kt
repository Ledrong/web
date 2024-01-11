package com.example.nepekariproject.entity.custom_cake

import com.example.nepekariproject.entity.cake_part.CakePartEntity
import javax.persistence.*

@Entity
@Table(name = "table_custom_cake", schema = "public", catalog = "postgres")
class CakeEntity(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "custom_cake_id")
    var id: Long,

    @OneToOne
    @JoinColumn(name = "custom_cake_base_part_id", referencedColumnName = "cake_part_id")
    var basePart: CakePartEntity,

    @OneToOne
    @JoinColumn(name = "custom_cake_filling_part_id", referencedColumnName = "cake_part_id")
    var fillingPart: CakePartEntity,

    @OneToOne
    @JoinColumn(name = "custom_cake_cream_part_id", referencedColumnName = "cake_part_id")
    var creamPart: CakePartEntity,
) {
    override fun toString(): String {
        return "TableCustomCakeEntity(id=$id basePartId=($basePart) fillingPartId=($fillingPart) " +
                "creamPartId=($creamPart))"
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as CakeEntity
        if (id != that.id) return false
        if (basePart != that.basePart) return false
        if (fillingPart != that.fillingPart) return false
        return if (creamPart != that.creamPart) false else true
    }

    override fun hashCode(): Int {
        var result = (id xor (id ushr 32)).toInt()
        result = 31 * result + (basePart.id xor (basePart.id ushr 32)).toInt()
        result = 31 * result + (fillingPart.id xor (fillingPart.id ushr 32)).toInt()
        result = 31 * result + (creamPart.id xor (creamPart.id ushr 32)).toInt()
        return result
    }
}