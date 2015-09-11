package in.anandm.oj.repository.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;

public class BaseJPARepository<T, ID extends Serializable> extends
        GenericDAOImpl<T, ID> {

    @Override
    public void setSearchProcessor(JPASearchProcessor searchProcessor) {

        super.setSearchProcessor(searchProcessor);
    }

    @PersistenceContext
    @Override
    public void setEntityManager(EntityManager entityManager) {

        super.setEntityManager(entityManager);
    }

}
