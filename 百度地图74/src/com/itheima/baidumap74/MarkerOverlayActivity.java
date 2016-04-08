package com.itheima.baidumap74;

import android.view.View;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerDragListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.MapViewLayoutParams.ELayoutMode;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;

public class MarkerOverlayActivity extends BaseActivity {

	private View pop;
	private TextView tv_title;

	@Override
	public void init() {
		initMarker();
		baiduMap.setOnMarkerClickListener(mOnMarkerClickListener);
		baiduMap.setOnMarkerDragListener(mOnMarkerDragListener);
	}
	
	/** ��־�϶������� */
	OnMarkerDragListener mOnMarkerDragListener = new OnMarkerDragListener() {
		
		/** ��־��ʼ�϶� */
		@Override
		public void onMarkerDragStart(Marker marker) {
			mapView.updateViewLayout(pop, createLayoutParams(marker.getPosition()));
		}
		
		/** ��־�϶����� */
		@Override
		public void onMarkerDragEnd(Marker marker) {
			mapView.updateViewLayout(pop, createLayoutParams(marker.getPosition()));
		}
		
		/** ��־�����϶� */
		@Override
		public void onMarkerDrag(Marker marker) {
			mapView.updateViewLayout(pop, createLayoutParams(marker.getPosition()));
		}
	};
	
	
	 OnMarkerClickListener mOnMarkerClickListener = new OnMarkerClickListener() {

		@Override
		public boolean onMarkerClick(Marker marker) {
			// ��ʾһ������
			if (pop == null) {
				pop = View.inflate(MarkerOverlayActivity.this, R.layout.pop, null);
				tv_title = (TextView) pop.findViewById(R.id.tv_title);
				mapView.addView(pop, createLayoutParams(marker.getPosition()));
			} else {
				mapView.updateViewLayout(pop, createLayoutParams(marker.getPosition()));
			}
			tv_title.setText(marker.getTitle());
			return true;
		}
	};

	/** ��ʼ����־  ������ */
	private void initMarker() {
		MarkerOptions options = new MarkerOptions();
		BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.icon_eat);
		options.position(hmPos)		// λ��
				.title("����")		// title
				.icon(icon)			// ͼ��
				.draggable(true);	// ����ͼ������϶�
		
		baiduMap.addOverlay(options);
		
		// ���һ���򱱵ı�־
		options = new MarkerOptions().icon(icon)
				.title("��")
				.position(new LatLng(hmPos.latitude + 0.001, hmPos.longitude))
				.draggable(true);
		baiduMap.addOverlay(options);

		// ���һ���򶫵ı�־
		options = new MarkerOptions().icon(icon)
				.title("��")
				.position(new LatLng(hmPos.latitude, hmPos.longitude + 0.001))
				.draggable(true);
		baiduMap.addOverlay(options);

		// ���һ�������ϵı�־
		options = new MarkerOptions().icon(icon)
				.title("������")
				.position(new LatLng(hmPos.latitude - 0.001, hmPos.longitude - 0.001))
				.draggable(true);
		baiduMap.addOverlay(options);
	}

	/**
	 * ����һ�����ֲ���
	 * @param position
	 * @return
	 */
	private MapViewLayoutParams createLayoutParams(LatLng position) {
		MapViewLayoutParams.Builder buidler = new MapViewLayoutParams.Builder(); 
		buidler.layoutMode(ELayoutMode.mapMode);	// ָ����������Ϊ��γ��
		buidler.position(position);		// ���ñ�־��λ��
		buidler.yOffset(-25);			// ����View����ƫ��
		MapViewLayoutParams params = buidler.build();
		return params;
	}

}
