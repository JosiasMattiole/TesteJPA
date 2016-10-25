package controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Josias
 */
public class CriaBanco {
    
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("TesteJPAPU");
    
    public static EntityManager getEntityManager(){
        System.out.println("Entity manager criado com sucesso!!");
        return FACTORY.createEntityManager();
    }
}
