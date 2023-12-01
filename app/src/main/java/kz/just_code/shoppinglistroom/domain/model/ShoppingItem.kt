package kz.just_code.shoppinglistroom.domain.model

data class ShoppingItem(
    val id: Int,
    val name: String,
    var isBought: Boolean,
){
    constructor(name: String): this(id = 0, name = name, isBought = false)
}