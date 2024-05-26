package br.com.rasmoo.restarurante.dao;

import br.com.rasmoo.restarurante.entity.Cardapio;

import javax.persistence.EntityManager;

public class PratoDao {

    private EntityManager entityManager;

    public PratoDao (EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar (final Cardapio cardapio){
        this.entityManager.persist(cardapio);
        System.out.println("Entidade cadastrada: " + cardapio);
    }

    public Cardapio consultar (final Integer id){
        return this.entityManager.find(Cardapio.class, id);
    }

    public void atualizar (final Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }


}
