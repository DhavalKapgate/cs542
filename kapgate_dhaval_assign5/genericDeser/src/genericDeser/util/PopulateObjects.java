package genericDeser.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import genericDeser.fileOperations.FileProcessor;

public class PopulateObjects implements PopulateObjectsIn{
	private String inputFile;
	private FileProcessor fp=null;
	
	private Map<Integer,Object> listObject;
	private Map<Integer,Integer> objCount;
	private Map<String, Class<?>> signaturetype;
	public PopulateObjects(){}
	public PopulateObjects(String inputFileIn) {
		inputFile = inputFileIn;
		fp=new FileProcessor(inputFile);
		
		signaturetype=new HashMap<String,Class<?>>();
		signaturetype.put("int", Integer.TYPE);
		signaturetype.put("float", Float.TYPE);
		signaturetype.put("short", Short.TYPE);
		signaturetype.put("string", String.class);
		signaturetype.put("double", Double.TYPE);
		signaturetype.put("boolean", Boolean.TYPE);
	}
	public HashMapsObjectAndCount deserObjects(HashMapsObjectAndCountIn hmoac)
	{
		String line;
		try
		{
			
			listObject=hmoac.getListObject();
			objCount=hmoac.getObjCount();
			String clsName;
			Class<?> cls=null;
			Class<?>[] signature;
			Object obj=null;
			while(true)
			{
				line=fp.read();
				if(line==null)
				{
					if(obj!=null)
					{
						int hashcode=obj.hashCode();
						//if the bucket is not filled
						if(!listObject.containsKey(hashcode))
						{
							listObject.put(hashcode, obj);
							objCount.put(hashcode, 1);
						}
						//if bucket filled
						else
						{	
							Object obj_existing=listObject.get(hashcode);
							if(obj.equals(obj_existing))
							{
								//if same object
								objCount.put(hashcode, objCount.get(hashcode)+1);
							}
							//collision
							else//different objs then prob 
							{
								//probe
								boolean found=false;
								
								hashcode++;
								while(listObject.containsKey(hashcode))
								{
									obj_existing=listObject.get(hashcode);
									if(obj_existing.equals(obj))
									{
										objCount.put(hashcode, objCount.get(hashcode)+1);
										found=true;
										break;
									}
									//linear probing
									hashcode++;
								}
								if(!found)
								{
									listObject.put(hashcode, obj);
									objCount.put(hashcode, 1);
								}
							}
						}
					}
					hmoac.setListObject((HashMap<Integer,Object>)listObject);
					hmoac.setObjCount((HashMap<Integer,Integer>)objCount);
					
					return ((HashMapsObjectAndCount)hmoac);
				}
				if(line.contains("genericDeser.util"))
				{
					if(obj!=null)
					{
						int hashcode=obj.hashCode();
						//if the bucket is not filled
						if(!listObject.containsKey(hashcode))
						{
							listObject.put(hashcode, obj);
							objCount.put(hashcode, 1);
						}
						//if bucket filled
						else
						{	
							Object obj_existing=listObject.get(hashcode);
							if(obj.equals(obj_existing))
							{
								//if same object
								objCount.put(hashcode, objCount.get(hashcode)+1);
							}
							//collision
							else//different objs then prob 
							{
								//probe
								boolean found=false;
								
								hashcode++;
								while(listObject.containsKey(hashcode))
								{
									obj_existing=listObject.get(hashcode);
									if(obj_existing.equals(obj))
									{
										objCount.put(hashcode, objCount.get(hashcode)+1);
										found=true;
										break;
									}
									//linear probing
									hashcode++;
								}
								if(!found)
								{
									listObject.put(hashcode, obj);
									objCount.put(hashcode, 1);
								}
							}
						}
					}
					String sub[]=line.split(":");
					clsName = sub[1];
					cls = Class.forName(clsName);
					obj = cls.newInstance();
				}
				else
				{
					String sub[]=line.split(",");
				    signature = new Class[1];  
				    String sub1[]=sub[0].split("=");
				    sub1[1]=sub1[1].toLowerCase();
				    signature[0] =signaturetype.get(sub1[1]);			// generalize
				    
				    String sub2[]=sub[1].split("=");
				    String methodName1 = "set" + sub2[1].toLowerCase(); 	        // generalize
				    Method meth = cls.getMethod(methodName1, signature); 
				     
				    Object[] params = new Object[1];
				    
				    String methodName2 = "command" + sub1[1].toLowerCase(); 	        // generalize
				    String sub3[]=sub[2].split("=");
				    Class<?>[] signature1=new Class[1];
				    signature1[0]=String.class;
				    Method meth2 = Class.forName("genericDeser.util.ObjectCreation").getMethod(methodName2,signature1); 
					params[0]=meth2.invoke(Class.forName("genericDeser.util.ObjectCreation").newInstance(), sub3[1]);
					
					meth.invoke(obj, params); 		
				}
			}
		}
		catch(ClassNotFoundException e)
		{
			System.err.println("ClassNotFoundException");
			System.exit(0);
		}
		catch(NoSuchMethodException e)
		{
			System.err.println("NoSuchMethodException");
			System.exit(0);
		}
		catch(SecurityException e)
		{
			System.err.println("SecurityException");
			System.exit(0);
		}
		catch(InstantiationException e)
		{
			System.err.println("InstantiationException");
			System.exit(0);
		}
		catch(IllegalAccessException e)
		{
			System.err.println("IllegalAccessException");
			System.exit(0);
		}
		catch(IllegalArgumentException e)
		{
			System.err.println("IllegalArgumentException");
			System.exit(0);
		}
		catch(InvocationTargetException e)
		{
			System.err.println("InvocationTargetException");
			System.exit(0);
		}
		catch(Exception e)
		{
			System.err.println("Error");
			System.exit(0);
		}
		return (HashMapsObjectAndCount)hmoac;
	}
	public void showListObj()
	{int i=1;
		for (Object keyValue: listObject.keySet())
		{
            String key =keyValue.toString();
            String value = listObject.get(keyValue).toString(); 
            
            System.out.println(i+")KEY:"+key+"\tVALUE: "+value);
            i++;
		}
	}
	public void showObjCount()
	{
		int i=1;
		for (Object keyValue: objCount.keySet())
		{
            String key =keyValue.toString();
            String value = objCount.get(keyValue).toString();  
            System.out.println(i+")KEY:"+key+"\tCOUNT: "+value); 
            i++;
		}
	}
}
