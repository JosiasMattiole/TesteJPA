package controle;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Tarefa;

/**
 *
 * @author Josias
 */
public class TarefaDao {
    
    public Tarefa create(Tarefa tarefa){
        EntityManager manager = null;
        try {
            manager = CriaBanco.getEntityManager();
            manager.getTransaction().begin();
            manager.persist(tarefa);
            manager.getTransaction().commit();
            System.out.println("Salvo com sucesso!");
        }catch(IllegalArgumentException ex){
            System.out.println("Argumentos incorretos ao salvar " + ex.getLocalizedMessage());
        }finally {
            if (manager != null) {
                manager.close();
            }
        }
        return tarefa;
    }
    
    public Tarefa delete(Tarefa tarefa){
        EntityManager manager = null;
        
        try {
            manager = CriaBanco.getEntityManager();
            /*Busca a tarefa pela chave primaria*/
            tarefa = manager.find(Tarefa.class, tarefa.getId());
            manager.getTransaction().begin();
            manager.remove(tarefa);
            manager.getTransaction().commit();
            System.out.println("Deletado com sucesso!");
        }catch(IllegalArgumentException ex){
            System.out.println("Argumentos incorretos ao excluir " + ex.getLocalizedMessage());
        }finally {
            if (manager != null) {
                manager.close();
            }
        }
        return tarefa;
    }
    
    public List<Tarefa> list(){
        EntityManager manager = null;
        
        List<Tarefa> listaTarefas = new ArrayList<>();
        
        try{
            manager = CriaBanco.getEntityManager();
            
            TypedQuery<Tarefa> query = manager.createQuery("select t from Tarefa t", Tarefa.class);
            listaTarefas = query.getResultList();
            
        }catch(IllegalArgumentException ex){
            System.out.println("Não foi possivel retornar a lista de informações!" + ex.getLocalizedMessage());
        }finally{
            
        }
        
        return listaTarefas;
    }
}
