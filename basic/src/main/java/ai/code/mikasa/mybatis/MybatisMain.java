package ai.code.mikasa.mybatis;

import ai.code.mikasa.mybatis.entity.TestInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisMain {
    private static Logger logger = LoggerFactory.getLogger(MybatisMain.class);

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dao.xml");

        TestInfoDao testInfoDao = (TestInfoDao) context.getBean("testInfoDao");

        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();

        TestInfo testInfo = testInfoDao.getById(sqlSession);

        sqlSession.close();
        logger.info("get testInfo:{}.", testInfo);
    }
}
