package com.example.administrator.share;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.tencent.mm.sdk.openapi.IWXAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

public class MainActivity extends AppCompatActivity {
//    UMSocialService mController;
//    String appID = "wxd99905993ee12876";
//    String appSecret = "37ada917a6b1105bf255f94648353cf0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            Log.w("aaa", "~~~~~~~~~~~~~~΢未安装微信");
            Toast.makeText(context,"沒有安裝微信",Toast.LENGTH_SHORT).show();
        }

        return sIsWXAppInstalledAndSupported;
    }

    public void sinaShare(View view){

         ShareUtil.getInstance(this).shareContent(SHARE_MEDIA.SINA,"测试标题 ","分享内容",null,null);

    }


    public void unauth(View view){

      ShareUtil.getInstance(this).deleteSinaAccessToken();

    }

    public void weixincircle(View view){
        ShareUtil.getInstance(this).shareContent(SHARE_MEDIA.WEIXIN_CIRCLE, "标题标题标题标题", "分享内容分享内容分享内容分享内容", "http://www.baidu.com", "http://www.baidu.com");

    }

    public void weixinfriend(View view){
        ShareUtil.getInstance(this).shareContent(SHARE_MEDIA.WEIXIN,"标题标题标题标题","分享内容分享内容分享内容分享内容","http://www.baidu.com",null);
    }


    public void rate(View view){
        Uri uri = Uri.parse("market://details?id="+getPackageName());
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
