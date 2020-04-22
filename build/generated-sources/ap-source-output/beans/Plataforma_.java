package beans;

import beans.Empleado;
import beans.Operacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-20T22:13:48")
@StaticMetamodel(Plataforma.class)
public class Plataforma_ { 

    public static volatile SingularAttribute<Plataforma, Double> impuesto;
    public static volatile CollectionAttribute<Plataforma, Empleado> empleadoCollection;
    public static volatile SingularAttribute<Plataforma, String> idplat;
    public static volatile SingularAttribute<Plataforma, Double> cobroxhora;
    public static volatile SingularAttribute<Plataforma, Operacion> operacion;

}