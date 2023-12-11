package cesur.examen.domain.client;

import cesur.examen.common.HibernateUtil;
import cesur.examen.domain.car.Car;
import cesur.examen.domain.car.CarDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Raúl Herrera Alba
 * Fecha: 11-12-2023
 */

public class ClientService {

    /**
     * Return a List of Client entities that have one or more cars of the given manufacturer.
     * If a client has more than one car of the manufacturer, it only appears once in
     * the list (similar to a Set). Tip: start querying to Car entities...
     *
     * @param manufacturer
     * @return the list of clients
     */
    public static List<Client> hasManufacturer(String manufacturer){

        var out= new ArrayList<Client>(0);
        List<Car> carByManufacturer = CarDAO.getAllByManufacturer(manufacturer);

        Set<Client> clientsManufacter = new HashSet<>();

        for (Car car : carByManufacturer){
            clientsManufacter.add(car.getClient());
        }

        out.addAll(clientsManufacter);

        return out;
    }
}
