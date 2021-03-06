package com.ocwvar.picturepicker.DemoActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.ocwvar.picturepicker.Picker.PicturePickerUnity;
import com.ocwvar.picturepicker.R;

import java.io.File;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	EditText getWidth, getHeight, getCompress;
    CheckBox needCrop, needCompress, enableCamera, enable3rdGallery;
    RadioButton fileOnly, bitmapOnly, both;

	ImageView imageView;
	TextView textView;
	Button pick;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getWidth = (EditText) findViewById(R.id.getWidth);
		getHeight = (EditText) findViewById(R.id.getHeight);
		getCompress = (EditText) findViewById(R.id.getCompress);

		needCrop = (CheckBox) findViewById(R.id.isCrop);
		needCompress = (CheckBox) findViewById(R.id.isCompress);
        enableCamera = (CheckBox) findViewById(R.id.enableCamera);
        enable3rdGallery = (CheckBox) findViewById(R.id.enableGallery);

		fileOnly = (RadioButton) findViewById(R.id.returnFile);
		bitmapOnly = (RadioButton) findViewById(R.id.returnBitmap);
		both = (RadioButton) findViewById(R.id.returnBoth);

		textView = (TextView) findViewById(R.id.fileInfo);

		pick = (Button) findViewById(R.id.button);
		imageView = (ImageView) findViewById(R.id.imageView);

		pick.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {

		final int compressValue;
		final int cropWidth;
		final int cropHeight;

		final boolean needCrop = this.needCrop.isChecked();
		final boolean needCompress = this.needCompress.isChecked();

		final boolean fileOnly = this.fileOnly.isChecked();
		final boolean bitmapOnly = this.bitmapOnly.isChecked();
		final boolean both = this.both.isChecked();

		if (TextUtils.isEmpty(getCompress.getText().toString())) {
			compressValue = 0;
		} else {
			compressValue = Integer.valueOf(getCompress.getText().toString());
		}

		if (TextUtils.isEmpty(getWidth.getText().toString())) {
			cropWidth = 0;
		} else {
			cropWidth = Integer.valueOf(getWidth.getText().toString());
		}

		if (TextUtils.isEmpty(getHeight.getText().toString())) {
			cropHeight = 0;
		} else {
			cropHeight = Integer.valueOf(getHeight.getText().toString());
		}

		///////////////////////////////////////////////////////////////////////////
		///////////////////////////////创建请求构建器///////////////////////////////
		///////////////////////////////////////////////////////////////////////////

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
                .setFileSavePathAndName(Environment.getExternalStorageDirectory() + "/PickerTest", "Test" + String.valueOf(new Random(System.currentTimeMillis()).nextInt()) + ".jpg")
                .startPickerNow_ACTIVITY(MainActivity.this, 8, 1);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 8 && data != null) {

			if (data.getAction().equals(PicturePickerUnity.ACTION_SUCCESS)) {

				//获取文件对象
				final File file = (File) data.getSerializableExtra(PicturePickerUnity.EXTRAS_FILE);

				//获取位图对象
				final Bitmap bitmap = data.getParcelableExtra(PicturePickerUnity.EXTRAS_BITMAP);

				if (file != null) {
					textView.setText("Name:" + file.getName() + "\nSize:" + (float) file.length() / (1024.0 * 1024.0) + "MB");
				} else {
					textView.setText(null);
				}

				if (bitmap != null) {
					imageView.setImageBitmap(bitmap);
				}
			}
		}
	}


}
