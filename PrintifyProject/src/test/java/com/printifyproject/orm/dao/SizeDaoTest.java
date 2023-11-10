package com.printifyproject.orm.dao;

import com.printifyproject.orm.model.SizeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SizeDaoTest {

    private ApplicationContext applicationContext;
    private SizeDao sizeDao;
    @PersistenceContext
    private EntityManager entityManager;
    private PlatformTransactionManager transactionManager;

    @BeforeEach
    void setUp() {
        applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        sizeDao = applicationContext.getBean(SizeDao.class);
        entityManager = applicationContext.getBean(EntityManager.class);
        transactionManager = applicationContext.getBean(PlatformTransactionManager.class);
    }

    @Test
    void testInsertAndFindById() {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        SizeEntity newSize = new SizeEntity();
        newSize.setSize("Medium");
        sizeDao.insert(newSize);

        Optional<SizeEntity> foundSize = sizeDao.findById(newSize.getId());

        assertTrue(foundSize.isPresent());
        assertEquals("Medium", foundSize.get().getSize());

        transactionManager.rollback(status);
    }

    // Additional test methods

    // Remember to close the ApplicationContext in an @AfterEach or @AfterAll method if necessary
}
