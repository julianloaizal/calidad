package beans;

import beans.Departamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-20T22:13:48")
@StaticMetamodel(Pais.class)
public class Pais_ { 

    public static volatile CollectionAttribute<Pais, Departamento> departamentoCollection;
    public static volatile SingularAttribute<Pais, String> idioma;
    public static volatile SingularAttribute<Pais, String> nombre;

}