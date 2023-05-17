package ca.bcit.comp4656.employee.data;

import java.util.Comparator;

import javax.validation.ConstraintViolation;

public class ConstraintComparator implements Comparator<ConstraintViolation<?>> {

	@Override
	public int compare(ConstraintViolation<?> c1, ConstraintViolation<?> c2) {
		String invalidId = "Invalid ID format";
		if (c1.getMessage().equals(invalidId)) {
			return -1;
		}
		if (c2.getMessage().equals(invalidId)) {
			return 1;
		}
		return c1.getMessage().compareTo(c2.getMessage());
	}

}
