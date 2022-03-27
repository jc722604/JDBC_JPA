package day14.hw1;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.*;
import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

/**
 *  JPA
 *      1. DataSource
 *      2. entity manager factory
 *          entity manager1 -> Thread1
 *          entity manager2 -> Thread2
 *          entityManager.persist()
 *          entityManager.merge();
 *      3. JPQL
 *      4.Diff between JPA & Hibernate: Hibernate provide both implementation
 *          1. Hibernate session standard
 *          2. JPA standard
 *          3. JPA just the standard, no implementation
 *  Hibernate (two implementation session factory and session)
 *      1. session factory
 *          session1 -> Thread1
 *          session2 -> Thread2
 *          session.save()
 *          session.saveOrUpdate();
 *
 *   lazy loading vs eager loading
 *   eager loading:
 *      Student stu = em.createQuery("select s from Student s");
 *      stu {teacher_student{...}} => 1 query
 *   lazy loading:
 *      Student stu = em.createQuery("select s from Student s");
 *      stu {teacher_student{empty}}
 *      stu.getTeacherStudent() => 2 queries
 *
 *      List<Student> stuList = ..
 *      for(Student stu: stuList) {
 *          stu.getTeacherStudent()
 *      } => N + 1 queries
 */
public class JPADemo {

    private DataSource getDataSource() {
//        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
//        dataSource.setDatabaseName("OrmDemo");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("J8e5n171455048");
        mysqlDataSource.setUrl("jdbc:mysql://localhost:3306/jdbc-practice");
        return mysqlDataSource;
    }

    private Properties getProperties() {
        final Properties properties = new Properties();

        properties.put( "hibernate", "org.hibernate.mysql" );
        properties.put( "hibernate.connection.driver_class", "org.mysql.Driver" );
//        properties.put("hibernate.show_sql", "true");
        return properties;
    }

    private EntityManagerFactory entityManagerFactory(DataSource dataSource, Properties hibernateProperties ){
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan( "day14/hw1" );
        em.setJpaVendorAdapter( new HibernateJpaVendorAdapter() );
        em.setJpaProperties( hibernateProperties );
        em.setPersistenceUnitName( "demo-unit" );
        em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        em.afterPropertiesSet();
        return em.getObject();
    }

    public static void main(String[] args) {
        JPADemo jpaDemo = new JPADemo();
        DataSource dataSource = jpaDemo.getDataSource();
        Properties properties = jpaDemo.getProperties();
        EntityManagerFactory entityManagerFactory = jpaDemo.entityManagerFactory(dataSource, properties);
        EntityManager em = entityManagerFactory.createEntityManager();

        PersistenceUnitUtil unitUtil = entityManagerFactory.getPersistenceUnitUtil();

//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        Student s = new Student("bbb", "Y");
//        s.setId("10");
//        em.merge(s);
//        tx.commit();


//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<Student> query = builder.createQuery(Student.class);
//        Root<Student> from = query.from(Student.class);
//        Predicate exp1 = builder.equal(from.get("first_name"), "xx");
//        Predicate exp2 = null;
//        if(!"xx".equals(null)) {
//            exp2 = builder.equal(from.get("last_name"), "xx");
//        }
//        Predicate exp3 = builder.or(exp1, exp2);
//        query.where(exp3);
    //        Query q = em.createQuery(query);
        updateFunc(em);

        List<Supervisor> sList = em.createQuery("select s from supervisor s join s.supervisor_employee se").getResultList();
        Supervisor s = sList.get(0);
        System.out.println("**************************************");
        System.out.println("class is loaded : " + unitUtil.isLoaded(s));
    }


    private static void createFunc(EntityManager em) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Employee e = new Employee();
        e.setFirst_name("Chen");
        e.setLast_name("JenHao");

        Supervisor s = new Supervisor();
        em.persist(s);
        s.setName("Mike");

        Supervisor_Employee se = new Supervisor_Employee();
        se.setEmployee(e);
        se.setSupervisor(s);
        s.addSupervisor_Employee(se);

        em.persist(s);
        et.commit();
    }

    private static void insertFunc(EntityManager em) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Query query = em.createNativeQuery("INSERT INTO SUPERVISOR_EMPLOYEE (supervisor_id, employee_id) VALUE(?, ?)");
        query.setParameter(1, 5);
        query.setParameter(2, 6);
        query.executeUpdate();
        et.commit();
    }

    private static void retrieveFunc(EntityManager em) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Employee e = em.find(Employee.class, "1");
        Supervisor s = em.find(Supervisor.class, "2");
        Supervisor_Employee se = new Supervisor_Employee();
        se.setEmployee(e);
        se.setSupervisor(s);
        em.persist(se);
        et.commit();
    }

    private static void updateFunc(EntityManager em) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Employee e = em.find(Employee.class, 4);
        e.setFirst_name("Wang");
        et.commit();
    }

    private static void deleteFunc(EntityManager em) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Employee e = em.find(Employee.class, 7);
        em.remove(e);
        et.commit();
    }











}