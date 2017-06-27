package com.mashen.advertisementDao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mashen.domian.Advertisement;
import com.mashen.util.C3P0Util;

public class AdvertisementDaoImp implements AdvertisementDao{

	@Override
	public List<Advertisement> advertisementshow(String advertisementName) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			if(advertisementName!=null ){
				List<Advertisement> list = qr.query("select * from t_advertisement where advertisementname like ?",  new BeanListHandler<Advertisement>(Advertisement.class),advertisementName+"%");
				return list;
			}else{
				List<Advertisement> list = qr.query("select * from t_advertisement",  new BeanListHandler<Advertisement>(Advertisement.class));
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int advertisementAdd(Advertisement advertisement) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
				return qr.update("insert t_advertisement values(?,?,?,?)",null,advertisement.getAdvertisementName(),advertisement.getAdvertisementUrl(),advertisement.getAdvertisementImg());	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int advertisementDelete(Integer advertisementId) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
				return qr.update("delete from t_advertisement where advertisementId=?",advertisementId);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int advertisementUpdata(Advertisement advertisement) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		System.out.println(advertisement);
		try {
				return qr.update("update t_advertisement set advertisementname=?,"
						+ "advertisementurl=?,"
						+ "advertisementimg=? where "
						+ "advertisementId=?",
						advertisement.getAdvertisementName(),
						advertisement.getAdvertisementUrl(),
						advertisement.getAdvertisementImg(),
						advertisement.getAdvertisementId());	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
