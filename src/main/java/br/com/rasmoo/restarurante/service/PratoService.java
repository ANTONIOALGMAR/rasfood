package br.com.rasmoo.restarurante.service;

import br.com.rasmoo.restarurante.dao.PratoDao;
import br.com.rasmoo.restarurante.entity.Cardapio;
import br.com.rasmoo.restarurante.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class PratoService {

    public static void main(String[] args) {

        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.60));

        Cardapio salmao = new Cardapio();
        salmao.setNome("Salmao ao molho de marcujá");
        salmao.setDescricao("Salmao grelhado ao molho de maracuja");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(88.60));

        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        PratoDao pratoDao = new PratoDao(entityManager);
        entityManager.getTransaction().begin();
        pratoDao.cadastrar(risoto);
        entityManager.flush();
        pratoDao.cadastrar(salmao);
        entityManager.flush();
        System.out.println("O prato consultado foi: " + pratoDao.consultar(2));
        System.out.println("O prato consultado foi: " + pratoDao.consultar(1));

        pratoDao.excluir(salmao);
        System.out.println("O prato consultado foi: " + pratoDao.consultar(2));

        entityManager.clear();
        risoto.setValor(BigDecimal.valueOf(75.50));
        pratoDao.atualizar(risoto);
        System.out.println("O prato consultado foi: " + pratoDao.consultar(1));


    }
}
