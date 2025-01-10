package application;

public enum reactions {
	NON(0,"Like","C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\imgNoLike.png"),
	LIKE(1,"Like","C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\imgLike.png"),
	LOVE(2,"Love","C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\imgLove.png"),
	CARE(3,"Care","C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\imgCare.png"),
	HAHA(4,"Haha","C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\imgHaha.png"),
	WOW(5,"Wow","C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\imgWow.png"),
	SAD(6,"Sad","C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\imgSad.png");
	
	public int id;
	public String name;
	public String imgSrc;
	
	reactions(int id, String name, String imgSrc)
	{
		this.id = id;
		this.name = name;
		this.imgSrc = imgSrc;
				
	}
	
	void setReaction()
	{
		
	}
	
}
