package com.excercise.model;
import com.excercise.three.Billable;
public class Software implements Billable {
		private String roleType;
		private int employeeId;
		private String employeeName;
		public Software(String roleType, int employeeId, String employeeName) {
			super();
			this.roleType = roleType;
			this.employeeId = employeeId;
			this.employeeName = employeeName;
		}
		@Override
		public double calculateSalary() {
			// TODO Auto-generated method stub
			double salary=0;
			if(this.roleType.equals("Developer")) {
				salary=50000;
			}else if(this.roleType.equals("Manager")){
				salary=80000;
			}else {
				salary=0;
			}
			return salary;
		}
		
		
}
