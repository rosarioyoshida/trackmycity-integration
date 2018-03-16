package br.com.trackmycity.models;

import br.com.trackmycity.models.embeddable.Location;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-12-13T02:54:31.693-0200")
@StaticMetamodel(UserAlert.class)
public class UserAlert_ {
	public static volatile SingularAttribute<UserAlert, Long> id;
	public static volatile SingularAttribute<UserAlert, String> description;
	public static volatile SingularAttribute<UserAlert, byte[]> photo;
	public static volatile SingularAttribute<UserAlert, String> streetNumber;
	public static volatile SingularAttribute<UserAlert, Route> route;
	public static volatile SingularAttribute<UserAlert, Location> location;
	public static volatile SingularAttribute<UserAlert, String> formattedAddress;
	public static volatile SingularAttribute<UserAlert, AlertType> alertType;
	public static volatile SingularAttribute<UserAlert, User> user;
}
