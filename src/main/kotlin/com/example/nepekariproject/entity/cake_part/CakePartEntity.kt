package com.example.nepekariproject.entity.cake_part

import com.example.nepekariproject.entity.add_descr.DescrEntity
import javax.persistence.*

@Entity
@Table(name = "table_cake_part", schema = "public", catalog = "postgres")
class CakePartEntity(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cake_part_id")
    var id: Long,

    @Basic
    @Column(name = "cake_part_name")
    var name: String,

    @Basic
    @Column(name = "cake_part_cost")
    var cost: Double,

    @Basic
    @Column(name = "cake_part_type")
    var type: Int,

    @OneToOne
    @JoinColumn(name = "cake_part_add_descr_id", referencedColumnName = "add_descr_id")
    var addDescr: DescrEntity,
) {
    override fun toString(): String {
        return "TableCakePartEntity(id=$id name=$name cost=$cost type=$type addDescrId=($addDescr))"
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as CakePartEntity
        if (id != that.id) return false
        if (if (addDescr != null) addDescr != that.addDescr else that.addDescr != null) return false
        if (if (name != null) name != that.name else that.name != null) return false
        if (if (cost != null) cost != that.cost else that.cost != null) return false
        return if (if (type != null) type != that.type else that.type != null) false else true
    }

    override fun hashCode(): Int {
        var result = (id xor (id ushr 32)).toInt()
        result = 31 * result + if (name != null) name.hashCode() else 0
        result = 31 * result + if (cost != null) cost.hashCode() else 0
        result = 31 * result + if (type != null) type.hashCode() else 0
        return result
    }
}