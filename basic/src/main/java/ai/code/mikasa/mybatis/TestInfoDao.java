package ai.code.mikasa.mybatis;

import ai.code.mikasa.mybatis.entity.TestInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

public class TestInfoDao {

    @Transactional(readOnly = true)
    public TestInfo getById(SqlSession session){
        TestInfo info = session.selectOne("ai.code.mikasa.mybatis.entity.TestInfo.selectOne", 2);
        return info;
    }
}
