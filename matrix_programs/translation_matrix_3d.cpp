// 3D matrix operations - Is the matrix classified as translation matrix
//

#include <string>
#include <iostream>
using namespace std;

class Matrix3D;

class Point3D {
	private:
	public:
		double x;
		double y;
		double z;
		double w;
		Point3D() {
			x = 0;
			y = 0;
			z = 0;
			w = 1;
		}
		Point3D(double a, double b, double c) {
			x = a;
			y = b;
			z = c;
			w = 1.;
		}
		Point3D(double a, double b, double c, double d) {
			x = a;
			y = b;
			z = c;
			w = d;
		}
		~Point3D() {
		}
		void Print();
};

class Matrix3D {
	private:
	public:
		double m[4][4];
		Matrix3D ();
		Matrix3D(Point3D point);
		~Matrix3D() {
		}
		bool IsTranslationMatrix() const;
		void Print();
};

// debug/helper function

void Point3D::Print()
{
	printf("(x, y, z, w) = (%f, %f, %f, %f)\n", x, y, z, w);
}

// Initialize to empty matrix
//
//	| 0 0 0 0 |
//	| 0 0 0 0 |
//	| 0 0 0 0 |
//	| 0 0 0 1 |
Matrix3D::Matrix3D()
{
	for (int i=0; i<4; i++) {
		for (int j=0; j<4; j++) {
			m[i][j] = 0.;
		}
	}
	m[0][0] = 1.;
	m[1][1] = 1.;
	m[2][2] = 1.;	
	m[3][3] = 1.;
}

//	| 0 0 0 0 |
//	| 0 0 0 0 |
//	| 0 0 0 0 |
//	| x y z 1 |
Matrix3D::Matrix3D(Point3D p)
{
	for (int i=0; i<3; i++) {
		for (int j=0; j<4; j++) {
			m[i][j] = 0.;
		}
	}
	m[0][0] = 1.;
	m[1][1] = 1.;
	m[2][2] = 1.;	
	m[3][0] = p.x;
	m[3][1] = p.y;
	m[3][2] = p.z;
	m[3][3] = 1.;
}

bool Matrix3D::IsTranslationMatrix() const
{
	for (int i=0; i<3; i++) {
		for (int j=0; j<4; j++) {
			if (i==j) {
				if (m[i][j] != 1.) {
					return false;
				}
				else
					continue;
			}
			else if (m[i][j] != 0.) {
				return false;
			}
		}
	}
	if (m[3][3] != 1.) return false;
	return true;
}

// debug/helper function
void Matrix3D::Print()
{
	for (int i=0; i<4; i++) {
		for (int j=0; j<4; j++) {
			printf("%f ", m[i][j]);
		}
		printf("\n");
	}
}


int main()
{
	Point3D point(2.,3.,4.);
	Point3D result;
	double delta_x = 10.;	// Move by
	double delta_y = 20.;
	double delta_z = 30.;
	Matrix3D m(point);

	m.Print();
	cout << (m.IsTranslationMatrix() ? "Yes - Translation Matrix" : "No");
	cout << "\n";

	// dirty it
	m.m[1][0] = 3.;
	m.Print();
	cout << (m.IsTranslationMatrix() ? "Yes - Translation Matrix" : "No");
	cout << "\n";

	return 0;
}
