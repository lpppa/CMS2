package com.mashen.advertisementService;

import java.util.List;

import com.mashen.domian.Advertisement;

public interface AdvertisementService {
	public List<Advertisement> advertisementshow(String dvertiseMentName);
	public int advertisementAdd(Advertisement advertisement);
	public int advertisementDelete(Integer advertisementId);
	public int advertisementUpdata(Advertisement advertisement);
}
