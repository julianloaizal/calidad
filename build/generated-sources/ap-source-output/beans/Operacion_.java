package beans;

import beans.Plataforma;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-20T22:13:48")
@StaticMetamodel(Operacion.class)
public class Operacion_ { 

    public static volatile SingularAttribute<Operacion, Plataforma> plataforma;
    public static volatile SingularAttribute<Operacion, String> proveedor;
    public static volatile SingularAttribute<Operacion, String> cantidadCombustible;
    public static volatile SingularAttribute<Operacion, Integer> precioxlibra;
    public static volatile SingularAttribute<Operacion, Integer> precioTotal;
    public static volatile SingularAttribute<Operacion, String> idoperacion;

}