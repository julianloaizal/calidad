package beans;

import beans.Ciudad;
import beans.Pais;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-20T22:13:48")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, Pais> paisNombre;
    public static volatile CollectionAttribute<Departamento, Ciudad> ciudadCollection;
    public static volatile SingularAttribute<Departamento, Integer> iddepartamento;
    public static volatile SingularAttribute<Departamento, String> nombre;

}