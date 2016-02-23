/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.autocont.daos;

import cz.autocont.entities.Message;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Michael
 */
@Repository
@Transactional
public class MessageDaoImpl implements MessageDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean create(Message m) {
        if (em.contains(m)) {
            return false;
        }
        em.persist(m);
        em.flush();
        return true;
    }

    @Override
    public boolean remove(Message m) {
        if (m == null) {
            throw new NullPointerException("Message is null. Nothing to delete");
        }
        if (!em.contains(m)) {
            return false;
        }
        em.remove(em.merge(m));
        return true;
    }

    @Override
    public Message update(Message m) {
        return em.merge(m);
    }

    @Override
    public List<Message> findAll() {     
        return em.createQuery("SELECT m FROM Message m", Message.class).getResultList();
    }
    
}
