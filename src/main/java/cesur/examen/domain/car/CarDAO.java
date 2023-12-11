package cesur.examen.domain.car;

import cesur.examen.common.DAO;
import cesur.examen.common.HibernateUtil;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;



import java.util.ArrayList;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Raúl Herrera Alba
 * Fecha: 11-12-2023
 */

@Log
public class CarDAO implements DAO<Car> {

    private SessionFactory sessionFactory;

    public CarDAO() {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Car save(Car car) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                // Comienza la transacción.
                transaction = session.beginTransaction();

                // Guarda el nuevo coche en la Base de Datos.
                session.save(car);

                // Commit de la transacción.
                transaction.commit();
            } catch (Exception e) {
                // Maneja cualquier excepción que pueda ocurrir durante la transacción.
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
            return car;
        }
    }


    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public boolean remove(Car car) {
        return false;
    }

    @Override
    public Car get(Long id) {
        return null;
    }

    @Override
    public List<Car> getAll() {
        return null;
    }

    public static List<Car> getAllByManufacturer(String manufacturer){

        var out = new ArrayList<Car>();

        try ( Session s = HibernateUtil.getSessionFactory( ).openSession( ) ) {
            Query<Car> q = s.createQuery( "from Car where manufacturer =: m " , Car.class );
            q.setParameter( "m" , manufacturer );
            out = ( ArrayList<Car> ) q.getResultList( );
        }
        return out;
    }

}

