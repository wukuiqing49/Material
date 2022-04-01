package com.wu.material.activity

import android.content.ClipData
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.DRAG_FLAG_GLOBAL
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.wu.material.R

/**
 * @author wkq
 *
 * @date 2022年04月01日 14:24
 *
 *@des
 *
 */

class DragAndDropActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag_anddrop)

//        DragStartHelper(text_drag_item,object :DragStartHelper.OnDragStartListener{
//            @RequiresApi(Build.VERSION_CODES.N)
//            override fun onDragStart(view: View?, helper: DragStartHelper?): Boolean {
//                val text = (view as TextView).text
//
//                // Create the ClipData to be shared
//                val dragClipData = ClipData.newPlainText(/*label*/"Text", text)
//
//                // Use the default drag shadow
//                val dragShadowBuilder = View.DragShadowBuilder(view)
//
//                // Initiate the drag. Note the DRAG_FLAG_GLOBAL, which allows for drag events to be listened
//                // to by apps other than the source app.
//                view.startDragAndDrop(dragClipData, dragShadowBuilder, null, DRAG_FLAG_GLOBAL)
//                return true
//            }
//
//        }).attach()

    }


}