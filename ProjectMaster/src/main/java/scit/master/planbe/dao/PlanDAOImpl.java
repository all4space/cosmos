package scit.master.planbe.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PlanDAOImpl implements PlanDAO {

	@Autowired
	SqlSession Sqlsession;  
	
	
	

}
