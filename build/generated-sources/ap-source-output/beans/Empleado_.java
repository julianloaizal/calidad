package beans;

import beans.Cargo;
import beans.EmpleadoPK;
import beans.Plataforma;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-20T22:13:48")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> fechaIngreo;
    public static volatile SingularAttribute<Empleado, Short> peso;
    public static volatile SingularAttribute<Empleado, Cargo> cargoIdCargo;
    public static volatile SingularAttribute<Empleado, EmpleadoPK> empleadoPK;
    public static volatile SingularAttribute<Empleado, Plataforma> plataforma;
    public static volatile SingularAttribute<Empleado, Short> estatura;

}