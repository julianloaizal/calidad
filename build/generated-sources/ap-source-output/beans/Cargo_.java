package beans;

import beans.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-20T22:13:48")
@StaticMetamodel(Cargo.class)
public class Cargo_ { 

    public static volatile SingularAttribute<Cargo, String> descripcion;
    public static volatile SingularAttribute<Cargo, Integer> idcargo;
    public static volatile CollectionAttribute<Cargo, Empleado> empleadoCollection;
    public static volatile SingularAttribute<Cargo, String> nombre;

}