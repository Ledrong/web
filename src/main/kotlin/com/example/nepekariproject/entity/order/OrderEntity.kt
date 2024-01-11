package com.example.nepekariproject.entity.order

import com.example.nepekariproject.entity.custom_cake.CakeEntity
import com.example.nepekariproject.entity.product.ProductEntity
import com.example.nepekariproject.entity.user.UserEntity
import java.sql.Date
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "table_order", schema = "public", catalog = "postgres")
class OrderEntity(
    @Id
    @Column(name = "order_id")
    var id: String,

    @OneToOne
    @JoinColumn(name = "order_user_id", referencedColumnName = "user_id")
    var user: UserEntity,

    @ManyToMany
    @JoinTable(
        name = "table_order_to_product",
        joinColumns = [JoinColumn(name = "order_id")],
        inverseJoinColumns = [JoinColumn(name = "product_id")]
    )
    var products: List<ProductEntity>,

    @ManyToMany
    @JoinTable(
        name = "table_order_to_custom_cake",
        joinColumns = [JoinColumn(name = "order_id")],
        inverseJoinColumns = [JoinColumn(name = "custom_cake_id")]
    )
    var customCakes: List<CakeEntity>,

    @Basic
    @Column(name = "order_date_create")
    var dateCreate: Timestamp,

    @Basic
    @Column(name = "order_date_expiry")
    var dateExpiry: Date? = null,

    @Basic
    @Column(name = "order_address_street")
    var addressStreet: String,

    @Basic
    @Column(name = "order_address_city")
    var addressCity: String,

    @Basic
    @Column(name = "order_address_zip")
    var addressZip: String,

    @Basic
    @Column(name = "order_description")
    var description: String? = null,

    @Basic
    @Column(name = "order_status_code")
    var statusCode: Int
) {
    override fun toString(): String {
        return "TableOrderEntity(id=$id userId=$user dateCreate=$dateCreate dateExpiry=$dateExpiry " +
                "description=$description statusCode=$statusCode)"
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as OrderEntity
        if (id != that.id) return false
        if (user != that.user) return false
        if (if (dateCreate != null) !dateCreate!!.equals(that.dateCreate) else that.dateCreate != null) return false
        if (if (dateExpiry != null) dateExpiry != that.dateExpiry else that.dateExpiry != null) return false
        if (if (description != null) description != that.description else that.description != null) return false
        return if (if (statusCode != null) statusCode != that.statusCode else that.statusCode != null) false else true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + if (dateCreate != null) dateCreate.hashCode() else 0
        result = 31 * result + if (dateExpiry != null) dateExpiry.hashCode() else 0
        result = 31 * result + if (description != null) description.hashCode() else 0
        result = 31 * result + if (statusCode != null) statusCode.hashCode() else 0
        return result
    }
}