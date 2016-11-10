package com.ocwvar.picturepicker.DemoActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText getWidth, getHeight, getCompress;
    CheckBox needCrop, needCompress;
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

        final PicturePickerUnity.Builder builder = new PicturePickerUnity.Builder();

        builder
                .needCompress(needCompress)
                .needCrop(needCrop)
                .returnBitmap(bitmapOnly)
                .returnFile(fileOnly)
                .returnBoth(both)
                .setCompressValue(compressValue)
                .setCropHeight(cropHeight)
                .setCropWidth(cropWidth)
                .startPickerNow(MainActivity.this,8);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

}
