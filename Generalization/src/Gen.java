// T обозначает параметр типа, который будет заменен реальным
class Gen<T> {

	T ob;
	
	Gen(T o){
		ob = o;
	}
	
	T getob(){
		return ob;
	}
	
	void showType () {
		System.out.println("Типом Т является " + ob.getClass().getName());
	}
}
