package JavaCompiler;

public class Variables extends Main {
	String name;
	Float value;
	Variables(String s)
	{
		name=s;
		value=(Float)null;
	}
	
	public void insertFloat(float f)
	{
		value=f;
	}
}
