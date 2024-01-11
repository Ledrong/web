package com.example.nepekariproject.entity.product

import com.example.nepekariproject.entity.add_descr.DescrEntity
import javax.persistence.*

@Entity
@Table(name = "table_product", schema = "public", catalog = "postgres")
class ProductEntity(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    var id: Long,

    @OneToOne
    @JoinColumn(name = "product_add_descr_id", referencedColumnName = "add_descr_id")
    var addDescr: DescrEntity,

    @Basic
    @Column(name = "product_name")
    var name: String,

    @Basic
    @Column(name = "product_cost")
    var cost: Double,

    @Basic
    @Column(name = "product_img_name")
    var imgName: String? = null
) {
    override fun toString(): String {
        return "TableProductEntity(id=$id addDescrId=($addDescr) name=$name cost=$cost imgName=$imgName)"
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as ProductEntity
        if (id != that.id) return false
        if (addDescr != that.addDescr) return false
        if (if (name != null) name != that.name else that.name != null) return false
        if (if (cost != null) cost != that.cost else that.cost != null) return false
        return if (if (imgName != null) imgName != that.imgName else that.imgName != null) false else true
    }

    override fun hashCode(): Int {
        var result = (id xor (id ushr 32)).toInt()
        result = 31 * result + if (name != null) name.hashCode() else 0
        result = 31 * result + if (cost != null) cost.hashCode() else 0
        result = 31 * result + if (imgName != null) imgName.hashCode() else 0
        return result
    }
}