package com.itheima.baidumap74;

import com.baidu.mapapi.map.TextOptions;

public class TextOverlayActivity extends BaseActivity {

	@Override
	public void init() {
		TextOptions options = new TextOptions();
		options.position(hmPos)			// λ��
				.text("�������Ա")			// ��������
				.fontSize(20)			// ���ִ�С
				.fontColor(0XFF000000)	// ������ɫ
				.bgColor(0X55FF0000)	// ������ɫ
				.rotate(30);			// ��ת
		baiduMap.addOverlay(options);
	}

}
