package com.websystique.springmvc.dao;
 
import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
//import com.websystique.springmvc.model.Employee;
//import com.websystique.springmvc.model.Difficulty;
import com.websystique.springmvc.model.Word;

//@Repository("employeeDao")
@Repository("WordDaoImp")
public class WordDaoImp extends AbstractDao<Integer, Word> implements WordDaoInterface {
 
    @SuppressWarnings("unchecked")
    public List<Word> findAllWords(){
        Criteria criteria = createEntityCriteria();
        return (List<Word>) criteria.list();
    }
 
    public List<Word> findWordByDifficultyAndCategory(String difficulty, String category){
        SQLQuery query = getSession().createSQLQuery("SELECT id, description FROM websystique.word as word     JOIN    (SELECT word_id as result_word_id       FROM websystique.word_category      WHERE   difficulty_id =     ( SELECT id FROM websystique.difficulty WHERE description like :difficulty ) AND category_id=   (SELECT id  FROM websystique.category WHERE description like :category ) ) as result WHERE     result_word_id = id;");
        //Query query = getSession().createSQLQuery("SELECT id, description FROM websystique.word as word     JOIN    (SELECT word_id as result_word_id       FROM websystique.word_category      WHERE   difficulty_id =     ( SELECT id FROM websystique.difficulty WHERE description like ':difficulty') AND category_id=   (SELECT id  FROM websystique.category WHERE description like ':category' ) ) as result WHERE     result_word_id = id;");


        System.out.println(difficulty);
        System.out.println(category);


        //query.setParameter(1, difficulty);
        //query.setParameter(2, category);

        //query.setParameter("ccategory","objecto");        
        //query.setParameter("ddifficulty","easy");
        
        query.setString("difficulty",difficulty);
        query.setString("category",category);

         System.out.println(difficulty);
        System.out.println(category);

        query.addEntity(Word.class);
        return (List<Word>)query.list();
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