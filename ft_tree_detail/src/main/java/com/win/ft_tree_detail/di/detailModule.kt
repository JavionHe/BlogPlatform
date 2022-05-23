package com.win.ft_tree_detail.di

import com.win.ft_tree_detail.ui.TreeDetailRepository
import com.win.ft_tree_detail.ui.TreeDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailRepoModule = module {
    factory {
        TreeDetailRepository(get())
    }
}

val detailViewModelModule = module {
    viewModel {
        TreeDetailViewModel(get())
    }
}
