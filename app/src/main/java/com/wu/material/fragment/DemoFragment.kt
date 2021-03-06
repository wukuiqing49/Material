package com.wu.material.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

class DemoFragment : Fragment() {
    companion object {
        fun newInstance(): DemoFragment {
            val args = Bundle()

            val fragment = DemoFragment()
            fragment.arguments = args
            return fragment
        }
    }
//    Fragment 完整生命周期：onAttach -> onCreate -> onCreatedView -> onActivityCreated -> onStart -> onResume ->
//    onPause -> onStop -> onDestroyView -> onDestroy -> onDetach
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("DemoFragment:","onAttach()")

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("DemoFragment:","onCreate()")
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("DemoFragment:","onCreateView()")
        return inflater.inflate(R.layout.page_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("DemoFragment:","onViewCreated()")

    }

    override fun onStart() {
        super.onStart()
        Log.e("DemoFragment:","onStart()")

    }

    override fun onResume() {
        super.onResume()
        Log.e("DemoFragment:","onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.e("DemoFragment:","onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.e("DemoFragment:","onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("DemoFragment:","onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("DemoFragment:","onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("DemoFragment:","onDetach()")
    }

}