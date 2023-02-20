package cn.feng.skin.demo.activity;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.feng.skin.demo.R;
import cn.feng.skin.manager.base.BaseActivity;
import cn.feng.skin.manager.loader.SkinManager;
import cn.feng.skin.manager.util.ResourceUtils;

public class DetailActivity extends BaseActivity{
	
	private TextView titleText;
	private TextView detailText;
	private String article;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		initData();
		initView();
	}

	private void initData() {
		article = ResourceUtils.geFileFromAssets(this, "article.txt");
	}

	private void initView() {
		// 换标题
		RelativeLayout titleBar = findViewById(R.id.title_bar_layout);
		titleBar.setBackgroundColor(SkinManager.getInstance().getColor(R.color.color_title_bar_bg));

		// 换背景
		RelativeLayout background = findViewById(R.id.root_layout);
		background.setBackgroundColor(SkinManager.getInstance().getColor(R.color.color_app_bg));

		// 换标题
		titleText = findViewById(R.id.title_text);
		titleText.setTextColor(SkinManager.getInstance().getColor(R.color.color_new_item_title_pressed));
		titleText.setText("生命中的美好都是免费的");
		// 换文本内容
		detailText = findViewById(R.id.detail_text);
		detailText.setText(article);
		detailText.setTextColor(SkinManager.getInstance().getColor(R.color.color_new_item_synopsis));
		detailText.setBackgroundColor(SkinManager.getInstance().getColor(R.color.color_new_item_bg));
	}
}
