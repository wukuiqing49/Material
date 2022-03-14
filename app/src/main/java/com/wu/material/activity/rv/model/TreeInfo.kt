package com.wu.material.activity.rv.model


/**
 * @author wkq
 *
 * @date 2022年03月14日 13:36
 *
 *@des
 *
 */

class TreeInfo
( //0 表示 分组 1 表示内容
        var type: Int,
        // 表示展开
        var isExpen: Boolean,
        //标题
        var title: String,
        //内容数据
        var contentDatas:List<TreeInfo>
)

class TreeContentInfo(var title: String)