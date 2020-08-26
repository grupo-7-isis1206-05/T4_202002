package model.logic;

import model.data_structures.IArregloDinamico;

public class Elenco 
{

	private String id;
	private String actor1;
	private String gender1 ;
	private String actor2;
	private String gender2;
	private String actor3;
	private String gender3;
	private String actor4;
	private String gender4;
	private String actor5;
	private String gender5;
	private String actorNumber;
	private String directorName;
	private String directorGender;
	private String directorNumber;
	private String producerName;
	private String producerNumber;
	private String screenName;
	private String editorName;
	
	public Elenco (String pId, String pActor1, String pGender1, String pActor2, String pGender2, String pActor3, String pGender3, String pActor4, String pGender4, String pActor5, String pGender5, String pActorNumber, String pDirectorName, String pDirectorGender, String pDirectorNumber, String pProducerName, String pProducerNumber, String pScreenName,String pEditorName )
	{
		id= pId;
		actor1= pActor1;
		gender1= pGender1;
		actor2= pActor2;
		gender2 = pGender2;
		actor3 = pActor3;
		gender3 = pGender3;
		actor4 = pActor4;
		gender4 = pGender4;
		actor5 = pActor5;
		gender5 = pGender5;
		actorNumber = pActorNumber;
		directorName = pDirectorName;
		directorGender = pDirectorGender;
		directorNumber = pDirectorNumber;
		producerName = pProducerName;
		producerNumber = pProducerNumber;
		screenName = pScreenName;
		editorName = pEditorName;
	}
	
	public String darId()
	{
		return id;
	}
	public String darActor1()
	{
		return actor1;
	}
	public String darGender1()
	{
		return gender1;
	}
	public String darActor2()
	{
		return actor2;
	}
	public String darGender2()
	{
		return gender2;
	}
	public String darActor3()
	{
		return actor3;
	}
	public String darGender3()
	{
		return gender3;
	}
	public String darActor4()
	{
		return actor4;
	}
	public String darGender4()
	{
		return gender4;
	}
	public String darActor5()
	{
		return actor5;
	}
	
	public String darGender5()
	{
		return gender5;
	}
	public String darActorNumber()
	{
		return actorNumber;
	}
	public String darDirectorName()
	{
		return directorName;
	}
	public String darDirectorGender()
	{
		return directorGender;
	}
	public String darDirectorNumber()
	{
		return directorNumber;
	}
	public String darProducerName()
	{
		return producerName;
	}
	public String darProducerNumber()
	{
		return producerNumber;
	}
	public String darScreenName()
	{
		return screenName;
	}
	public String darEditorName()
	{
		return editorName;
	}
}
