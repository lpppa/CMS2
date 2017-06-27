package com.mashen.slideShowService;

import java.util.List;

import com.mashen.domian.SlideShow;
import com.mashen.slideShowDao.SlideShowDao;
import com.mashen.slideShowDao.SlideShowDaoImp;

public class SlideShowServiceImp implements SlideShowService{
	private SlideShowDao sd=new SlideShowDaoImp();
	@Override
	public int slideShowAdd(SlideShow slideShow) {
		return sd.slideShowAdd(slideShow);
	}

	@Override
	public int slideShowDelete(Integer slideShowId) {
		return sd.slideShowDelete(slideShowId);
	}

	@Override
	public int slideShowUpdate(SlideShow slideShow) {
		return sd.slideShowUpdate(slideShow);
	}

	@Override
	public List<SlideShow> slideShowSearch(SlideShow slideShow) {
		return sd.slideShowSearch(slideShow);
	}

	@Override
	public List<SlideShow> slideShowing() {
		return sd.slideShowing();
	}

	@Override
	public List<SlideShow> slideShouPush(Integer slideShowId) {
		return sd.slideShouPush(slideShowId);
	}

	@Override
	public List<SlideShow> slideShouPushOff(Integer slideShowId) {
		return sd.slideShouPushOff(slideShowId);
	}

}
