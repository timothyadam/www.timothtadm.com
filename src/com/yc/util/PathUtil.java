package com.yc.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cplatform.util2.TimeStamp;
import com.sun.org.apache.bcel.internal.generic.NEW;


@Component
public class PathUtil {

	@Autowired
	AppConfig appConfig;

	
	/*public String getKeyPrefix(String key) {
		return appConfig.getUploadFileDir();
	}

	public PathInfo getPathInfo(String module, String ext, Long... ids) {
		String webpath = "";
		String savepath = "";
		String filename = "";
		ext = ext.toLowerCase();
		String time = TimeStamp.getTime(TimeStamp.YYYYMMDDhhmmssxxx);
		String dir1 = time.substring(0, 8);
		String dir2 = time.substring(8, 10);
		String dir3 = time.substring(10);
		webpath = String.format("%s/%s/", dir1, dir2);
		savepath = String.format("%s/%s/", dir1, dir2);
		filename = String.format("brand_%s%s.%s", dir2, dir3, ext);
		return new PathInfo(appConfig.getUploadFileDir() + savepath, webpath, filename);
	}

		*//**
	 * ��ȡ��ͬҵ�����͵��ļ����·��
	 * 
	 * @param key
	 *            ҵ��key
	 * @param id
	 *            ҵ��id
	 * @param ext
	 *            ��չ��
	 * @return
	 *//*
	public PathInfo getPathById(String key, long id, String ext) {

		String webpath = "";
		String savepath = "";// ����·��
		String filename = "";// �ļ����
		ext = ext.toLowerCase();

		
		 * �㷨�� ��һ�� = ID/(2000*2000) �ڶ���= (ID mod ��2000��2000����/2000 ����� = ID mod
		 * 2000
		 
		long l1 = id / (2000 * 2000);

		long l2 = (id % (2000 * 2000)) / 2000;

		long l3 = id % 2000;

		webpath = String.format(key+"/%d/%d/%d/", l1, l2, l3);
		savepath = String.format(key+"/%d/%d/%d/", l1, l2, l3);
		filename = String.format("o_%d%d%d_%s.%s", l1, l2, l3, TimeStamp.getTime(TimeStamp.YYYYMMDDhhmmssxxx), ext);
		return new PathInfo(appConfig.getUploadFileDir() + savepath, webpath, filename);
	}

	
	public PathInfo getPathById(String ext) {

		String webpath = "";
		String savepath = "";
		String filename = "";
		ext = ext.toLowerCase();
        Date date= new Date();
		
		long l1 = date.getYear();

		long l2 = date.getMonth();

		//long l3 = id % 2000;

		webpath = String.format("/%d/%d/", l1, l2);
		savepath = String.format("/%d/%d/", l1, l2);
		filename = String.format("o_%d%d%d_%s.%s", l1, l2, TimeStamp.getTime(TimeStamp.YYYYMMDDhhmmssxxx), ext);
		return new PathInfo(appConfig.getUploadFileDir() + savepath, webpath, filename);
	}

	
	
	public static String getItemPic(String key, Long id, int indx) {
		long l1 = id / (2000 * 2000);
		long l2 = (id % (2000 * 2000)) / 2000;
		long l3 = id % 2000;
		String savepath = String.format(key+"/%d/%d/%d/N%d/", l1, l2, l3, indx);
		return savepath;
	}

	public static class PathInfo {

		public PathInfo(String savepath, String webpath, String filename) {
			this.savepath = savepath;
			this.webPath = webpath;
			this.filename = filename;
		}

		private String savepath;

		private String filename;

		private String webPath;

		public String getRealPath() {
			return this.getSavepath() + this.getFilename();
		}

	
		public String getRealWebPath(String contextPath) {
			return contextPath + this.getWebPath() + this.getFilename();
		}

		public String getFilename() {
			return filename;
		}

		public void setFilename(String filename) {
			this.filename = filename;
		}

		public String getWebPath() {
			return webPath;
		}

		public void setWebPath(String webPath) {
			this.webPath = webPath;
		}

		public String getSavepath() {
			return savepath;
		}

		public void setSavepath(String savepath) {
			this.savepath = savepath;
		}

	}

	// public static String getExtName(String fileName){
	//
	// String extName="";
	// //int indexPos=0;
	//
	// if(!"".equals(fileName)&&fileName!=null){
	// if(fileName.indexOf(".")>-1){
	//
	// extName=fileName.substring(fileName.indexOf(".")+1);
	// }
	//
	// }
	// return extName;
	//
	// }

	public static void main(String[] args) {
		// /long number = 7999999999L;

		// /String fileName="test.doc";

		// /System.out.println(PathUtil.getExtName(fileName));

		// long maxFeeAmount=Long.valueOf("49999.99");
		double a1 = Double.parseDouble("4999.99") * 100;
		System.out.println(new Double(a1).longValue() + "");

	}*/
}
