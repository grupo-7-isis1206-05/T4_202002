package model.logic;

public class Accidente implements Comparable<Accidente>{


	private String id;
	private String source;
	private double tmc;
	private double severity;
	private String start_time;
	private String end_time;
	private double start_lat;
	private double start_long;
	private double end_lat;
	private double end_long;
	private double distance;
	private String description;
	private double number;
	private String street;
	private String side;
	private String city;
	private String county;
	private String state;
	private String zipcode;
	private String country;
	private String timeZone;
	private String airportCode;
	private String weather_timestamp;
	private double temperatureFarenheit;
	private double windChillFarenheit;
	private double humidity;
	private double preassure;
	private double visibility;
	private String windDirection;
	private double windSpeed;
	private double precipitacion;
	private String weatherCondition;
	private boolean amenity;
	private boolean bump;
	private boolean crossing;
	private boolean give_way;
	private boolean junction;
	private boolean noExit;
	private boolean railway;
	private boolean roundAbout;
	private boolean station;
	private boolean stop;
	private boolean trafficCalming;
	private boolean trafficSignal;
	private boolean turningLoop;
	private String sunriseSunset;
	private String civilTwilight;
	private String nauticalTwilight;
	private String astronomicalTwilight;

	public Accidente(String pID, String pSource, double pTMC, double pSeverity, String pStarttime, String pEndtime, double pStartlat, double pStartlong, double pEndlat, double pEndlong, double pDistance, String pDescription, double pNumber, String pStreet, String pSide, String pCity, String pCounty, String pState, String pZipcode, String pCountry, String pTimeZone, String pAirportCode, String pWeathertimestamp, double pTemperatureFarenheit, double pWindChillFarenheit, double pHumidity, double pPreassure, double pVisibility,String pWindDirection, double pWindSpeed, double pPrecipitacion, String pWeatherCondition, boolean pAmenity, boolean pBump, boolean pCrossing, boolean pGive_way, boolean pJunction, boolean pNoExit, boolean pRailway, boolean pRoundAbout, boolean pStation, boolean pStop, boolean pTrafficCalming, boolean pTrafficSignal , boolean pTurningLoop, String pSunriseSunset,  String pCivilTwilight, String pNauticalTwilight, String pAstronomicalTwilight )
	{
		id= pID;
		source= pSource;
		tmc= pTMC;
		severity= pSeverity;
		start_time= pStarttime;
		end_time= pEndtime;
		start_lat= pStartlat;
		start_long= pStartlong;
		end_lat= pEndlat;
		end_long= pEndlong;
		distance= pDistance;
		description= pDescription;
		number= pNumber;
		street= pStreet;
		side= pSide;
		city= pCity;
		county = pCounty;
		state= pState;
		zipcode= pZipcode;
		country= pCountry;
		timeZone= pTimeZone;
		airportCode= pAirportCode;
		weather_timestamp= pWeathertimestamp;
		temperatureFarenheit= pTemperatureFarenheit;
		windChillFarenheit= pWindChillFarenheit;
		humidity= pHumidity;
		preassure= pPreassure;
		visibility= pVisibility;
		windDirection = pWindDirection;
		windSpeed = pWindSpeed;
		precipitacion = pPrecipitacion;
		weatherCondition= pWeatherCondition;
		amenity= pAmenity;
		bump= pBump;
		crossing= pCrossing;
		give_way= pGive_way;
		junction= pJunction;
		noExit= pNoExit;
		railway= pRailway;
		roundAbout= pRoundAbout;
		station= pStation;
		stop=pStop;
		trafficCalming= pTrafficCalming;
		trafficSignal= pTrafficSignal;
		turningLoop= pTurningLoop;
		sunriseSunset=pSunriseSunset;
		civilTwilight= pCivilTwilight;
		nauticalTwilight= pNauticalTwilight;
		astronomicalTwilight= pAstronomicalTwilight;

	}


	public String darId() 
	{
		return id;
	}


	public String darSource() {
		return source;
	}


	public double darTMC() 
	{
		return tmc;
	}


	public double darSeverity() {
		return severity;
	}

	public String darStartTime() {
		return start_time;
	}


	public String darEndTime() {
		return end_time;
	}


	public double darStartLat() 
	{
		return start_lat;
	}


	public double darStartLng() 
	{
		return start_long;
	}


	public double darEndLat() {
		return end_lat;
	}


	public double darEndLng() {
		return end_long;
	}


	public double darDistance() {
		return distance;
	}


	public String darDescription() {
		return description;
	}


	public double darNumber() {
		return number;
	}


	public String darStreet() {
		return street;
	}


	public String darSide() {
		return side;
	}


	public String darCity() {
		return city;
	}
	
	public String darCounty()
	{
		return county;
	}


	public String darCountry() {
		return country;
	}


	public String darState() {
		return state;
	}


	public String darZipcode() {
		return zipcode;
	}


	public String darTimezone() {
		return timeZone;
	}


	public String darAirportCode() {
		return airportCode;
	}


	public String darWeatherTimestamp() {
		return weather_timestamp;
	}


	public double darTemperature() {
		return temperatureFarenheit;
	}

	public double darWindChill() {
		return windChillFarenheit;
	}

	public double darHumidity() {
		return humidity;
	}

	public double darPressure() {
		return preassure;
	}

	public double darVisibility() {
		return visibility;
	}

	public String darWindDirection() {
		return windDirection;
	}

	public double darWindSpeed() {
		return windSpeed;
	}

	public double precipitation() {
		return precipitacion;
	}

	public String darWeatherCondition() {
		return weatherCondition;
	}

	public boolean darAmenity() {
		return amenity;
	}

	public boolean darBump() {
		return bump;
	}

	public boolean darCrossing() {
		return crossing;
	}

	public boolean darGiveWay() {
		return give_way;
	}

	public boolean darJunction() {
		return junction;
	}

	public boolean darNoExit() {
		return noExit;
	}

	public boolean darRailway() {
		return railway;
	}
	public boolean darRoundabout() {
		return roundAbout;
	}

	public boolean darStation() {
		return station;
	}

	public boolean darStop() {
		return stop;
	}

	public boolean darTrafficCalming() {
		return trafficCalming;
	}

	public boolean darTrafficSignal() {
		return trafficSignal;
	}

	public boolean darTurningLoop() {
		return turningLoop;
	}

	public String darSunriseSunset() {
		return sunriseSunset;
	}

	public String darCivilTwilight() {
		return civilTwilight;
	}

	public String darNauticalTwilight() {
		return nauticalTwilight;
	}

	public String darAstronomicalTwilight() {

		return astronomicalTwilight;
	}
	
	public String toStringCorto()
	{
		return "------------------------------\n"
				+id+"\n"
				+source+"\n"
				+tmc+"\n"
				+severity+"\n"
				+start_time+"\n"
				+end_time+"\n"
				+start_lat+"\n"
				+start_long+"\n"
				+end_lat+"\n"
				+end_long+"\n"
				+distance+"\n"
				+description+"\n"
				+number+"\n"
				+street+"\n"
				+side+"\n"
				+city+"\n"
				;
	}


	@Override
	public int compareTo(Accidente o) {
		// TODO Auto-generated method stub
		return 0;
	}





}
