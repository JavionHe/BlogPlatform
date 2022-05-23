package com.win.ft_home.`interface`

import com.win.ft_home.model.navigation.NavigationItem

interface NavigationTabItemSelectedListener {
    fun onItemSelected(item: NavigationItem, position: Int)
}