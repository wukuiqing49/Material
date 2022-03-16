package com.wu.material.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.wu.material.R


/**
 * @author wkq
 *
 * @date 2022年01月30日 14:09
 *
 *@des
 *
 */

class DemoFragment4 : Fragment() {
    companion object {
        fun newInstance(): DemoFragment4 {
            val args = Bundle()

            val fragment = DemoFragment4()
            fragment.arguments = args
            return fragment
        }
    }
//    Fragment 完整生命周期：onAttach -> onCreate -> onCreatedView -> onActivityCreated -> onStart -> onResume ->
//    onPause -> onStop -> onDestroyView -> onDestroy -> onDetach
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("DemoFragment4 :","onAttach()")

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("DemoFragment4 :","onCreate()")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        Log.e("DemoFragment4:","onHiddenChanged()"+hidden)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        Log.e("DemoFragment4:","setUserVisibleHint()"+isVisibleToUser)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("DemoFragment4 :","onCreateView()")
        return inflater.inflate(R.layout.page_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("DemoFragment4 :","onViewCreated()")

    }

    override fun onStart() {
        super.onStart()
        Log.e("DemoFragment4 :","onStart()")

    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(activity,"DemoFragment4懒加载加载数据", Toast.LENGTH_SHORT).show()
        Log.e("DemoFragment4 :","onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.e("DemoFragment4 :","onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.e("DemoFragment4 :","onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("DemoFragment4 :","onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("DemoFragment4 :","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("DemoFragment4 :","onDetach()")
    }

}