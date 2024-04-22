package tw.cgu.b0921251_mcs.ew_camera;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.net.Uri;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMG = 100;
    private static final int REQUEST_VIDEO_CAPTURE = 101;
    private ImageView imageView;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        videoView = (VideoView) findViewById(R.id.videoView);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMG && resultCode == Activity.RESULT_OK) {
            imageView.setVisibility(View.VISIBLE);
            videoView.setVisibility(View.GONE);

            // 在ImageView元件顯示照片
            Bitmap userImage = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(userImage);
        }
        else if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == Activity.RESULT_OK) {
            videoView.setVideoURI(data.getData());
            videoView.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
            videoView.setMediaController(new MediaController(this));
            videoView.start(); // 開始播放
        }
    }

    public void button_Click(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_IMG);
    }

    public void button2_Click(View view){
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0);
        startActivityForResult(intent, REQUEST_VIDEO_CAPTURE);
    }
}