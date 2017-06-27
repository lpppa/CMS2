package com.mashen.advertisementService;

import java.util.List;

import com.mashen.advertisementDao.AdvertisementDao;
import com.mashen.advertisementDao.AdvertisementDaoImp;
import com.mashen.domian.Advertisement;

public class AdvertisementServiceImp implements AdvertisementService{
	AdvertisementDao ad=new AdvertisementDaoImp();
	@Override
	public List<Advertisement> advertisementshow(String dvertiseMentName) {
		return ad.advertisementshow(dvertiseMentName);
	}

	@Override
	public int advertisementAdd(Advertisement advertisement) {
		return ad.advertisementAdd(advertisement);
	}

	@Override
	public int advertisementDelete(Integer advertisementId) {
		return ad.advertisementDelete(advertisementId);
	}

	@Override
	public int advertisementUpdata(Advertisement advertisement) {
		return ad.advertisementUpdata(advertisement);
	}
	
}
