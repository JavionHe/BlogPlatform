package com.win.ft_home.ui.home

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PageKeyedDataSource
import com.win.ft_home.model.home.Banner
import com.win.lib_base.livedata.StateLiveData
import com.win.lib_base.model.DatasBean
import com.win.lib_base.utils.BaseContext
import com.win.lib_net.model.NetResult
import com.zy.multistatepage.MultiStateContainer
import com.zy.multistatepage.state.ErrorState
import kotlinx.coroutines.launch
import javax.security.auth.callback.Callback

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val bannerLiveData = StateLiveData<List<Banner>>()

    fun getBannerLiveData(): StateLiveData<List<Banner>> {
        return bannerLiveData
    }


    fun getBanner() {

        viewModelScope.launch {
            val banner = homeRepository.getBanner()
            if (banner is NetResult.Success) {
                bannerLiveData.postSuccess(banner.data)
            } else if (banner is NetResult.Error) {
                bannerLiveData.postError(Throwable(banner.exception.msg))
            }
        }

    }

}