package devdeep.savinggrow;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bitmap bitmap_island = BitmapFactory.decodeResource(getResources(),R.drawable.island);
        Bitmap bitmap_cloud1 = BitmapFactory.decodeResource(getResources(),R.drawable.cloud1);
        Bitmap bitmap_cloud2 = BitmapFactory.decodeResource(getResources(),R.drawable.cloud2);


        ImageView island = (ImageView) findViewById(R.id.island);
        island.setImageBitmap(bitmap_island);
        ImageView cloud1 = (ImageView) findViewById(R.id.clound1);
        cloud1.setImageBitmap(bitmap_cloud1);
        ImageView cloud2 = (ImageView) findViewById(R.id.clound2);
        cloud2.setImageBitmap(bitmap_cloud2);
        ImageView cloud3 = (ImageView) findViewById(R.id.clound3);
        cloud3.setImageBitmap(bitmap_cloud2);
        ImageView cloud4 = (ImageView) findViewById(R.id.clound4);
        cloud4.setImageBitmap(bitmap_cloud1);
    }


    public void btn_group(View view) {
        Intent intent = new Intent(MainActivity.this,MainFragmentActivity.class);
        startActivity(intent);
    }
}
