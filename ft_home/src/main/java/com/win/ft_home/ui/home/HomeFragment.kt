package com.win.ft_home.ui.home

import androidx.lifecycle.Observer
import com.win.ft_home.R
import com.win.ft_home.adapter.HomeBannerAdapter
import com.win.ft_home.databinding.FragmentHomeBinding
import com.win.ft_home.model.home.Banner
import com.win.lib_base.base.BaseFragment
import com.win.lib_base.livedata.StateData
import com.win.lib_base.livedata.StateData.DataStatus
import com.zy.multistatepage.state.ErrorState
import com.zy.multistatepage.state.SuccessState


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override fun getLayoutResId(): Int = R.layout.fragment_home

    override fun initView() {

        val supportFragmentManager = activity?.supportFragmentManager
        val beginTransaction = supportFragmentManager?.beginTransaction()
        beginTransaction?.replace(R.id.homeListContainer, HomeListFragment::class.java, null)
        beginTransaction?.commit()

    }

    override fun initData() {

        mViewModel.apply { getBanner() }

        mViewModel.getBannerLiveData()
            .observe(
                viewLifecycleOwner,
                Observer {
                    when (it?.status) {
                        DataStatus.SUCCESS -> {
                            mViewBinding.banner.adapter = HomeBannerAdapter(it.data!!)
                            multiStateContainer.show<SuccessState> {}
                        }
                        DataStatus.ERROR -> multiStateContainer.show<ErrorState> { state ->
                            state.retry(object : ErrorState.OnRetryClickListener {
                                override fun retry() {
                                    mViewModel.apply { getBanner() }
                                    initView()
                                }
                            })
                        }
                    }
                }
            )

    }
}