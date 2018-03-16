package br.com.trackmycity.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-12-13T02:54:31.687-0200")
@StaticMetamodel(AlertType.class)
public class AlertType_ {
	public static volatile SingularAttribute<AlertType, Long> id;
	public static volatile SingularAttribute<AlertType, String> name;
	public static volatile SingularAttribute<AlertType, String> iconMenu;
	public static volatile SingularAttribute<AlertType, String> iconMap;
	public static volatile SingularAttribute<AlertType, AlertGroupType> alertGroupType;
}
