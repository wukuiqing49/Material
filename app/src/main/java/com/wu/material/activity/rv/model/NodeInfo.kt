package com.wu.material.activity.rv.model


/**
 * @author wkq
 *
 * @date 2022年03月15日 9:35
 *
 *@des
 *
 */

data class NodeInfo(
        var isExpen: Boolean,
        val description: String,
        val domainid: Int,
        val full_name: String,
        val iCode: String,
        val id: Int,
        val label_icon: String,
        val name: String,

        val orderindex: Int,
        val parentName: String,
        val parentid: Int,
        val regtype: Int,
        val sCode: String,
        val sn: String,
        val usecode: Boolean,
        //嵌套的list(重要)
        val nodes: List<NodeInfo>
)