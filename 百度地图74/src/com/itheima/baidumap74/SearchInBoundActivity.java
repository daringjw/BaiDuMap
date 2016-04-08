package com.itheima.baidumap74;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;

public class SearchInBoundActivity extends PoiSearchBaseActivity {

	@Override
	public void poiSearchInit() {
		poiSearch.searchInBound(getSearchParams());
	}
	
	private PoiBoundSearchOption getSearchParams() {
		PoiBoundSearchOption params = new PoiBoundSearchOption();
		
		// ָ��������Χ����һ�����ϵ��һ����������ɵķ�Χ
		LatLngBounds bounds = new LatLngBounds.Builder().include(new LatLng(40.048459,116.302072))
														.include(new LatLng(40.050675,116.304317)).build();
		params.bound(bounds);	// ָ��������Χ
		params.keyword("����վ");	// ָ������ʲô����
		return params; 
	}

	/** ��ȡ��Ȥ��������Ϣ */
	@Override
	public void onGetPoiDetailResult(PoiDetailResult result) {
		
	}

}
