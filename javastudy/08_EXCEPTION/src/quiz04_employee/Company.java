package quiz04_employee;

	public class Company {

		private Employee[] employees;
		private int idx;
		private Scanner sc;
		
		public Company() {
			employees = new Employee[5];
			sc = new Scanner(System.in);
		}
		
		public void addEmployee() throws EmployeeException {
			
		}
		
		public void dropEmployee() throws EmployeeException {
			
		}
		
		public void findEmployee() throws EmployeeException {
			
		}
		
		public void printAllEmployees() throws EmployeeException {
			
		}
		
		public void manage() {
			while(true) {
				try {
					System.out.println("1.추가 2.삭제 3.조회 4.목록 0.종료 >>> ");
					int choice = sc.nextInt();
					switch(choice) {
					case 1: addEmployee(); break;
					case 2: dropEmployee(); break;
					case 3: findEmployee(); break;
					case 4: printAllEmployees(); break;
					case 0: return;
					default: throw new RuntimeException("알 수 없는 명령");
					}
				} catch(InputMismatchException e) {
					sc.next();
					System.out.println("명령은 정수로 입력");
				} catch(RuntimeException e) {
					System.out.println(e.getMessage());
				} catch(EmployeeException e) {
					System.out.println(e.getMessage() + "," + e.getErrorCode());
				}
			}
		}
		{
		
	
	

