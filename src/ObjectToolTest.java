import org.apache.commons.pool.BasePoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool.Config;




class BigArrayFactory extends BasePoolableObjectFactory{

	private static final int _1M=1024;
	@Override
	public Object makeObject() throws Exception {
		// TODO Auto-generated method stub
		byte[] array=new byte[_1M];
		return array;
	}
	@Override
	public void destroyObject(Object obj){
		if(obj instanceof int[]){
			obj=null;
		}
	}
	
}

public class ObjectToolTest {
	private static GenericObjectPool pool=new GenericObjectPool(new BigArrayFactory(),new Config());
	public static void main(String[] args) throws Exception{
		byte[] arrayNew=(byte[])pool.borrowObject();
		//do something
		
		pool.returnObject(arrayNew);
		
		byte[] arrayOld=(byte[])pool.borrowObject();
		
		System.out.println(arrayOld==arrayNew);
		
		pool.returnObject(arrayOld);
	}
}
