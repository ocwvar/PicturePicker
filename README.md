#Android Picture Picker
#Android图片获取器
Use to pick a picture from local or camera with crop or compress

可用于从本地图库或摄像头获取图片,同时还可以剪裁和压缩图片
##

#**使用方法 How to use**
    new PicturePickerUnity.Builder()
    	.needCompress( True / False )
    	.needCrop( True / False )
    	.returnBitmap( True / False )
    	.returnFile( True / False )
    	.returnBoth( True / False )
    	.setCompressValue( 0 ~ 100 )
    	.setCropHeight(cropHeight)
    	.setCropWidth(cropWidth)
    	.setFileSavePathAndName( savePath , fileName )
    	// By Activity 
    	.startPickerNow_ACTIVITY(RequestActivity , requestCode, permissionRequestCode);
    	// By Fragment
    	.startPickerNow_FRAGMENT(RequestFragment , requestCode, permissionRequestCode);


#**总览 Overview**

**图片操作 Picture operation**

> 自定义剪裁大小  Custom the cropWidth & cropHeight of the Picture
> 
> 自定义图像压缩大小  Custom the value of the compress level


**返回对象 Return value**
> Bitmap 位图 Bitmap object **●**
> 
> File 对象 File object
> 
> 错误文字信息  Exception Message

**●** 由于使用的传输途径是 Intent 导致传输内容大小有限制 , 当 Bitmap 对象大小大于 1MB 的时候将**传回 NULL** , 一般建议同时传递回 Bitmap 和 File 对象以确保能正常获取到图像

**●** Because of the size limit in the Intent , **you will get NULL** when Bitmap object bigger than 1MB. The solution is return both of bitmap & file object , so you can get that bitmap from the file.

##

#**注意**
**目前已解决 BuildTools 25+ 以上版本拍照、拍照后编辑异常的问题。**但经测试发现，不是所有第三方拍照APP均兼容 BuildTools25+ 的URI权限新特性，所以需要使用自带相机来解决此问题。

##

#**自定义 Custom**

**文件 Files**

> **String.xml** 
> 
> 错误文字信息以及按钮文字
> 
> Text of Exception and button

<p>

> **background_shape.xml** 
> 
> 背景样式
> 
> Background shape

<p>

> **picture_select_unity.xml** 
> 
> 整体布局
> 
> Whole layout

**代码 Code**

>SAVE_PATH
>
>File 文件储存文件夹
>The folder of file objects

##
#**预览 Preview**

由于GIF图像有28MB.. 所以预览不顺畅的时候可以直接下载根目录下的 Preview.gif 来看

Because the GIF file is too big , you may want to download if from root folder

![](https://github.com/ocwvar/PicturePicker/blob/master/preview.gif)
