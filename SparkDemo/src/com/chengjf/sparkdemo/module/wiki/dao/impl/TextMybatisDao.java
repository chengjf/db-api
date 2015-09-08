package com.chengjf.sparkdemo.module.wiki.dao.impl;

import java.util.List;

import com.chengjf.sparkdemo.dao.impl.CommonMybatisDao;
import com.chengjf.sparkdemo.module.wiki.dao.TextDao;
import com.chengjf.sparkdemo.module.wiki.model.Text;

/**
 * TextDao的mybatis实现类
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-08
 */
public class TextMybatisDao extends CommonMybatisDao implements TextDao {

	@Override
	public List<Text> getAllTexts() {
		List<Text> list = this.getSqlSession().selectList("getAllTexts");
		return list;
	}

	@Override
	public Text getTextById(String id) {
		Text text = this.getSqlSession().selectOne("getTextById", id);
		return text;
	}

	@Override
	public int addText(Text text) {
		int result = this.getSqlSession().insert("addText", text);
		return result;
	}

	@Override
	public int updateText(Text text) {
		int result = this.getSqlSession().update("updateText", text);
		return result;
	}

	@Override
	public int deleteText(Text text) {
		int result = this.getSqlSession().delete("deleteText", text);
		return result;
	}

	@Override
	public int deleteTextById(String id) {
		int result = this.getSqlSession().delete("deleteText", id);
		return result;
	}

}
