/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Tercero;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author wgarnicap
 */
public class TerceroDao implements Serializable {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    public TerceroDao() {
        this.emf = Persistence.createEntityManagerFactory("GestionLibreriaBusesPU");
        this.em = emf.createEntityManager();
    }

    /**
     * Metodo que guarda en base de datos un Objeto Tercero
     *
     * @param entityManager
     * @param tercero: Objeto terceros a guardar
     * @throws Exception
     */
    public void insertarTercero(EntityManager entityManager, Tercero tercero) throws Exception {
        if (entityManager == null) {
            entityManager = this.em;
        }
        boolean hacerCommit = false;
        if (entityManager.getTransaction().isActive() == false) {
            entityManager.getTransaction().begin();
            hacerCommit = true;
        }
        entityManager.persist(tercero);
        if (hacerCommit == true) {
            entityManager.getTransaction().commit();
        }
    }

    /**
     * Metodo que modifica en base de datos un Objeto Tercero
     *
     * @param entityManager
     * @param tercero: Objeto terceros a modificar
     * @return Objeto Tercero modificado
     * @throws Exception
     */
    public Tercero modificarTercero(EntityManager entityManager, Tercero tercero)
            throws Exception {
        if (entityManager == null) {
            entityManager = this.em;
        }
        boolean hacerCommit = false;
        if (entityManager.getTransaction().isActive() == false) {
            entityManager.getTransaction().begin();
            hacerCommit = true;
        }
        tercero = entityManager.merge(tercero);
        if (hacerCommit == true) {
            entityManager.getTransaction().commit();
        }
        return tercero;
    }

    /**
     * Metodo que consulta datos un Objeto Tercero
     *
     * @param numIdentificacion: identificador por el cual se consulta
     * @return Objeto Tercero
     * @throws Exception
     */
    public Tercero consultaTercero(long numIdentificacion) throws Exception {
        return em.find(Tercero.class, numIdentificacion);
    }

    /**
     * Metodo que consulta las terceros en base de datos, filtrando por una
     * consulta y Lista de parametros y con un inicio y rango definido
     *
     * @param consulta: String que contiene la consulta a realizar
     * @return List< Tercero > :Lista de terceros consultado
     * @throws java.lang.Exception
     */
    public List<Tercero> consultarTercero(String consulta) throws Exception {
        StringBuilder query = new StringBuilder();
        query.append("SELECT t FROM Tercero t ");
        query.append(consulta);
        Query q = em.createQuery(query.toString());
        List<Tercero> listaTercero = q.getResultList();
        if (listaTercero != null && listaTercero.size() > 0) {
            return listaTercero;
        }
        return null;
    }

    public static void main(String arg[]) throws Exception {
        Tercero t = new Tercero();
        t.setApellidos("Rojas");
        t.setClave("123456");
        t.setNombres("Laura");
        t.setNumIdentificacion((long) 23484321);
        new TerceroDao().modificarTercero(null, t);

        List<Tercero> lstTerceros = new TerceroDao().consultarTercero("");
        if(lstTerceros!=null && lstTerceros.isEmpty()==false){
            lstTerceros.stream().forEach((tercero) -> {
                System.out.println("C.C: "+tercero.getNumIdentificacion()+"   Nombre completo: "+tercero.getNombres().trim()+" "+tercero.getApellidos().trim());
            });
        }
    }
}
