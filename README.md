#Android Picture Picker
#Android图片获取器
Use to pick a picture from local or camera with crop or compress

可用于从本地图库或摄像头获取图片,同时还可以剪裁和压缩图片
##

#**使用方法 How to use**
> ### 请求 Request
    new PicturePickerUnity.Builder()
    	.needCompress(needCompress)
		.needCrop(needCrop)
		.returnBitmap(bitmapOnly)
		.returnFile(fileOnly)
		.returnBoth(both)
		.setCompressValue(compressValue)
		.setCropHeight(cropHeight)
		.setCropWidth(cropWidth)
        .allowUseCamera(enableCamera.isChecked())
        .allowUse3rdGallery(enable3rdGallery.isChecked())
        .setFileSavePathAndName(FolderPath, FileName)
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
