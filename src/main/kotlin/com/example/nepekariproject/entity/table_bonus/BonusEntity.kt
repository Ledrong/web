package com.example.nepekariproject.entity.table_bonus

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "table_bonus", schema = "public", catalog = "postgres")
class BonusEntity(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "bonus_id")
    var id: Long,

    @Basic
    @Column(name = "bonus_value")
    var value: Double,

    @Basic
    @Column(name = "bonus_in_percent_flag")
    var inPercentFlag: Boolean,

    @Basic
    @Column(name = "bonus_start_date")
    var startDate: Date,

    @Basic
    @Column(name = "bonus_end_date")
    var endDate: Date? = null
) {
    override fun toString(): String {
        return "TableBonusEntity(id=$id value=$value inPercentFlag=$inPercentFlag startDate=$startDate " +
                "endDate=$endDate)"
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as BonusEntity
        if (id != that.id) return false
        if (java.lang.Double.compare(that.value, value) != 0) return false
        if (inPercentFlag != that.inPercentFlag) return false
        if (if (startDate != null) startDate != that.startDate else that.startDate != null) return false
        return if (if (endDate != null) endDate != that.endDate else that.endDate != null) false else true
    }

    override fun hashCode(): Int {
        var result: Int
        val temp: Long
        result = (id xor (id ushr 32)).toInt()
        temp = java.lang.Double.doubleToLongBits(value)
        result = 31 * result + (temp xor (temp ushr 32)).toInt()
        result = 31 * result + if (inPercentFlag) 1 else 0
        result = 31 * result + if (startDate != null) startDate.hashCode() else 0
        result = 31 * result + if (endDate != null) endDate.hashCode() else 0
        return result
    }
}