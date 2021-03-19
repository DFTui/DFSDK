# DFTui_DFSdk使用说明：（可参考demo项目）
## 1. 基本接口：
* ***接口初始化，初始化后才可正常使用其他接口**
`DFTui.init(Application application);`
	
* **请求Splash广告（入参均不可为空）**
`DFTui.get().getSplashAD（Activity activity,SplashCallAdShow callBack）`
	  
* **请求信息流广告（入参均不可为空）**
`DFTui.get().getPopAD（Activity activity,PopCallAdShow callBack）`
	
* **请求激励视屏广告（入参均不可为空)**
`DFTui.get().getVideoAD（Activity activity,VideoCallAdShow callBack）`
	 

## 2.基本回调：(SplashCallAdShow/PopCallAdShow/VideoCallAdShow)
* **开始请求**
`void onAdStartRequest( long startTime, AD_Type adType);`
	
* **请求失败**
`void onAdFailed( long endTime, String failedMsg, AD_Type adType);`

* **广告加载完成**
`void onAdLoaded( long time, AD_Type adType);`

* **广告被点击了**
`void onAdClicked( long time, AD_Type adType);`

* **广告被关闭了(*popcallback无此接口*)**
`void onAdClose(long time, AD_Type adType);`
	
* **广告播放完成(*popcallback/splashcallback无此接口*)**   
`void onAdFinish( long time, AD_Type adType);`

* **广告激励有效(*popcallback/splashcallback无此接口*)**
`void onAdExpose( long time, AD_Type adType);`
   
   
##  3.导入配置：
### （1）仓库配置：

> **项目gradle->repositories添加:**

`maven { url "https://raw.githubusercontent.com/DFTui/DFSDK/main" }`

> **app的gradle->dependencies添加:**

`implementation 'com.dftui.dfsdk:dfsdk:1.0.0'//（目前版本1.0.0）`
	
### （2）provider配置：
**AndroidManifest中添加name为"com.dftui.dfsdk.ADProvider"的provider（如下）**

    <provider
          android:name="com.dftui.dfsdk.ADProvider"
          android:authorities="${applicationId}.ADProvider
          android:exported="false"
          android:grantUriPermissions="true">
          <meta-data
                android:name="android.support.FILE_PROVIDER_PATHS"
                android:resource="@xml/file_paths" />
     </provider>
  **xml中添加file_paths文件（如已存在resource配置，可比对内容添加项）**
	
### （3）so库配置：
  **jniLibs中添加附件的so库，用于视屏播放（目前版本使用），//见文件夹jniLibs**
	
### （3）其他配置：
  **网络配置，android 适配http请求（不安全请求），资源文件xml中添加network-security-config//见文件network-security-config**
