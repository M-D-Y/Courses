
class NoneGen {

	Object ob;

	NoneGen(Object o){
		ob = o;
	}
	
	Object getObject(){
		return ob;
	}
	
	void showType(){
		System.out.println("Объект ob относится к типу " + ob.getClass().getName());
	}
}
