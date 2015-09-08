
package com.example.administrator.share.wxapi;

import android.os.Bundle;
import android.os.PersistableBundle;
import com.umeng.socialize.controller.listener.SocializeListeners;
import com.umeng.socialize.weixin.view.WXCallbackActivity;

public class WXEntryActivity extends WXCallbackActivity {
    private SocializeListeners.SnsPostListener mSnsPostListener;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
//        mSnsPostListener  = new SocializeListeners.SnsPostListener() {
//
//            @Override
//            public void onStart() {
//
//            }
//
//            @Override
//            public void onComplete(SHARE_MEDIA platform, int stCode,
//                                   SocializeEntity entity) {
//                if (stCode == 200) {
//                    Toast.makeText(MainActivity.this, "分享成功", Toast.LENGTH_SHORT)
//                            .show();
//                } else {
//                    Toast.makeText(MainActivity.this,
//                            "分享失败 : error code : " + stCode, Toast.LENGTH_SHORT)
//                            .show();
//                }
//            }
//        };
//        mController.registerListener(mSnsPostListener);

    }
}
