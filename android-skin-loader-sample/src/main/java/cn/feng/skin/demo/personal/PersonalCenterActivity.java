package cn.feng.skin.demo.personal;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import cn.feng.skin.demo.R;
import cn.feng.skin.manager.base.BaseActivity;
import cn.feng.skin.manager.loader.SkinManager;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * 个人中心页面
 */
public class PersonalCenterActivity extends BaseActivity {

    private ImageView blurImageView;
    private ImageView avatarImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);

        initData();
        initView();
    }

    private void initData() {
        //实现个人中心头部磨砂布局
        blurImageView = (ImageView) findViewById(R.id.iv_blur);
        avatarImageView = (ImageView) findViewById(R.id.iv_avatar);

        Glide.with(this).load(R.drawable.head)
                .bitmapTransform(new BlurTransformation(this, 25), new CenterCrop(this))
                .into(blurImageView);

        Glide.with(this).load(R.drawable.head)
                .bitmapTransform(new CropCircleTransformation(this))
                .into(avatarImageView);
    }

    private void initView() {
        // 换标题
//        RelativeLayout titleBar = findViewById(R.id.title_bar_layout);
//        titleBar.setBackgroundColor(SkinManager.getInstance().getColor(R.color.color_title_bar_bg));

        item_view item_collections = findViewById(R.id.item_collections);
        item_collections.setBackgroundColor(SkinManager.getInstance().getColor(R.color.color_collections));
        item_collections.setTextColor(SkinManager.getInstance().getColor(R.color.text_color_collections));
    }
}
