# Android 图片获取器
### 支持以下功能：
- 图像化的图像文件浏览选取
- 最近添加/修改图像浏览
- 第三方图库选图
- 第三方相机选图 （由于支持了新的API特性，建议使用系统自带相机进行选图）
- 图像剪裁（调用第三方图库进行）
- 图像压缩
- 可同时/分别返回图像文件对象和位图对象 (由于Bitmap大于1MB时无法通过Intent传输，所以当Bitmap大于限制时则会产生异常)

# 使用方法
> ### 请求 Request
```
new PicturePickerUnity.Builder()
      //是否需要压缩图像1~100
      .needCompress( true / false )
      //是否需要剪裁
      .needCrop( true / false )
      //只返回位图对象
      .returnBitmap( true / false )
      //只返回图像文件对象
      .returnFile( true / false )
      //返回图像文件同时也返回位图对象
      .returnBoth( true / false )
      //设置压缩值
      .setCompressValue( value > 0 )
      //设置裁剪输出高度
      .setCropHeight( value > 0 )
      //设置裁剪输出宽度
      .setCropWidth(value > 0)
      //是否允许用户使用相机选图
      .allowUseCamera( true / false )
      //是否允许用户使用第三方图库
      .allowUse3rdGallery( true / false )
      //设置图像文件储存位置
      .setFileSavePathAndName( FolderPath , FileName )
      //从Activity启动选图界面
      .startPickerNow_ACTIVITY(RequestActivity , requestCode, permissionRequestCode);
      //从Fragment启动选图界面
      .startPickerNow_FRAGMENT(RequestFragment , requestCode, permissionRequestCode);
```

> ### 获取结果 Get Result
在 onActivityResult() 获取到返回的Intent来进行操作

<p></p>
Intent Extras —— EXTRAS_BITMAP(Parcelable) / EXTRAS_FILE(Serializable)

#**预览 Preview**

由于GIF图像有28MB.. 所以预览不顺畅的时候可以直接下载根目录下的 Preview.gif 来看

Because the GIF file is too big , you may want to download if from root folder

![](https://github.com/ocwvar/PicturePicker/blob/master/preview.gif)
