package com.hunter.job.repositories;

import com.hunter.job.domain.VerificationToken;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
@Transactional
public class VerificationTokenRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public VerificationToken save(VerificationToken verificationTokenCandidat){
        entityManager.persist(verificationTokenCandidat);
        return verificationTokenCandidat;
    }

    public void delete(VerificationToken verificationTokenCandidat){
        entityManager.remove(verificationTokenCandidat);
    }

    public VerificationToken findByToken(String token){
        TypedQuery<VerificationToken> query = entityManager.createQuery("select v from VerificationToken v where token =:token", VerificationToken.class);
        query.setParameter("token",token);
        try {
            return  query.getSingleResult();
        }catch (NoResultException e){
            return  null;
        }

    }

}
