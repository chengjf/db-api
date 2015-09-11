package com.chengjf.sparkdemo.module.wiki.dao;

import java.util.List;

import com.chengjf.sparkdemo.dao.ICommonDao;
import com.chengjf.sparkdemo.module.wiki.model.Text;

/**
 * wiki内容DAO接口
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-08
 */
public interface TextDao extends ICommonDao{

	public List<Text> getAllTexts();

	public Text getTextById(String id);

	public int addText(Text text);

	public int updateText(Text text);

	public int deleteText(Text text);

	public int deleteTextById(String id);
}
