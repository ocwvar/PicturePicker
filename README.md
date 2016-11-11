#Android Picture Picker
#Android图片获取器
Use to pick a picture from local or camera with crop or compress

可用于从本地图库或摄像头获取图片,同时还可以剪裁和压缩图片
##
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

#**局限性 limitation (16/11/11 11:11)**

1.在 targetSdkVersion / compileSdkVersion = 24 的环境下不能正常使用 Uri ,导致不能正常工作. 最高的环境版本为 

targetSdkVersion / compileSdkVersion = 23 , buildToolsVersion = 23.0.3

1.Picker will not work under targetSdkVersion / compileSdkVersion = 24 , 

please use targetSdkVersion / compileSdkVersion = 23 , buildToolsVersion = 23.0.3

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
