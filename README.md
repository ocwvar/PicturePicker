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
new PicturePickerUnity.Builder()<p></p>
.needCompress( true / false )<p></p>
.needCrop( true / false )<p></p>
.returnBitmap( true / false )<p></p>
.returnFile( true / false )<p></p>
.returnBoth( true / false )<p></p>
.setCompressValue( value > 0 )<p></p>
.setCropHeight( value > 0 )<p></p>
.setCropWidth(value > 0)<p></p>
.allowUseCamera( true / false )<p></p>
.allowUse3rdGallery( true / false )<p></p>
.setFileSavePathAndName( FolderPath , FileName )<p></p>
// By Activity <p></p>
.startPickerNow_ACTIVITY(RequestActivity , requestCode, permissionRequestCode);<p></p>
// By Fragment<p></p>
.startPickerNow_FRAGMENT(RequestFragment , requestCode, permissionRequestCode);<p></p>
        
> ### 获取结果 Get Result
在 onActivityResult() 获取到返回的Intent来进行操作

<p></p>
Intent Extras —— EXTRAS_BITMAP(Parcelable) / EXTRAS_FILE(Serializable)

#**预览 Preview**

由于GIF图像有28MB.. 所以预览不顺畅的时候可以直接下载根目录下的 Preview.gif 来看

Because the GIF file is too big , you may want to download if from root folder

![](https://github.com/ocwvar/PicturePicker/blob/master/preview.gif)
