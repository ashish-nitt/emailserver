package com.sample.project.service;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.Blob;
import java.sql.Clob;

/**
 * Created by Ashish on 21-05-2018.
 */
@Service
public class LobHelper {
    @Autowired
    HibernateEntityManagerFactory entityManagerFactory;

    private final SessionFactory sessionFactory;

    @Autowired
    public LobHelper(HibernateEntityManagerFactory sessionFactory) {
        this.sessionFactory = sessionFactory.getSessionFactory();
    }

    public Blob createBlob(InputStream content, long size) {
        return sessionFactory.getCurrentSession().getLobHelper().createBlob(content, size);
    }

    public Clob createClob(InputStream content, long size, Charset charset) {
        return sessionFactory.getCurrentSession().getLobHelper().createClob(new InputStreamReader(content, charset), size);
    }
}
