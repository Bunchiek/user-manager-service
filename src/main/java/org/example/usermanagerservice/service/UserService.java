package org.example.usermanagerservice.service;

import lombok.extern.slf4j.Slf4j;
import org.example.usermanagerservice.entity.User;
import org.example.usermanagerservice.exporter.UserExporter;
import org.example.usermanagerservice.exporter.UserExporterFactory;
import org.example.usermanagerservice.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class UserService {



    public void saveUsers(List<User> users) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            for (User user : users) {
                log.info("Saving user: {}", user);
                session.save(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.error("Error saving users: {}", e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    public void unloadUsers(int count) {

        List<User> users = getUsers(count);

        if (users.isEmpty()) {
            System.out.println("Нет пользователей для выгрузки.");
            return;
        }
        String filePath = "users.csv";

        UserExporter exporter = UserExporterFactory.getExporter("csv");

        exporter.export(users, filePath);
        System.out.println("Пользователи успешно выгружены в " + filePath);
    }

    private List<User> getUsers(int count) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session
                .createQuery("FROM User", User.class)
                .setMaxResults(count)
                .list();
    }

}
