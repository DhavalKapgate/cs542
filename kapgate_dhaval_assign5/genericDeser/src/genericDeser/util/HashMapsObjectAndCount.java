package genericDeser.util;

import java.util.HashMap;
import java.util.Map;

public class HashMapsObjectAndCount implements HashMapsObjectAndCountIn{
	private Map<Integer,Object> listObject;
	private Map<Integer,Integer> objCount;
	public HashMapsObjectAndCount() {
		listObject = new HashMap<Integer,Object>();
		objCount = new HashMap<Integer, Integer>();
	}
	public HashMap<Integer, Object> getListObject() {
		return (HashMap<Integer,Object>)listObject;
	}
	public HashMap<Integer, Integer> getObjCount() {
		return (HashMap<Integer,Integer>)objCount;
	}

	public void setListObject(HashMap<Integer, Object> listObject) {
		this.listObject = listObject;
	}
	public void setObjCount(HashMap<Integer, Integer> objCount) {
		this.objCount = objCount;
	}
	public int uniqueFirstObjects(HashMap<Integer,Object> listObject)
	{
		int count=0;
		for (Object keyValue: listObject.keySet())
		{
            Class<?> cls=listObject.get(keyValue).getClass();
            if(cls.getName().equals("genericDeser.util.First"))
            	count++;
		}
		return count;
	}
	public int uniqueSecondObjects(HashMap<Integer,Object> listObject)
	{
		int count=0;
		for (Object keyValue: listObject.keySet())
		{
            Class<?> cls=listObject.get(keyValue).getClass();
            if(cls.getName().equals("genericDeser.util.Second"))
            	count++;
		}
		return count;
	}
	public int totalFirstObjects(HashMapsObjectAndCountIn hmoac)
	{
		int count=0;
		for (Object keyValue: ((HashMapsObjectAndCount)hmoac).listObject.keySet())
		{
            Class<?> cls=listObject.get(keyValue).getClass();
            if(cls.getName().equals("genericDeser.util.First"))
            {
            	count=count+((HashMapsObjectAndCount)hmoac).objCount.get(keyValue);
            }
		}
		return count;
	}
	public int totalSecondObjects(HashMapsObjectAndCountIn hmoac)
	{
		int count=0;
		for (Object keyValue: ((HashMapsObjectAndCount)hmoac).listObject.keySet())
		{
            Class<?> cls=listObject.get(keyValue).getClass();
            if(cls.getName().equals("genericDeser.util.Second"))
            {
            	count=count+((HashMapsObjectAndCount)hmoac).objCount.get(keyValue);
            }
		}
		return count;
	}
}
