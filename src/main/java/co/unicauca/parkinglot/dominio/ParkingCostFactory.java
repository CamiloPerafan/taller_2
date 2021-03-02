package co.unicauca.parkinglot.dominio;

/**
 *
 * @author Admin
 */

import co.unicauca.parkinglot.dominio.IParkingCost;
import co.unicauca.parkinglot.dominio.TypeEnum;
import java.util.EnumMap;
import java.util.Map;


public class ParkingCostFactory {

    private Map<TypeEnum, IParkingCost> deliveryDictionary;

    // Singleton
    private static ParkingCostFactory instance;

    private ParkingCostFactory() {
        deliveryDictionary = new EnumMap<>(TypeEnum.class);
        deliveryDictionary.put(TypeEnum.CAR, new CarParkingCost());
        deliveryDictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        deliveryDictionary.put(TypeEnum.TRUCK,new TruckParkingCost());        
        // Si se requie otto pais, se abre un registro en este diccionario
        // No se viola el principio porque este este modulo no está pensado
        // para que sea estable.
    }

    public static ParkingCostFactory getInstance() {
        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }

    /**
     * Para un pais determina la clase que se encarga de calcular el costo del
     * envío.
     *
     * @param country
     * @return
     */
    public IParkingCost getDelivery(TypeEnum vehicle) {

        IParkingCost result = null;

        if (deliveryDictionary.containsKey(vehicle)) {
            result = deliveryDictionary.get(vehicle);
        }

        return result;

    }
}