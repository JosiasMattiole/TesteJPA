package managedBean;

import controle.TarefaDao;
import modelo.Tarefa;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Josias
 */
@ManagedBean
@RequestScoped
public class TarefaMB {

    Tarefa tarefa = new Tarefa();
    TarefaDao tarefaDao = new TarefaDao();

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public void salvar(Tarefa tarefa) {
        tarefaDao.create(tarefa);
        listaTarefas();
    }
    
    public void excluir(Tarefa tarefa) {
        tarefaDao.delete(tarefa);
        listaTarefas();
    }
    
    public List<Tarefa> listaTarefas(){
        return tarefaDao.list();
    }
  
}
