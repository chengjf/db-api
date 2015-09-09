package com.chengjf.sparkdemo.module.wiki.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

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
		SqlSession sqlSession = this.factory.openSession();
		List<Text> list = sqlSession.selectList("getAllTexts");
		sqlSession.close();
		return list;
	}

	@Override
	public Text getTextById(String id) {
		SqlSession sqlSession = this.factory.openSession();
		Text text = sqlSession.selectOne("getTextById", id);
		sqlSession.close();
		return text;
	}

	@Override
	public int addText(Text text) {
		SqlSession sqlSession = this.factory.openSession();
		int result = sqlSession.insert("addText", text);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int updateText(Text text) {
		SqlSession sqlSession = this.factory.openSession();
		int result = sqlSession.update("updateText", text);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int deleteText(Text text) {
		SqlSession sqlSession = this.factory.openSession();
		int result = sqlSession.delete("deleteText", text);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int deleteTextById(String id) {
		SqlSession sqlSession = this.factory.openSession();
		int result = sqlSession.delete("deleteText", id);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}
