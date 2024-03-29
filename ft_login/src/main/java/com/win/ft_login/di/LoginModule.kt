package com.win.ft_login.di

import com.win.ft_login.ui.LoginRepository
import com.win.ft_login.ui.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


val loginRepoModule = module {
    single {
        LoginRepository(get())
    }
}


val loginViewModelModule = module {
    viewModel {
        LoginViewModel(get())
    }
}