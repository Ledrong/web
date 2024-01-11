package com.example.nepekariproject.entity.user

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "table_user", schema = "public", catalog = "postgres")
class UserEntity(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    var id: Long = 0,

    @Basic
    @Column(name = "user_login")
    var login: String,

    @Basic
    @Column(name = "user_password")
    var password: String,

    @Basic
    @Column(name = "user_name")
    var name: String,

    @Basic
    @Column(name = "user_surname")
    var surname: String,

    @Basic
    @Column(name = "user_lastname")
    var lastname: String,

    @Basic
    @Column(name = "user_address_street")
    var addressStreet: String,

    @Basic
    @Column(name = "user_address_city")
    var addressCity: String,

    @Basic
    @Column(name = "user_address_zip")
    var addressZip: String,

    @Basic
    @Column(name = "user_regdate")
    var regdate: Date,

    @Basic
    @Column(name = "user_tariff_plan")
    var tariffPlan: Int,

    @Basic
    @Column(name = "user_email")
    var email: String? = null,

    @Basic
    @Column(name = "user_role")
    var role: String = "ROLE_USER"
) {
    override fun toString(): String {
        return "TableUserEntity(id=$id name=$name surname=$surname " +
                "lastname=$lastname regDate=$regdate " +
                "email=$email tariffPlan=$tariffPlan role=$role)"
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as UserEntity
        if (id != that.id) return false
        if (if (login != null) login != that.login else that.login != null) return false
        if (if (password != null) password != that.password else that.password != null) return false
        if (if (name != null) name != that.name else that.name != null) return false
        if (if (surname != null) surname != that.surname else that.surname != null) return false
        if (if (lastname != null) lastname != that.lastname else that.lastname != null) return false
        if (if (regdate != null) regdate != that.regdate else that.regdate != null) return false
        if (if (email != null) email != that.email else that.email != null) return false
        return if (if (tariffPlan != null) tariffPlan != that.tariffPlan else that.tariffPlan != null) false else true
    }

    override fun hashCode(): Int {
        var result = (id xor (id ushr 32)).toInt()
        result = 31 * result + if (login != null) login.hashCode() else 0
        result = 31 * result + if (password != null) password.hashCode() else 0
        result = 31 * result + if (name != null) name.hashCode() else 0
        result = 31 * result + if (surname != null) surname.hashCode() else 0
        result = 31 * result + if (lastname != null) lastname.hashCode() else 0
        result = 31 * result + if (regdate != null) regdate.hashCode() else 0
        result = 31 * result + if (email != null) email.hashCode() else 0
        result = 31 * result + if (tariffPlan != null) tariffPlan.hashCode() else 0
        return result
    }
}
