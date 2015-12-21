package com.xxbg.jbapi.db.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yanli6 on 11/30/15.
 */
public class MyBatis {
    private SqlSession session;

    public MyBatis(String mybatisXML){
        try{
            InputStream is=Resources.getResourceAsStream(mybatisXML);
            //构建sqlSession的工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            //创建能执行映射文件中sql的sqlSession
            session = sessionFactory.openSession();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public SqlSession getSession(){
        return session;
    }

}
