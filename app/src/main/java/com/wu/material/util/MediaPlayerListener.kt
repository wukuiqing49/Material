package com.wu.material.util

/**
 * @author wkq
 *
 * @date 2022年03月28日 14:41
 *
 *@des
 *
 */
interface MediaPlayerListener {
    fun onErr(messageCode: Int)
    fun finish()
    fun prepare()
}