package com.example.administrator.share;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.tencent.mm.sdk.openapi.IWXAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.SocializeEntity;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners;
import com.umeng.socialize.media.SinaShareContent;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.weixin.controller.UMWXHandler;
import com.umeng.socialize.weixin.media.CircleShareContent;
import com.umeng.socialize.weixin.media.WeiXinShareContent;

public class MainActivity extends AppCompatActivity {
//    UMSocialService mController;
//    String appID = "wxd99905993ee12876";
//    String appSecret = "37ada917a6b1105bf255f94648353cf0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//// 添加微信平台
//        UMWXHandler wxHandler = new UMWXHandler(this,appID,appSecret);
//        wxHandler.addToSocialSDK();
//// 添加微信朋友圈
//        UMWXHandler wxCircleHandler = new UMWXHandler(this,appID,appSecret);
//        wxCircleHandler.setToCircle(true);
//        wxCircleHandler.addToSocialSDK();
//        // 首先在您的Activity中添加如下成员变量
//        mController = UMServiceFactory.getUMSocialService("com.umeng.share");
// 设置分享内容
//        mController.setShareContent("友盟社会化组件（SDK）让移动应用快速整合社交分享功能，http://www.umeng.com/social");
//// 设置分享图片, 参数2为图片的url地址
//        mController.setShareMedia(new UMImage(this,
//                "http://www.umeng.com/images/pic/banner_module_social.png"));
// 设置分享图片，参数2为本地图片的资源引用
//mController.setShareMedia(new UMImage(getActivity(), R.drawable.icon));
// 设置分享图片，参数2为本地图片的路径(绝对路径)
//mController.setShareMedia(new UMImage(getActivity(),
//                                BitmapFactory.decodeFile("/mnt/sdcard/icon.png")));

// 设置分享音乐
//UMusic uMusic = new UMusic("http://sns.whalecloud.com/test_music.mp3");
//uMusic.setAuthor("GuGu");
//uMusic.setTitle("天籁之音");
// 设置音乐缩略图
//uMusic.setThumb("http://www.umeng.com/images/pic/banner_module_social.png");
//mController.setShareMedia(uMusic);

// 设置分享视频
//UMVideo umVideo = new UMVideo(
//          "http://v.youku.com/v_show/id_XNTE5ODAwMDM2.html?f=19001023");
// 设置视频缩略图
//umVideo.setThumb("http://www.umeng.com/images/pic/banner_module_social.png");
//umVideo.setTitle("友盟社会化分享!");
//mController.setShareMedia(umVideo);

//        SocializeListeners.SnsPostListener mSnsPostListener  = new SocializeListeners.SnsPostListener() {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void share(View view) {
//        mController.getConfig().removePlatform(SHARE_MEDIA.RENREN, SHARE_MEDIA.DOUBAN,SHARE_MEDIA.TENCENT);
//        mController.openShare(this, false);
    }


    private static boolean isWXAppInstalledAndSupported(Context context,
                                                        IWXAPI api) {
        // LogOutput.d(TAG, "isWXAppInstalledAndSupported");
      boolean  sIsWXAppInstalledAndSupported = api.isWXAppInstalled()
                && api.isWXAppSupportAPI();
        if (!sIsWXAppInstalledAndSupported) {
            Log.w("aaa", "~~~~~~~~~~~~~~微信客户端未安装，请确认");
//            GameToast.showToast(context, "微信客户端未安装，请确认");
        }

        return sIsWXAppInstalledAndSupported;
    }

    public void sinaShare(View view){

         ShareUtil.getInstance(this).shareContent(SHARE_MEDIA.SINA,"我的代碼之路","沒有回頭路",null,null);

    }


    public void unauth(View view){

//        mController.deleteOauth(this, SHARE_MEDIA.SINA,
//                new SocializeListeners.SocializeClientListener() {
//                    @Override
//                    public void onStart() {
//                    }
//
//                    @Override
//                    public void onComplete(int status, SocializeEntity entity) {
//                        if (status == 200) {
//                            Toast.makeText(MainActivity.this, "删除成功.",
//                                    Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(MainActivity.this, "删除失败",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

    }

    public void weixincircle(View view){

        ShareUtil.getInstance(this).shareContent(SHARE_MEDIA.WEIXIN_CIRCLE,"title","content","http://www.baidu.com","http://www.baidu.com");
        //设置微信朋友圈分享内容
//        CircleShareContent circleMedia = new CircleShareContent();
//        circleMedia.setShareContent("来自友盟社会化组件（SDK）让移动应用快速整合社交分享功能，朋友圈");
////设置朋友圈title
//        circleMedia.setTitle("友盟社会化分享组件-朋友圈");
////        circleMedia.setShareImage(localImage);
//        circleMedia.setTargetUrl("http://www.baidu.com");
//         mController.setShareMedia(circleMedia);
//        mController.postShare(this, SHARE_MEDIA.WEIXIN, new SocializeListeners.SnsPostListener() {
//            @Override
//            public void onStart() {
//
//            }
//
//            @Override
//            public void onComplete(SHARE_MEDIA share_media, int i, SocializeEntity socializeEntity) {
//                if (i == 200){
//                    Toast.makeText(MainActivity.this, "share success.", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
    }

    public void weixinfriend(View view){
        ShareUtil.getInstance(this).shareContent(SHARE_MEDIA.WEIXIN_CIRCLE,"title","content",null,null);
        //设置微信好友分享内容
//        WeiXinShareContent weixinContent = new WeiXinShareContent();
////设置分享文字
//        weixinContent.setShareContent("来自友盟社会化组件（SDK）让移动应用快速整合社交分享功能，微信");
////设置title
//        weixinContent.setTitle("友盟社会化分享组件-微信");
////设置分享内容跳转URL
//        weixinContent.setTargetUrl("http://www.baidu.com");
////设置分享图片
////        weixinContent.setShareImage(localImage);
//        mController.setShareMedia(weixinContent);
//        mController.postShare(this, SHARE_MEDIA.WEIXIN, new SocializeListeners.SnsPostListener() {
//            @Override
//            public void onStart() {
//
//            }
//
//            @Override
//            public void onComplete(SHARE_MEDIA share_media, int i, SocializeEntity socializeEntity) {
//                if (i == 200) {
//                    Toast.makeText(MainActivity.this, "share success.", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });


    }

}
