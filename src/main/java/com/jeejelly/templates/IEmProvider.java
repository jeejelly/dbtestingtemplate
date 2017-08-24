package com.jeejelly.templates;

import javax.persistence.EntityManager;

public interface IEmProvider {
    IEmProvider setEm(EntityManager em);

    EntityManager getEm();
}
