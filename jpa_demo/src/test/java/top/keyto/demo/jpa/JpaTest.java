package top.keyto.demo.jpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import top.keyto.demo.jpa.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * @author Keyto
 * Created on 2019/10/22
 */
@Slf4j
public class JpaTest {
    @Test
    public void testSave() {
        Article article = new Article();
        article.setAuthor("Keyto");
        article.setTitle("Spring Boot 食用指南");
        article.setCreateTime(new Date());
        log.info("testSave: {}", article);

        // 1 创建持久化管理器工厂
        String persistenceUnitName = "jpa01";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);

        // 2 创建持久化管理器
        EntityManager entityManager = factory.createEntityManager();

        // 3 开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // 4 操作
        entityManager.persist(article);

        // 5 提交事务
        transaction.commit();

        // 6 关闭资源
        entityManager.close();
    }

    @Test
    public void testFind() {
        String persistenceUnitName = "jpa01";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // 4 操作
        Article article = entityManager.find(Article.class, 1);
        log.info("testFind: {}", article);

        transaction.commit();
        entityManager.close();
    }

    @Test
    public void testUpdate() {
        String persistenceUnitName = "jpa01";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // 4 操作
        Article article = entityManager.find(Article.class, 1);
        article.setAuthor("top");
        entityManager.merge(article);
        log.info("testUpdate: {}", article);

        transaction.commit();
        entityManager.close();
    }

    @Test
    public void testDelete() {
        String persistenceUnitName = "jpa01";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // 4 操作
        Article article = entityManager.find(Article.class, 1);
        entityManager.remove(article);
        log.info("testDelete: {}", article);

        transaction.commit();
        entityManager.close();
    }
}
