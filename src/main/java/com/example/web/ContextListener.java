package com.example.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.example.dao.DeputyDao;
import com.example.model.Deputy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ContextListener implements ServletContextListener {
    private AtomicReference<DeputyDao> dao;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        List<Deputy> deputyList = new ArrayList<>();
        deputyList.add(new Deputy(1, "kadenciya", "roshen", "Petro", "Poroshenko", 57));
        deputyList.add(new Deputy(2, "MladshiyLeytenant", "MalchikMolodoy", "Yulia", "Tymoshenko ", 62));
        deputyList.add(new Deputy(3, "ubitLyashko", "lyashkaNaVila", "Yuriy", "Boyko", 64));
        deputyList.add(new Deputy(4, "arakhamia", "neSharyu", "David", "Arakhamia", 43));
        deputyList.add(new Deputy(5, "korolevska", "vperedNogami", "Natalia", "Korolevska ", 47));
        dao = new AtomicReference<>(new DeputyDao());
        dao.get().setDeputies(deputyList);
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("dao", dao);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        dao = null;
    }
}
