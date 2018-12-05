package io.newdex.exchange.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * @author liulilei
 * 操作sp的工具类
 */
object SpUtils {

    val SP_FILE_NAME = "desk_sp"

    private var sp: SharedPreferences? = null

    fun getBoolean(context: Context, key: String, defValue: Boolean): Boolean {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
        }
        return sp!!.getBoolean(key, defValue)
    }

    fun putBoolean(context: Context, key: String, value: Boolean) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
        }
        sp!!.edit().putBoolean(key, value).commit()
    }

    fun getString(context: Context, key: String, defValue: String): String? {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
        }
        return sp!!.getString(key, defValue)
    }

    fun putString(context: Context, key: String, value: String) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
        }
        sp!!.edit().putString(key, value).commit()
    }

    fun getInt(context: Context, key: String, defValue: Int): Int {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
        }
        return sp!!.getInt(key, defValue)
    }

    fun putInt(context: Context, key: String, value: Int) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
        }
        sp!!.edit().putInt(key, value).commit()
    }

    fun getLong(context: Context, key: String, defValue: Long?): Long {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_FILE_NAME,
                    Context.MODE_PRIVATE)
        }
        return sp!!.getLong(key, defValue!!)
    }

    fun putLong(context: Context, key: String, value: Long?) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE)
        }
        sp!!.edit().putLong(key, value!!).commit()
    }

}
