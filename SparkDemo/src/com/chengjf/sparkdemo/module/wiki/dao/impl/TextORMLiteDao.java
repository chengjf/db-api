package com.chengjf.sparkdemo.module.wiki.dao.impl;

import java.util.List;

import com.chengjf.sparkdemo.module.wiki.dao.TextDao;
import com.chengjf.sparkdemo.module.wiki.model.Text;

/**
 * TextDao的ORMLite实现
 * 
 * @author sharp
 * @date 2015-9-13
 * 
 */
public class TextORMLiteDao implements TextDao {

	@Override
	public List<Text> getAllTexts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Text getTextById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addText(Text text) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateText(Text text) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteText(Text text) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTextById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
