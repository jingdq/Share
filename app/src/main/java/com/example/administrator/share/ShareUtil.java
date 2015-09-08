package com.example.administrator.share;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

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

/**
 * Created by jingdq on 2015/9/7.
 */
public class ShareUtil {
    private static ShareUtil instance;
    private  UMSocialService mController = null;
    private static String appID = "wxd99905993ee12876";
    private static String appSecret = "37ada917a6b1105bf255f94648353cf0";
    private static Context mContext;
    private SocializeListeners.SnsPostListener mSnsPostListener;

    public static ShareUtil getInstance(Context context){

        if (instance == null){
            synchronized (ShareUtil.class){
                if (instance == null){
                    mContext = context;//.getApplicationContext();
                    instance = new ShareUtil();
                }
            }

        }
        return instance;
    }

    private ShareUtil(){
// 添加微信平台
        UMWXHandler wxHandler = new UMWXHandler(mContext,appID,appSecret);
        wxHandler.addToSocialSDK();
// 添加微信朋友圈
        UMWXHandler wxCircleHandler = new UMWXHandler(mContext,appID,appSecret);
        wxCircleHandler.setToCircle(true);
        wxCircleHandler.addToSocialSDK();
        // 首先在您的Activity中添加如下成员变量
        mController = UMServiceFactory.getUMSocialService("com.umeng.share");

        mSnsPostListener  = new SocializeListeners.SnsPostListener() {

            @Override
            public void onStart() {
                Toast.makeText(mContext, "Share Start", Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onComplete(SHARE_MEDIA platform, int stCode,
                                   SocializeEntity entity) {
                if (stCode == 200) {
                    Toast.makeText(mContext, "Share Success", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Toast.makeText(mContext,
                            "Share Error : error code : " + stCode, Toast.LENGTH_SHORT)
                            .show();
                }
            }
        };
        mController.registerListener(mSnsPostListener);
    }

    /**
     * 分享 標題 內容 圖片url
     * @param shareType
     * @param title
     * @param content
     * @param imgurl
     */
 public void shareContent(SHARE_MEDIA shareType ,String title ,String content,String contentUrl,String imgurl){

     if (SHARE_MEDIA.WEIXIN == shareType){

         //设置微信好友分享内容
         WeiXinShareContent weixinContent = new WeiXinShareContent();
      //设置分享文字
         if (!TextUtils.isEmpty(content))
         weixinContent.setShareContent(content);
      //设置title
         if (!TextUtils.isEmpty(title))
         weixinContent.setTitle(title);
     //设置分享内容跳转URL
         if (!TextUtils.isEmpty(contentUrl))
         weixinContent.setTargetUrl(contentUrl);
     //设置分享图片
         weixinContent.setShareImage(new UMImage(mContext, R.mipmap.ic_launcher));
         mController.setShareMedia(weixinContent);
         mController.postShare(mContext, SHARE_MEDIA.WEIXIN, null);

     }else if(SHARE_MEDIA.WEIXIN_CIRCLE == shareType){

         //设置微信朋友圈分享内容
         CircleShareContent circleMedia = new CircleShareContent();
         circleMedia.setShareContent(content);
        //设置朋友圈title
         circleMedia.setTitle(title);
               circleMedia.setShareImage(new UMImage(mContext,R.mipmap.ic_launcher));
         circleMedia.setTargetUrl("http://www.baidu.com");
         mController.setShareMedia(circleMedia);
         mController.postShare(mContext, SHARE_MEDIA.WEIXIN, null);


     }else if(SHARE_MEDIA.SINA == shareType){

         SinaShareContent sinaShareContent = new SinaShareContent();
         if (!TextUtils.isEmpty(imgurl))
         sinaShareContent.setShareImage(new UMImage(mContext, imgurl));
         if (!TextUtils.isEmpty(content))
         sinaShareContent.setShareContent(content);
//        sinaShareContent.setTargetUrl("http://www.baidu.com");
         mController.setShareMedia(sinaShareContent);
         mController.postShare(mContext, SHARE_MEDIA.SINA,mSnsPostListener );

     }

 }


    public void   deleteSinaAccessToken(){
        mController.deleteOauth(mContext, SHARE_MEDIA.SINA,
                new SocializeListeners.SocializeClientListener() {
                    @Override

                    public void onStart() {
                    }

                    @Override
                    public void onComplete(int status, SocializeEntity entity) {
                        if (status == 200) {
                            Toast.makeText(mContext, "删除成功.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(mContext, "删除失败",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
