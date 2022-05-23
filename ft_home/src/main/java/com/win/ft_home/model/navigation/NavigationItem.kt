package com.win.ft_home.model.navigation

data class NavigationItem(
    val cid: Int,
    val name: String,
    var isSelected: Boolean,
    val articles: MutableList<NavigationItemDetail>
)