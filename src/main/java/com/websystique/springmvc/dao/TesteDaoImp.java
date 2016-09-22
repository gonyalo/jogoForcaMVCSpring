package com.websystique.springmvc.dao;
 
import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
//import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.model.Teste;

//@Repository("employeeDao")
@Repository("testeDaoImp")
public class TesteDaoImp extends AbstractDao<Integer, Teste> implements TesteDaoInterface {
 
    @SuppressWarnings("unchecked")
    public List<Teste> findAllTestes(){
        Criteria criteria = createEntityCriteria();
        return (List<Teste>) criteria.list();
    }
 /*
    public Employee findById(int id) {
        return getByKey(id);
    }
 
    public void saveEmployee(Employee employee) {
        persist(employee);
    }
 
    public void deleteEmployeeBySsn(String ssn) {
        Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
        Criteria criteria = createEntityCriteria();
        return (List<Employee>) criteria.list();
    }
 
    public Employee findEmployeeBySsn(String ssn) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssn", ssn));
        return (Employee) criteria.uniqueResult();
    }
*/
}