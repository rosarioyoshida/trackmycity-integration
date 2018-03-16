package br.com.trackmycity.beans.google;


public class GeoLocation {

	private double radLat;
	private double radLon;

	public static final double EARTH_RADIUS = 6371.01;

	private double degLat; // latitude in degrees
	private double degLon; // longitude in degrees
	private double radDist; // distanceInKm / EARTH_RADIUS;

	private static final double MIN_LAT = Math.toRadians(-90d); // -PI/2
	private static final double MAX_LAT = Math.toRadians(90d); // PI/2
	private static final double MIN_LON = Math.toRadians(-180d); // -PI
	private static final double MAX_LON = Math.toRadians(180d); // PI

	private GeoLocation() {
	
	}

	/**
	 * Calcula Computes the great circle distance between this GeoLocation
	 * instance and the location argument.
	 * 
	 * @param O
	 *            radio da espera, e.g. A média do radio para uma figura
	 *            aproximada da terra é aproximadamente 6371.01 km.
	 * @return a distancia, medida no mesma unidade com o argumento radio
	 */
	public double distanceTo(GeoLocation location) {
		return Math.acos(Math.sin(radLat) * Math.sin(location.radLat)
				+ Math.cos(radLat) * Math.cos(location.radLat)
				* Math.cos(radLon - location.radLon))
				* EARTH_RADIUS;
	}

	public GeoLocation[] boundingCoordinates(double distance) {
		double distanceInKm = distance * .001;
		
		if (EARTH_RADIUS < 0d || distance < 0d) {
			throw new IllegalArgumentException();
		}

		this.radDist = distanceInKm / EARTH_RADIUS;
		double minLat = radLat - this.radDist;
		double maxLat = radLat + this.radDist;
		double minLon;
		double maxLon;

		if (minLat > MIN_LAT && maxLat < MAX_LAT) {
			double deltaLon = Math.asin(Math.sin(this.radDist) / Math.cos(radLat));
			minLon = radLon - deltaLon;
			if (minLon < MIN_LON)
				minLon += 2d * Math.PI;
			maxLon = radLon + deltaLon;
			if (maxLon > MAX_LON)
				maxLon -= 2d * Math.PI;
		} else {
			// a pole is within the distanceInKm
			minLat = Math.max(minLat, MIN_LAT);
			maxLat = Math.min(maxLat, MAX_LAT);
			minLon = MIN_LON;
			maxLon = MAX_LON;
		}

		return new GeoLocation[] { convertRadiansToDegrees(minLat, minLon),
				convertRadiansToDegrees(maxLat, maxLon) };

	}

	/**
	 * @param latitude
	 *            the latitude, in degrees.
	 * @param longitude
	 *            the longitude, in degrees.
	 */
	public static GeoLocation convertDegreesToRadians(double latitude, double longitude) {
		GeoLocation result = new GeoLocation();
		result.radLat = Math.toRadians(latitude);
		result.radLon = Math.toRadians(longitude);
		result.degLat = latitude;
		result.degLon = longitude;
		result.checkBounds();
		return result;
	}

	/**
	 * @param latitude
	 *            the latitude, in radians.
	 * @param longitude
	 *            the longitude, in radians.
	 */
	public static GeoLocation convertRadiansToDegrees(double latitude,
			double longitude) {
		GeoLocation result = new GeoLocation();
		result.radLat = latitude;
		result.radLon = longitude;
		result.degLat = Math.toDegrees(latitude);
		result.degLon = Math.toDegrees(longitude);
		result.checkBounds();
		return result;
	}

	private void checkBounds() {
		if (radLat < MIN_LAT || radLat > MAX_LAT || radLon < MIN_LON
				|| radLon > MAX_LON)
			throw new IllegalArgumentException();
	}

	@Override
	public String toString() {
		return "(" + degLat + "\u00B0, " + degLon + "\u00B0) = (" + radLat
				+ " rad, " + radLon + " rad)";
	}

	/**
	 * @return the latitude, in degrees.
	 */
	public double getLatitudeInDegrees() {
		return degLat;
	}

	/**
	 * @return the longitude, in degrees.
	 */
	public double getLongitudeInDegrees() {
		return degLon;
	}

	/**
	 * @return the latitude, in radians.
	 */
	public double getLatitudeInRadians() {
		return radLat;
	}

	/**
	 * @return the longitude, in radians.
	 */
	public double getLongitudeInRadians() {
		return radLon;
	}

	public double getRadDist() {
		return radDist;
	}
	
}
