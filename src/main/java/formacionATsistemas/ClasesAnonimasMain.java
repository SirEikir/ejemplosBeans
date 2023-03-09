package formacionATsistemas;

public class ClasesAnonimasMain {

	public static void main(String[] args) {
//		BusinessService serviceNamedClass = new BusinessServiceImpl();
		BusinessService serviceNamedClass = new BusinessService() {
			
			@Override
			public Integer doSomething() {
				return 45;
			}
			
			@Override
			public boolean check() {
				return true;
			}
		};
		
		boolean check = serviceNamedClass.check();
		Integer result = serviceNamedClass.doSomething();

		System.out.println("Check: " + check + "; Result: " + result);
	}

}
