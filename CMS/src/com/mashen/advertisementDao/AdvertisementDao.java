package com.mashen.advertisementDao;

import java.util.List;

import com.mashen.domian.Advertisement;

public interface AdvertisementDao {
	public List<Advertisement> advertisementshow(String dvertiseMentName);
	public int advertisementAdd(Advertisement advertisement);
	public int advertisementDelete(Integer advertisementId);
	public int advertisementUpdata(Advertisement advertisement);
}
