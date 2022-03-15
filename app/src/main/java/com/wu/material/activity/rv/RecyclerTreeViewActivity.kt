package com.wu.material.activity.rv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.google.gson.Gson
import com.wu.material.R
import com.wu.material.activity.rv.adapter.DemoTreeAdapter
import com.wu.material.activity.rv.model.NodeInfo
import com.wu.material.activity.rv.model.TreeContentInfo
import com.wu.material.activity.rv.model.TreeInfo
import com.wu.material.databinding.ActivityRecyclerviewBinding


/**
 * @author wkq
 *
 * @date 2022年02月17日 10:43
 *
 *@des
 *
 */

class RecyclerTreeViewActivity : AppCompatActivity() {

    var datas="{\n" +
            "    \"id\": 46,\n" +
            "    \"name\": \"沧县\",\n" +
            "    \"description\": \"0\",\n" +
            "    \"domainid\": 0,\n" +
            "    \"sCode\": \"1\",\n" +
            "    \"iCode\": null,\n" +
            "    \"orderindex\": 0,\n" +
            "    \"parentid\": 40,\n" +
            "    \"parentName\": null,\n" +
            "    \"regtype\": 0,\n" +
            "    \"sn\": null,\n" +
            "    \"usecode\": false,\n" +
            "    \"full_name\": \"沧县\",\n" +
            "    \"label_icon\": \"rule_icon_region\",\n" +
            "    \"nodes\": [\n" +
            "      {\n" +
            "        \"id\": 49,\n" +
            "        \"name\": \"保定县\",\n" +
            "        \"description\": null,\n" +
            "        \"domainid\": 0,\n" +
            "        \"sCode\": \"1\",\n" +
            "        \"iCode\": null,\n" +
            "        \"orderindex\": 0,\n" +
            "        \"parentid\": 42,\n" +
            "        \"parentName\": null,\n" +
            "        \"regtype\": 0,\n" +
            "        \"sn\": null,\n" +
            "        \"usecode\": false,\n" +
            "        \"full_name\": \"沧县\\\\保定县\",\n" +
            "        \"label_icon\": \"rule_icon_region\",\n" +
            "        \"nodes\": [\n" +
            "          {\n" +
            "            \"id\": 50,\n" +
            "            \"name\": \"保定乡\",\n" +
            "            \"description\": null,\n" +
            "            \"domainid\": 0,\n" +
            "            \"sCode\": \"1\",\n" +
            "            \"iCode\": null,\n" +
            "            \"orderindex\": 0,\n" +
            "            \"parentid\": 49,\n" +
            "            \"parentName\": null,\n" +
            "            \"regtype\": 0,\n" +
            "            \"sn\": null,\n" +
            "            \"usecode\": false,\n" +
            "            \"full_name\": \"沧县\\\\保定县\\\\保定乡\",\n" +
            "            \"label_icon\": \"rule_icon_region\",\n" +
            "            \"nodes\": [\n" +
            "              {\n" +
            "                \"id\": 52,\n" +
            "                \"name\": \"保定村村村村村村\",\n" +
            "                \"description\": null,\n" +
            "                \"domainid\": 0,\n" +
            "                \"sCode\": \"1\",\n" +
            "                \"iCode\": null,\n" +
            "                \"orderindex\": 0,\n" +
            "                \"parentid\": 50,\n" +
            "                \"parentName\": null,\n" +
            "                \"regtype\": 0,\n" +
            "                \"sn\": null,\n" +
            "                \"usecode\": false,\n" +
            "                \"full_name\": \"沧县\\\\保定县\\\\保定乡\\\\保定村村村村村村\",\n" +
            "                \"label_icon\": \"rule_icon_region\",\n" +
            "                \"nodes\": []\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 53,\n" +
            "        \"name\": \"灵寿乡\",\n" +
            "        \"description\": null,\n" +
            "        \"domainid\": 0,\n" +
            "        \"sCode\": \"1\",\n" +
            "        \"iCode\": null,\n" +
            "        \"orderindex\": 0,\n" +
            "        \"parentid\": 44,\n" +
            "        \"parentName\": null,\n" +
            "        \"regtype\": 0,\n" +
            "        \"sn\": null,\n" +
            "        \"usecode\": false,\n" +
            "        \"full_name\": \"沧县\\\\灵寿乡\",\n" +
            "        \"label_icon\": \"rule_icon_region\",\n" +
            "        \"nodes\": []\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 54,\n" +
            "        \"name\": \"柏乡3\",\n" +
            "        \"description\": null,\n" +
            "        \"domainid\": 0,\n" +
            "        \"sCode\": \"1\",\n" +
            "        \"iCode\": null,\n" +
            "        \"orderindex\": 0,\n" +
            "        \"parentid\": 46,\n" +
            "        \"parentName\": null,\n" +
            "        \"regtype\": 0,\n" +
            "        \"sn\": null,\n" +
            "        \"usecode\": false,\n" +
            "        \"full_name\": \"沧县\\\\柏乡3\",\n" +
            "        \"label_icon\": \"rule_icon_region\",\n" +
            "        \"nodes\": []\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 48,\n" +
            "        \"name\": \"柏乡2\",\n" +
            "        \"description\": \"0\",\n" +
            "        \"domainid\": 0,\n" +
            "        \"sCode\": \"123\",\n" +
            "        \"iCode\": null,\n" +
            "        \"orderindex\": 0,\n" +
            "        \"parentid\": 46,\n" +
            "        \"parentName\": null,\n" +
            "        \"regtype\": 0,\n" +
            "        \"sn\": null,\n" +
            "        \"usecode\": false,\n" +
            "        \"full_name\": \"沧县\\\\柏乡2\",\n" +
            "        \"label_icon\": \"rule_icon_region\",\n" +
            "        \"nodes\": []\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 47,\n" +
            "        \"name\": \"柏乡1\",\n" +
            "        \"description\": \"1234\",\n" +
            "        \"domainid\": 0,\n" +
            "        \"sCode\": \"1234\",\n" +
            "        \"iCode\": null,\n" +
            "        \"orderindex\": 0,\n" +
            "        \"parentid\": 46,\n" +
            "        \"parentName\": null,\n" +
            "        \"regtype\": 0,\n" +
            "        \"sn\": null,\n" +
            "        \"usecode\": false,\n" +
            "        \"full_name\": \"沧县\\\\柏乡1\",\n" +
            "        \"label_icon\": \"rule_icon_region\",\n" +
            "        \"nodes\": []\n" +
            "      }\n" +
            "    ]\n" +
            "  }"
    var binding: ActivityRecyclerviewBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityRecyclerviewBinding>(this, R.layout.activity_recyclerview)


        initView()


    }

    private fun initView() {
        var mAdapter = DemoTreeAdapter(this)
        //设置LayoutManager
        var linearLayoutManager = LinearLayoutManager(this)
        binding!!.rvContent.layoutManager = linearLayoutManager
        //设置 Adapter
        binding!!.rvContent.adapter = mAdapter

        var listData = ArrayList<NodeInfo>()
        //刷新数据
        var gson= Gson();

        var info= gson.fromJson(datas,NodeInfo::class.java)
        listData.add(info)
        mAdapter.addItems(listData)

        mAdapter.setOnItemClickListener(object : DemoTreeAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                var info = mAdapter.getItem(position)
                info.isExpen = !info.isExpen
                mAdapter.notifyItemChanged(position, "1")
            }
        })

    }

}