package com.example.nepekariproject.entity.add_descr

import javax.persistence.*

@Entity
@Table(name = "table_add_descr", schema = "public", catalog = "postgres")
class DescrEntity(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "add_descr_id")
    var id: Long = 0,

    @Basic
    @Column(name = "add_descr_title")
    var title: String,

    @Basic
    @Column(name = "add_descr_descr")
    var descr: String,

    @Basic
    @Column(name = "add_descr_img_name")
    var imgName: String,

    @Basic
    @Column(name = "add_descr_amount_carb")
    var amountCarb: Double = 0.0,

    @Basic
    @Column(name = "add_descr_amount_prot")
    var amountProt: Double = 0.0,

    @Basic
    @Column(name = "add_descr_amount_fat")
    var amountFat: Double = 0.0,

    @Basic
    @Column(name = "add_descr_expiry_time_days")
    var expiryTimeDays: Int = 0,
) {
    override fun toString(): String {
        return "TableAddDescrEntity(id=$id descr=$descr imgName=$imgName amountCarb=$amountCarb " +
                "amountProt=$amountProt amountFat=$amountFat expiryTimeDays=$expiryTimeDays)"
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as DescrEntity
        if (id != that.id) return false
        if (java.lang.Double.compare(that.amountCarb, amountCarb) != 0) return false
        if (java.lang.Double.compare(that.amountProt, amountProt) != 0) return false
        if (java.lang.Double.compare(that.amountFat, amountFat) != 0) return false
        if (expiryTimeDays != that.expiryTimeDays) return false
        if (if (title != null) title != that.title else that.title != null) return false
        if (if (descr != null) descr != that.descr else that.descr != null) return false
        return if (if (imgName != null) imgName != that.imgName else that.imgName != null) false else true
    }

    override fun hashCode(): Int {
        var result: Int
        var temp: Long
        result = (id xor (id ushr 32)).toInt()
        result = 31 * result + if (title != null) title.hashCode() else 0
        result = 31 * result + if (descr != null) descr.hashCode() else 0
        result = 31 * result + if (imgName != null) imgName.hashCode() else 0
        temp = java.lang.Double.doubleToLongBits(amountCarb)
        result = 31 * result + (temp xor (temp ushr 32)).toInt()
        temp = java.lang.Double.doubleToLongBits(amountProt)
        result = 31 * result + (temp xor (temp ushr 32)).toInt()
        temp = java.lang.Double.doubleToLongBits(amountFat)
        result = 31 * result + (temp xor (temp ushr 32)).toInt()
        result = 31 * result + expiryTimeDays
        return result
    }
}