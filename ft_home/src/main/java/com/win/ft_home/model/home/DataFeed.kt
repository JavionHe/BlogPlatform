package com.win.ft_home.model.home

import com.win.lib_base.model.DatasBean

data class DataFeed(
    val curPage: Int,
    val offset: Int,
    val pageCount: Int,
    val size: Int,
    val total: Int,
    val over: Boolean,
    val datas:MutableList<DatasBean>
    )