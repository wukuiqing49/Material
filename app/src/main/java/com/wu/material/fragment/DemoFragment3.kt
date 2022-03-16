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

class DemoFragment3 : Fragment() {
    companion object {
        fun newInstance(): DemoFragment3 {
            val args = Bundle()

            val fragment = DemoFragment3()
            fragment.arguments = args
            return fragment
        }
    }
//    Fragment 完整生命周期：onAttach -> onCreate -> onCreatedView -> onActivityCreated -> onStart -> onResume ->
//    onPause -> onStop -> onDestroyView -> onDestroy -> onDetach
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("DemoFragment3:","onAttach()")

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("DemoFragment3:","onCreate()")
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("DemoFragment3:","onCreateView()")
        return inflater.inflate(R.layout.page_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("DemoFragment3:","onViewCreated()")

    }
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        Log.e("DemoFragment3:","onHiddenChanged()"+hidden)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        Log.e("DemoFragment3:","setUserVisibleHint()"+isVisibleToUser)
    }


    override fun onStart() {
        super.onStart()
        Log.e("DemoFragment3:","onStart()")

    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(activity,"DemoFragment3懒加载加载数据", Toast.LENGTH_SHORT).show()
        Log.e("DemoFragment3:","onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.e("DemoFragment3:","onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.e("DemoFragment3:","onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("DemoFragment3:","onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("DemoFragment3:","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("DemoFragment3:","onDetach()")
    }

}