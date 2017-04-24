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
      //是否需要压缩图像
      .needCompress( true / false )
      //是否需要剪裁
      .needCrop( true / false )
      //只返回位图对象
      .returnBitmap( true / false )
      //只返回图像文件对象
      .returnFile( true / false )
      //返回图像文件同时也返回位图对象
      .returnBoth( true / false )
      //设置压缩值：0(最差画质) ~ 100(最好画质)
      .setCompressValue( Integer >= 0 )
      //设置裁剪输出高度
      .setCropHeight( Integer > 0 )
      //设置裁剪输出宽度
      .setCropWidth( Integer > 0)
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
返回数据可以使用两个参数来提取 文件对象 和 位图对象 ：PicturePickerUnity.EXTRAS_FILE 和 PicturePickerUnity.EXTRAS_BITMAP
示例代码：
```
@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 8 && data != null) {
		
				//获取文件对象
				final File file = (File) data.getSerializableExtra(**PicturePickerUnity.EXTRAS_FILE**);

				//获取位图对象
				final Bitmap bitmap = data.getParcelableExtra(**PicturePickerUnity.EXTRAS_BITMAP**);

		}
	}
```

#**预览 Preview**

由于GIF图像有28MB.. 所以预览不顺畅的时候可以直接下载根目录下的 Preview.gif 来看

![](https://github.com/ocwvar/PicturePicker/blob/master/preview.gif)
