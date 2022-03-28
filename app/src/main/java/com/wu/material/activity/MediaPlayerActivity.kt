package com.wu.material.activity

import android.content.res.AssetFileDescriptor
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.wu.material.R
import com.wu.material.databinding.ActivityMediaBinding
import com.wu.material.util.MediaPlayerListener
import com.wu.material.util.MediaPlayerUtil


/**
 * @author wkq
 *
 * @date 2022年03月28日 14:17
 *
 *@des
 *
 */
@RequiresApi(Build.VERSION_CODES.N)
class MediaPlayerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding=DataBindingUtil.setContentView<ActivityMediaBinding>(this, R.layout.activity_media)
        binding.btPlay.setOnClickListener {
            playRawMp3()
        }
        binding.btPlayUri.setOnClickListener {
            playRawUri()
        }

        binding.btPlayAsset.setOnClickListener {
            playAsset()
        }
    }


    private fun playAsset() {
       var fikkDes= assets.openFd("audio.mp3") as AssetFileDescriptor
        MediaPlayerUtil.initMedia(this,fikkDes)
        MediaPlayerUtil.setMediaListener(object :MediaPlayerListener{
            override fun onErr(messageCode: Int) {
            }

            override fun finish() {
            }
            override fun prepare() {
                MediaPlayerUtil.playMedia()
            }
        })
        MediaPlayerUtil.prepareAsync()
    }
    var path="https://downsc.chinaz.net/Files/DownLoad/sound1/202103/s1024.mp3"
    private fun playRawUri() {
        MediaPlayerUtil.initMedia(this,path)

        MediaPlayerUtil.setMediaListener(object :MediaPlayerListener{
            override fun onErr(messageCode: Int) {
            }

            override fun finish() {
            }
            override fun prepare() {
                MediaPlayerUtil.playMedia()
            }
        })
        MediaPlayerUtil.prepareAsync()
    }

    private fun playRawMp3() {

        MediaPlayerUtil.initMedia(this,R.raw.audio)
        MediaPlayerUtil.setMediaListener(object :MediaPlayerListener{
            override fun onErr(messageCode: Int) {
            }

            override fun finish() {
            }

            override fun prepare() {
            }
        })

        MediaPlayerUtil.playMedia()
    }


}