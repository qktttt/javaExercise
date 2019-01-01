#include <iostream>

// ------ Integer ------
// Two's complement
// Its binary means the value
// given a vector of bits [xw-1, xw-2, xw-3, 1, 0]
// the value will be -(xw-1) * (2 ^ (w - 1)) + x * 2 ^ i  (i range from 0 to w - 2)


// One's complement 
// pretty similiar to Two's complement
// but the most significant bit has weight lower that in Two's complement
// by 1. In One's ...., the weight should be -(xw-1) * (2 ^ (w - 1) - 1)
// Its binary means the value
// given a vector of bits [xw-1, xw-2, xw-3, 1, 0]
// the value will be -(xw-1) * (2 ^ (w - 1) - 1) + x * 2 ^ i  (i range from 0 to w - 2)

// in C language, conversion between signed and unsigned number is allowed
// the conversion result seems pretty wired 
// For example, the maximum of Unsigned int will be -1 in signed int
// and vice versa

INTEGER_MAX = 2147483647;
INTEGER_MIN = -2147483648;

 
int main() {

}

unsigned int T2U(int input) {
	// if the signed number is negative, result will be signed_number + 2 ^ 32
	return input < 0 ? powerOf(2, 32) + input : input;
}

int U2T(unsigned int input) {
	return input <= INTEGER_MAX ? input : input - powerOf(2, 32); 
}

int powerOf(int base, int power) {
	if (power == 0) return 1;
	if (power == 1) return base;
	int tmp = powerOf(base, power / 2);
	return power % 2 == 1 ? tmp * tmp * base : tmp * tmp;
}

// 一些unsigned单位的操作可能会导致出乎意料的结果
// 例如 
float sum_elements(float a[], unsigned length) {
	int i;
	float result = 0;
	
	// 在这里，unsigned length变量如果已经是0的话
	// length - 1 将会是 unsigned 的最大值，
	// 大量不属于 数组a的内存会被非法访问
	for (i = 0; i < length - 1; i++) {
		result += a[i];
	}
}

int uadd_ok(unsigned int x, unsigned int y) {
	//如果x + y的值比x本身要小，代表结果溢出了
	// 就是所谓的 overflow
	return (x + y) < x ? 0 : 1;
}

int negation_TwoSigned_number(int a) {
	return ~a + 1;
}

// 在python上测试了一下 另设变量去互换两个变量的值比用位操作快一些


C:\Program Files\mingw-w64\x86_64-8.1.0-posix-seh-rt_v6-rev0




