package com.jdbc.labs;

import org.junit.*;
import org.springframework.transaction.annotation.Transactional;

import com.jdbc.labs.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.assertNotNull;

@Transactional
public class StandaloneTest {
    private EntityManagerFactory emf;
    private EntityManager em;

    @Before
    public void setUp() throws Exception {
        emf = Persistence.createEntityManagerFactory("standalone");
        em = emf.createEntityManager();
    }

    @Test
    public void testPersist() throws Exception {
        Employee employee = new Employee();

        employee.setId(2L);
        employee.setName("Superman");
        employee.setSalary(3000D);

        em.getTransaction().begin();

        em.merge(employee);

        em.getTransaction().commit();

        assertNotNull(employee.getId());
    }

    @After
    public void closeEntityManager() {
        em.close();
        emf.close();
    }

    
}
