package ai.code.mikasa.mybatis;

import ai.code.mikasa.mybatis.entity.TestInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInfoDao {

    public TestInfo getById(SqlSession session){
        TestInfo info = session.selectOne("ai.code.mikasa.mybatis.entity.TestInfo.selectOne", 2);
        return info;
    }
}
