package telran.recursion;

public class LinearRecursionMethods {
	public static int factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n can't be a negative");
		}
		int res = 0;
		if (n == 0) {
			res = 1;
		} else {
			res = n * factorial(n - 1);
		}
		return res;
	}
	
	/*
	 * a - any integer 
	 * b - positive integer	
	 */
	
	public static int pow1(int a, int b) {
		if (b < 0) {
			throw new IllegalArgumentException();
		}
		
		int res = 1;
		
		if (b != 0) {
			res = a * pow1(a, b - 1);
		}
		return res;
	}
	
	/**
	 * 
	 * @param a - any integer number
	 * @param b - positive integer number
	 * @return a ^ b
	 * no cycles
	 * only arithmetic operations +, -
	 * additional functions can be used if any with the same limitation 
	 */
	// Pow V1: 3 Methods
	public static int pow(int a, int b) {
		int res = 0;
		if (b < 0) {
			throw new IllegalArgumentException("pow must be positive number only");
		}
		if (b == 0) {
			res = 1;
		} else if (b == 1) {
			res = a;
		} else {
			int param = a < 0 ? -a : a;
			res = powCalc(param, param, b);
			res = (a < 0) && (b % 2 != 0) ? -res : res;
		}
		
		return res;
	}

	private static int powCalc(int res, int number, int pow) {	
		if (pow > 2) {
			res = powCalc(multBy(res, res, number), number, pow - 1);
		} else {
			res = multBy(res, res, number);
		}
		return res;
	
	}

	private static int multBy(int res, int numToAdd, int counter) {
		if (counter > 1) {
			res = multBy(res + numToAdd, numToAdd, counter - 1);
		}
		return res;
	}

	// Pow V2: 2 Methods
	public static int powV2(int a, int b) {
		int res = 0;
		if (b < 0) {
			throw new IllegalArgumentException("pow must be positive number only");
		}
		if (b == 0) {
			res = 1;
		} else if (b == 1) {
			res = a;
		} else {
			int param = a < 0 ? -a : a;
			res = multByV2(param, param, param, param, b);
			res = a < 0 && b % 2 != 0 ? -res : res;
		}
		
		return res;
	}
	private static int multByV2(int res, int count, int countResetTo, int numToAdd, int pow) {		
		if (count > 1 && pow > 1) {
			 res = multByV2(res + numToAdd, count - 1, countResetTo, numToAdd, pow);			 
		} else if (pow > 2){
			count = countResetTo;
			res = multByV2(res, count, countResetTo, res, pow - 1);
		} 		
		return res;
	}
	
	// Pow V3: 2 Methods
    public static int powV3(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("Exponent must be a non-negative number.");
        }

        int result;
        if (b == 0) {
            result = 1;
        } else if (b == 1) {
            result = a;
        } else {
            result = multByV3(a, powV3(a, b - 1));
        }
        return result;
    }
	
    private static int multByV3(int a, int b) {
        int result;
        if (b == 0) {
            result = 0;
        } else if (b > 0) {
            result = a + multByV3(a, b - 1);
        } else {
            result = -multByV3(a, -b);
        }
        return result;
    }

	public static void displayArray(int[] array) {
		displayArray(0, array, false);
		
	}

	public static void displayArrayReversed(int[] array) {
		displayArray(0, array, true);
		
	}
	
	private static void displayArray(int index, int[] array, boolean isReversed) {
		if (index < array.length) {
			if (isReversed) {
				displayArray(index+ 1, array, true);
				System.out.println(array[index] + " ");
			} else {
				System.out.println(array[index] + " ");
				displayArray(index + 1, array, false);
			}
			
		}		
	}
	
	public static int sum(int[] array) {
		
		return sum(0, array);
	}

	private static int sum(int index, int[] array) {
		int res = 0;
		if (index < array.length) {			
			res = array[index] + sum(index + 1, array);
		}
		
		return res;
	}
	
	public static void reverse(int[] array) {
		reverse(0, array.length - 1, array);
	}

	private static void reverse(int left, int right, int[] array) {
		if (left < right) {
			int tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			reverse(left + 1, right - 1, array);
		}
		
	}
	
	/**
	 * 
	 * @param x - any integer number
	 * @return x ^ 2
	 * allowed arithmetic operations only +, -
	 * no additional functions are allowed
	 * no static fields
	 */
	
    public static int square(int x) {
        int result;
        if (x == 0) {
            result = 0;
        } else {
            if (x < 0) {
                x = -x;
            }
            if (x == 1) {
                result = 1;
            } else {
                result = square(x - 1) + x + (x - 1);
            }
        }
        return result;
    }
	
	/**
	 * 
	 * @param str - string
	 * @param substr - substring
	 * @return true if substr is a substring of str, false otherwise
	 * no cycles
	 * allowed String methods: charAt(int index), substring(int beginIndex), length
	 */
    public static boolean isSubstring(String str, String substr) {
        return isSubstringHelper(str, substr, 0, 0);
    }

    private static boolean isSubstringHelper(String str, String substr, int strIndex, int subIndex) {
        boolean result = false;

        if (subIndex == substr.length()) {
            result = true;
        } else if (strIndex < str.length()) {
            if (str.charAt(strIndex) == substr.charAt(subIndex)) {
                result = isSubstringHelper(str, substr, strIndex + 1, subIndex + 1);
            }
            if (!result) {
                result = isSubstringHelper(str, substr, strIndex + 1, 0);
            }
        }

        return result;
    }
}
