package debug

import androiddesk.com.desk.base.component.app.BaseApplication
import com.androiddesk.desk.my.component.BuildConfig
import com.billy.cc.core.component.CC

/**
 *@Description:
 * @author: lll
 * @date: 2018/12/7
 */
class MyApp : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        CC.enableVerboseLog(BuildConfig.DEBUG)
        CC.enableDebug(BuildConfig.DEBUG)
        CC.enableRemoteCC(BuildConfig.DEBUG)
    }
}