package genericDeser.util;

public class ObjectCreation implements ObjectCreationIn{
	public int commandint(String x)
	{
		return new Integer(Integer.parseInt(x));
	}
	public float commandfloat(String x)
	{
		return new Float(Float.parseFloat(x));
	}
	public short commandshort(String x)
	{
		return new Short(Short.parseShort(x));
	}
	public String commandstring(String x)
	{
		return x;
	}
	public double commanddouble(String x)
	{
		return new Double(Double.parseDouble(x));
	}
	public boolean commandboolean(String x)
	{
		return new Boolean(Boolean.parseBoolean(x));
	}
}
