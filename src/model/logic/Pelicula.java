package model.logic;


public  class Pelicula {

	private String id;
	private String genres;
	private String imbd ;
	private String originalLang;
	private String originalTitle;
	private String overview;
	private String popularity;
	private String proCompanies;
	private String proCountries;
	private String releaseDate;
	private String revenue;
	private String runtime;
	private String spokenLanguages;
	private String status;
	private String tagline;
	private String title;
	private String voteAverage;
	private String voteCount;
	private String proCompaniesNumber;
	private String proCompaniesCountryNumber;
	private String spokenLanguagesNumber;
	 
	public Pelicula (String pId, String pGenres, String pImbd, String pOriginalLang, String pOriginalTitle, String pOverview, String pPopularity, String pProCompanies, String pProCountries, String pReleaseDate, String pRevenue, String pRuntime, String pSpokenLanguages, String pStatus, String pTagline, String pTitle, String pVoteAverage, String pVoteCount,String pProCompaniesNumber, String pProCompaniesCountryNumber, String pSpokenLanguagesNumber )
	{
		id= pId;
		genres= pGenres;
		imbd= pImbd;
		originalLang= pOriginalLang;
		originalTitle= pOriginalTitle;
		overview = pOverview;
		popularity = pPopularity;
		proCompanies = pProCompanies;
		proCountries =pProCountries;
		releaseDate = pReleaseDate;
		revenue = pRevenue;
		runtime = pRuntime;
		spokenLanguages = pSpokenLanguages;
		status = pStatus;
		tagline = pTagline;
		title = pTitle;
		voteAverage = pVoteAverage;
		voteCount = pVoteCount;
	    proCompaniesNumber = pProCompaniesNumber;
		 proCompaniesCountryNumber = pProCompaniesCountryNumber;
		spokenLanguagesNumber = pSpokenLanguagesNumber;
	}
	
	public String darId()
	{
		return id;
	}
	public String genres()
	{
		return genres;
	}
	public String darImbd()
	{
		return imbd;
	}
	public String darOriginalLang()
	{
		return originalLang;
	}
	public String darOriginalTitle()
	{
		return originalTitle;
	}
	public String darOverview()
	{
		return overview;
	}
	public String darPopularity()
	{
		return popularity;
	}
	public String darProCompanies()
	{
		return proCompanies;
	}
	public String darProCountries()
	{
		return proCountries;
	}
	public String darReleaseDate()
	{
		return releaseDate;
	}
	
	public String darRevenue()
	{
		return revenue;
	}
	public String darRuntime()
	{
		return runtime;
	}
	public String darSpokenLanguages()
	{
		return spokenLanguages;
	}
	public String darStatus()
	{
		return status;
	}
	public String darTagline()
	{
		return tagline;
	}
	public String darTitle()
	{
		return title;
	}
	public String darVoteAverage()
	{
		return voteAverage;
	}
	public String darVoteCount()
	{
		return voteCount;
	}
	public String darProCompaniesNumber()
	{
		return proCompaniesNumber;
	}
	public String darProCompaniesCountryNumber()
	{
		return proCompaniesCountryNumber;
	}
	public String darSpokenLanguagesNumber()
	{
		return spokenLanguagesNumber;
	}

}
