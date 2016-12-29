package genericDeser.util;

import java.util.HashMap;

public interface HashMapsObjectAndCountIn {
	public HashMap<Integer, Object> getListObject();
	public HashMap<Integer, Integer> getObjCount();
	public void setListObject(HashMap<Integer, Object> listObject);
	public void setObjCount(HashMap<Integer, Integer> objCount);
	
	public int uniqueFirstObjects(HashMap<Integer,Object> listObject);
	public int uniqueSecondObjects(HashMap<Integer,Object> listObject);
	public int totalFirstObjects(HashMapsObjectAndCountIn hmoac);
	public int totalSecondObjects(HashMapsObjectAndCountIn hmoac);
}
