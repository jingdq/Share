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


//// ���΢��ƽ̨
//        UMWXHandler wxHandler = new UMWXHandler(this,appID,appSecret);
//        wxHandler.addToSocialSDK();
//// ���΢������Ȧ
//        UMWXHandler wxCircleHandler = new UMWXHandler(this,appID,appSecret);
//        wxCircleHandler.setToCircle(true);
//        wxCircleHandler.addToSocialSDK();
//        // ����������Activity��������³�Ա����
//        mController = UMServiceFactory.getUMSocialService("com.umeng.share");
// ���÷�������
//        mController.setShareContent("������ữ�����SDK�����ƶ�Ӧ�ÿ��������罻�����ܣ�http://www.umeng.com/social");
//// ���÷���ͼƬ, ����2ΪͼƬ��url��ַ
//        mController.setShareMedia(new UMImage(this,
//                "http://www.umeng.com/images/pic/banner_module_social.png"));
// ���÷���ͼƬ������2Ϊ����ͼƬ����Դ����
//mController.setShareMedia(new UMImage(getActivity(), R.drawable.icon));
// ���÷���ͼƬ������2Ϊ����ͼƬ��·��(����·��)
//mController.setShareMedia(new UMImage(getActivity(),
//                                BitmapFactory.decodeFile("/mnt/sdcard/icon.png")));

// ���÷�������
//UMusic uMusic = new UMusic("http://sns.whalecloud.com/test_music.mp3");
//uMusic.setAuthor("GuGu");
//uMusic.setTitle("����֮��");
// ������������ͼ
//uMusic.setThumb("http://www.umeng.com/images/pic/banner_module_social.png");
//mController.setShareMedia(uMusic);

// ���÷�����Ƶ
//UMVideo umVideo = new UMVideo(
//          "http://v.youku.com/v_show/id_XNTE5ODAwMDM2.html?f=19001023");
// ������Ƶ����ͼ
//umVideo.setThumb("http://www.umeng.com/images/pic/banner_module_social.png");
//umVideo.setTitle("������ữ����!");
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
//                    Toast.makeText(MainActivity.this, "����ɹ�", Toast.LENGTH_SHORT)
//                            .show();
//                } else {
//                    Toast.makeText(MainActivity.this,
//                            "����ʧ�� : error code : " + stCode, Toast.LENGTH_SHORT)
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
            Log.w("aaa", "~~~~~~~~~~~~~~΢�ſͻ���δ��װ����ȷ��");
//            GameToast.showToast(context, "΢�ſͻ���δ��װ����ȷ��");
        }

        return sIsWXAppInstalledAndSupported;
    }

    public void sinaShare(View view){

         ShareUtil.getInstance(this).shareContent(SHARE_MEDIA.SINA,"�ҵĴ��a֮·","�]�л��^·",null,null);

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
//                            Toast.makeText(MainActivity.this, "ɾ���ɹ�.",
//                                    Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(MainActivity.this, "ɾ��ʧ��",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

    }

    public void weixincircle(View view){

        ShareUtil.getInstance(this).shareContent(SHARE_MEDIA.WEIXIN_CIRCLE,"title","content","http://www.baidu.com","http://www.baidu.com");
        //����΢������Ȧ��������
//        CircleShareContent circleMedia = new CircleShareContent();
//        circleMedia.setShareContent("����������ữ�����SDK�����ƶ�Ӧ�ÿ��������罻�����ܣ�����Ȧ");
////��������Ȧtitle
//        circleMedia.setTitle("������ữ�������-����Ȧ");
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
        //����΢�ź��ѷ�������
//        WeiXinShareContent weixinContent = new WeiXinShareContent();
////���÷�������
//        weixinContent.setShareContent("����������ữ�����SDK�����ƶ�Ӧ�ÿ��������罻�����ܣ�΢��");
////����title
//        weixinContent.setTitle("������ữ�������-΢��");
////���÷���������תURL
//        weixinContent.setTargetUrl("http://www.baidu.com");
////���÷���ͼƬ
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
