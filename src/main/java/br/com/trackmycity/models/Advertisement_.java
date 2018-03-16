package br.com.trackmycity.models;

import br.com.trackmycity.models.embeddable.Location;
import java.net.URL;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-12-13T02:54:31.677-0200")
@StaticMetamodel(Advertisement.class)
public class Advertisement_ {
	public static volatile SingularAttribute<Advertisement, Long> id;
	public static volatile SingularAttribute<Advertisement, URL> icon;
	public static volatile SingularAttribute<Advertisement, String> description;
	public static volatile SingularAttribute<Advertisement, String> photo;
	public static volatile SingularAttribute<Advertisement, String> streetNumber;
	public static volatile SingularAttribute<Advertisement, Route> route;
	public static volatile SingularAttribute<Advertisement, Location> location;
	public static volatile SingularAttribute<Advertisement, String> formattedAddress;
}
