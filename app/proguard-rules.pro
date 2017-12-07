# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /usr/share/android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-repackageclasses 'com.caoyanglong.article'


-optimizationpasses 5
-dontusemixedcaseclassnames
-ignorewarnings
-keepattributes *Annotation*,EnclosingMethod,InnerClasses,Signature,Exceptions

#-keepattributes SourceFile,LineNumberTable
#Log相关全部移除
#-assumenosideeffects class com.yyhd.sandbox.utilities.MyLog { *; }直接混淆.class文件，导致卡顿
-assumenosideeffects class com.yyhd.library.baseutils.UtilLogUtils {
    public static void v(...);
    public static void i(...);
    public static void w(...);
    public static void d(...);
    public static void e(...);
}
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}

-dontwarn android.**

-keep public class * extends android.view.View {*;}


-keep class * implements android.os.Parcelable { public static final android.os.Parcelable$Creator *;}
-keepclassmembers class * implements android.os.Parcelable {
 public <fields>;
 private <fields>;
}

-keepclassmembers class * implements android.os.Parcelable {
 public <fields>;
 private <fields>;
}
-keepclasseswithmembers class * {public <init>(android.content.Context, android.util.AttributeSet, int);}

-keepclassmembers class * extends java.lang.Enum {
    <fields>;
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep public class * extends android.app.Activity
-keep public class * extends android.content.ContextWrapper
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.preference.Preference
-keep public class * extends android.support.v4

###########################################################################
#                         沙盒库相关                                    #
###########################################################################


#对外插件接口
-keep class com.gameassist.plugin.ActivityCallback {*;}
-keep class com.gameassist.plugin.ClassLoaderCallback {*;}
-keep class com.gameassist.plugin.Plugin {*;}
-keep class com.gameassist.plugin.PluginManager {*;}

-keep public class * extends com.gameassist.plugin.Plugin
-keep public class * extends com.gameassist.plugin.PluginManager
-keep public class * extends com.gameassist.plugin.ActivityCallback
-keep public class * extends com.gameassist.plugin.ClassLoaderCallback

-keep class com.yyhd.sandbox.p.FileUtils {public <methods>;}
-keep class com.yyhd.sandbox.p.PluginManifest {public <methods>;}
-keep class com.yyhd.sandbox.p.PluginHelper {public <methods>;}
-keep class com.yyhd.sandbox.p.PluginManagerImpl {public <methods>;}

#Native相关
-keep class com.yyhd.sandbox.NativeObserver {*;}
-keep class com.yyhd.sandbox.NativeUtils {
    native <methods>;
    public static void reportSuicide(int, int);
    public static int onGetCallingUid();
    public static int[] getRunningUids();
}

#反射库
-keep class com.yyhd.sandbox.r.** { *; }
-dontwarn com.yyhd.sandbox.r.**

#系统与谷歌组件相关
-keep class android.app.** {*;}
-keep class android.accounts.** {*;}
-keep class android.content.** {*;}
-keep class android.location.** {*;}
-keep class com.google.** {	*; }


-keepattributes Signature
-keep class * extends java.util.Observable
#
#-keep public class com.iplay.assistant.plugin.entity.** {
#    public protected *;
#}

-keep class com.iplay.assistant.utilities.entity.LocalGame {
    *;
}

-keep class com.iplay.assistant.IPlayApplication {
    *;
}

-keep public class com.iplay.assistant.R$*{
    *;
}

#-keep,includedescriptorclasses class * extends com.squareup.picasso
#
#-keep,includedescriptorclasses public class com.squareup.picasso.** {
#    public protected *;
#}

#-keep,includedescriptorclasses class com.squareup.picasso.Picasso {
#	*;
#}

#-keep class com.squareup.picasso.Callback {
#	*;
#}
#
#-keep class com.squareup.picasso.RequestCreator {
#	*;
#}
#
#-keep class com.squareup.picasso.CircleTransformation {
#	*;
#}
-dontwarn **CompatHoneycomb
-keep class android.support.v4.** {
	*;
}

-keep class android.support.v7.** {
	*;
}


-keep class android.** {
	*;
}

-keep class com.nineoldandroids.** {
	*;
}
-keep class com.android.internal.** {
	*;
}

-keep,includedescriptorclasses class com.iplay.assistant.widgets {
    *;
}

-keep class com.gameassist.ui.proxy {
	*;
}


-keep class  com.iplay.assistant.ui.browser.JsPlugin {
	*;
}
-keep class com.gameassist.download.providers.downloads.JsPlugin {
	*;
}

-keep class  com.iplay.assistant.video.widget.GameVideoJavascriptInterface {
	*;
}

#-keep class com.iplay.assistant.util.NativeFileObserver {
#    *;
#}


-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-dontwarn com.igexin.**
-keep class com.igexin.**{*;}

-keep class Reflection.** { *; }
-dontwarn Reflection.**



-keep class * implements java.io.Serializable

-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    !private <fields>;
    !private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

-keep class com.qq.e.** {
    public protected *;
}
-keep class com.tencent.gdt.**{
    public protected *;
}

#-keep public class com.tendcloud.tenddata.** { public protected *;}

-keep,allowshrinking class org.android.agoo.service.* {
    public <fields>;
    public <methods>;
}


-keep public class com.iplay.assistant.R$* {
   public static final int *;
}

-keepclassmembers class * {
      public <init>(org.json.JSONObject);
}

-keep public class com.iplay.assistant.R$* {
    public static final int *;
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class android.**{ *;}
-keep class com.tencent.** {*;}
-keep class com.umeng.** { *;}
#-keep class com.letv.** { *;}
#-keep class com.lecloud.** {*;}
-keep class com.iplay.assistant.wxapi.** {*;}


-keep class cn.mmachina.** {*;}
-keep class cn.com.iresearch.** {*;}
-keep class com.a.a.** {*;}

-dontwarn com.avdmg.avdsmart.**
#-dontwarn com.lecloud.**
#-dontwarn com.letv.**
-dontwarn org.rajawali3d.**
-dontwarn org.apache.**
-dontwarn android.webkit.**

-dontwarn com.bumptech.**
-keep class com.bumptech.** { *;}

-dontwarn okhttp3.**
-keep class okhttp3.** { *;}

-dontwarn okio.**
-keep class okio.** { *;}

-dontwarn android.support.v4.**

-keep public class * implements com.bumptech.glide.module.GlideModule

-keep class com.iplay.assistant.account.provider.LoginInfoProvider {
	*;
}
-keep class com.iplay.assistant.account.provider.LoginInfoProvider3 {
	*;
}

-keep class com.iplay.assistant.game.special_event.EventDownloadJSInterface {
    *;
}

-keep class com.iplay.assistant.game.special_event.EventShareJSInterface {
    *;
}

-keep class com.iplay.assistant.utilities.WebViewJSInterface {
	*;
}
-keep class com.iplay.assistant.account.activity.LoginAndRegisterActivity {
	*;
}
-keep class com.iplay.assistant.account.activity.SettingActivity {
	*;
}
-keep class com.baidu.** {
    *;
}
#小米推送相关
-keep class com.iplay.assistant.pushmsg.XiaoMiPushMessageReceiver {*;}
-keep class com.xiaomi.** {
    *;
}
-dontwarn com.xiaomi.push.**


#talkingData相关

-dontwarn com.tendcloud.tenddata.**
-keep class com.tendcloud.** {*;}
-keep public class com.tendcloud.tenddata.** { public protected *;}
-keepclassmembers class com.tendcloud.tenddata.**{
public void *(***);
}
-keep class com.talkingdata.sdk.TalkingDataSDK {public *;}
-keep class com.apptalkingdata.** {*;}

-keep public class cn.waps.** {*;}
-keep public interface cn.waps.** {*;}
#对亍使用 4.0.3 以上 android-sdk 进行顷目编译时产生异常癿情况时,加入以下内容:
-dontwarn cn.waps.**
