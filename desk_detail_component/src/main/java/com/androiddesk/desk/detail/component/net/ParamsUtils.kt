package com.androiddesk.desk.detail.component.net

/**
 *@Description:
 * @author: lll
 * @date: 2018/8/23
 */
class ParamsUtils {

    companion object {

        fun getVerticalList(skip: Int, limit: Int, order: String): Map<String, String> {
            val params = HashMap<String, String>()
            params["skip"] = "" + skip
            params["limit"] = "" + limit
            params["adult"] = "false"
            params["first"] = "0"
            params["order"] = order
            return params
        }

    }

}