# Android 图片获取器
### 支持以下功能：
---
- 图像化的图像文件浏览选取
- 最近添加/修改图像浏览
- 第三方图库选图
- 第三方相机选图 （由于支持了新的API特性，建议使用系统自带相机进行选图）
- 图像剪裁（调用第三方图库进行）

# **使用方法 How to use**
> ### 请求 Request
    new PicturePickerUnity.Builder()
        .needCompress( true / false )
	.needCrop( true / false )
	.returnBitmap( true / false )
	.returnFile( true / false )
	.returnBoth( true / false )
	.setCompressValue( value > 0 )
	.setCropHeight( value > 0 )
	.setCropWidth(value > 0)
        .allowUseCamera( true / false )
        .allowUse3rdGallery( true / false )
        .setFileSavePathAndName( FolderPath , FileName )
    	// By Activity 
    	.startPickerNow_ACTIVITY(RequestActivity , requestCode, permissionRequestCode);
    	// By Fragment
    	.startPickerNow_FRAGMENT(RequestFragment , requestCode, permissionRequestCode);
        
> ### 获取结果 Get Result
在 onActivityResult() 获取到返回的Intent来进行操作

<p></p>
Intent Extras —— EXTRAS_BITMAP(Parcelable) / EXTRAS_FILE(Serializable)

#**预览 Preview**

由于GIF图像有28MB.. 所以预览不顺畅的时候可以直接下载根目录下的 Preview.gif 来看

Because the GIF file is too big , you may want to download if from root folder

![](https://github.com/ocwvar/PicturePicker/blob/master/preview.gif)
