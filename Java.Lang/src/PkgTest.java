//Продемонстрировать применение класса Packaqe
class PkgTest {
	public static void main(String args[]) {
		Package pkgs[];
		pkgs = Package.getPackages();
		Package p = Class.class.getClass().getPackage();
		System.out.println(p.getSpecificationTitle ( ) + " " + p.getSpecificationVendor ( ) + " " + p.getSpecificationVersion ( ));
		for (int i = 0; i < pkgs.length; i++) {

/*			System.out.println(
					pkgs[i].getName() + " - " + pkgs[i].getImplementationTitle() + " v. " + pkgs[i].getImplementationVendor()
							+ "" + pkgs[i].getImplementationVersion());*/
		}
	}
}