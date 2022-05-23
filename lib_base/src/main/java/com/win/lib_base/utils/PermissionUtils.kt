package com.win.lib_base.utils

import android.content.Context
import com.hjq.permissions.OnPermissionCallback
import com.hjq.permissions.XXPermissions


object PermissionUtils {
    fun requestPermission(context: Context, permission: Array<String>) {
        //XXPermissions.with(context) 内部是 return new XXPermissions(context)
        XXPermissions.with(context)
            // 申请单个权限
            .permission(permission)
            // 设置权限请求拦截器（局部设置）
            //.interceptor(new PermissionInterceptor())
            // 设置不触发错误检测机制（局部设置）
            //.unchecked()
            .request(object : OnPermissionCallback {

                override fun onGranted(permissions: MutableList<String>, all: Boolean) {
                }

                override fun onDenied(permissions: MutableList<String>, never: Boolean) {
                }
            })
    }
}