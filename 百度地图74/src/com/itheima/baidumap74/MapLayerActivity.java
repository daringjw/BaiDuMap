package com.itheima.baidumap74;

import com.baidu.mapapi.map.BaiduMap;

import android.view.KeyEvent;

public class MapLayerActivity extends BaseActivity {

	@Override
	public void init() {
		
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_1:
			// ��ʾ��ͨ��ͼ
			baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
			baiduMap.setTrafficEnabled(false);
			break;
		case KeyEvent.KEYCODE_2:
			// ��ʾ����ͼ
			baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
			baiduMap.setTrafficEnabled(false);
			break;
		case KeyEvent.KEYCODE_3:
			// ��ͨͼ
			baiduMap.setTrafficEnabled(true);
			break;
		}
		return super.onKeyDown(keyCode, event);
	}

}
