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

class DemoFragment1 : Fragment() {
    companion object {
        fun newInstance(): DemoFragment1 {
            val args = Bundle()

            val fragment = DemoFragment1()
            fragment.arguments = args
            return fragment
        }
    }
//    Fragment 完整生命周期：onAttach -> onCreate -> onCreatedView -> onActivityCreated -> onStart -> onResume ->
//    onPause -> onStop -> onDestroyView -> onDestroy -> onDetach
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("DemoFragment1:","onAttach()")

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("DemoFragment1:","onCreate()")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        Log.e("DemoFragment1:","onHiddenChanged()"+hidden)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        Log.e("DemoFragment1:","setUserVisibleHint()"+isVisibleToUser)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("DemoFragment1:","onCreateView()")
        return inflater.inflate(R.layout.page_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("DemoFragment1:","onViewCreated()")

    }

    override fun onStart() {
        super.onStart()
        Log.e("DemoFragment1:","onStart()")

    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(activity,"DemoFragment1懒加载加载数据", Toast.LENGTH_SHORT).show()
        Log.e("DemoFragment1:","onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.e("DemoFragment1:","onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.e("DemoFragment1:","onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("DemoFragment1:","onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("DemoFragment1:","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("DemoFragment1:","onDetach()")
    }

}