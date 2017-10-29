//Language: C
//Author: Akemy


#include <stdio.h>
#include <stdlib.h>
#include <math.h>


int main (void){
	
	
	double a, b, c, d;
	double p=1.0, q=1.0, r=1.0, x1=1.0, x2=1.0, x3=1.0, u=1.0, v=1.0; 
	double t=1.0, t1=1.0, t2=1.0, disc=1.0, d2=1.0, h=1.0, im=1.0, re=1.0;
	double delta=1.0, modulo=1.0;
	
	printf ("\n******************************************\n");
	printf ("\n  Resolucao da Equacao do Terceiro Grau\n");
	printf ("\n******************************************");
	
	
	printf ("\n\n\nDigite o valor de a: "); scanf ("%lf", &a);
	printf ("\nDigite o valor de b: "); scanf ("%lf", &b);
	printf ("\nDigite o valor de c: "); scanf ("%lf", &c);
	printf ("\nDigite o valor de d: "); scanf ("%lf", &d);
	
		
	//equação do terceiro grau	(a!=0)
	
	if (a!=0){ 
	
	/* caso o d seja igual a zero a equacao devera ser fatorada, 
	uma das raizes sera zero e as outras duas serao descobertas 
	atraves de uma equacao do segundo grau */
	
		if (d==0 && c!=0)
	{
		
		delta=b*b-4*a*c;
	
	if (delta>=0) {

		//três raizes reais		
		x1=(-b+sqrt(delta))/2*a;
		x2=(-b-sqrt(delta))/2*a;
		printf ("\nRaiz 1: %lf", x1);
		printf ("\nRaiz 2: %lf", x2);
		printf ("\nRaiz 3: 0.000000");
			
	}
	else {
		
		//uma raiz real e duas complexas conjugadas
		
		modulo=abs(delta);
		re=(-b/(2*a));
		im=(sqrt(modulo))/(2*a);
		
		printf ("\nRaiz 1: 0.0000000");		
		printf ("\nRaiz complexa 1:   %lf + %lf*i", re, im); 
		printf ("\nRaiz complexa 2:   %lf - %lf*i", re, im); 
	
	}
	}
	
	else if (d==0 && c==0)
	{
		x1=(-b)/a;
		
		printf ("\nRaiz 1: %lf", x1);
		printf ("\nRaiz 2: 0.000000");
		printf ("\nRaiz 3: 0.000000");
	}
	
	
	
	else {
	
	/* O h ira anular o termo de 2 grau, e a equacao sera reescrita 
	da forma t^3 + pt + q = 0, e a solução passa a ser a soma de 
	duas parcelas t= u +v */

	h = (-b)/(3*a);		
	p = (c/a) - ((b*b)/(3*a*a));
	q = ((2*b*b*b)/(27*a*a*a)) - ((b*c)/(3*a*a)) + (d/a);
	
	disc= (q*q) + ((4*p*p*p)/27);
	
	/* caso a discriminante maior que zero a equacao 
	tera uma raiz real e duas imaginarias */
	
	if (disc>0) 
	{
		u = (cbrt((-q+sqrt(disc))/2));
		v = (cbrt((-q-sqrt(disc))/2));
		t1 = u + v;
		x1 = t1 + h;
		printf("\n\nRaiz 1: %lf", x1);
	
		t2 = (-t1/2);
		re = t2 + h;
		im = sqrt (fabs((t1*t1)/4 + (q/t1)));
		printf("\nRaiz complexa 1: %lf + %lf*i", re, im); 
		printf("\nRaiz complexa 2: %lf - %lf*i", re, im);
		
	}
	
	/* caso a discriminante menor ou igual a zero 
	a equacao tera três raizes reais */
	
	else  
	{
		r = sqrt(-p/3);
		t = acos((-q/2)*sqrt(-27/(p*p*p)));

		x1 = (2 * r * cos(t/3)) + h;          
		x2 = 2 * r * cos((t/3)+((2*M_PI)/3)) + h;
		x3 = 2 * r * cos((t/3)+((4*M_PI)/3)) + h;
		
		printf("\n\nRaiz 1: %lf \nRaiz 2: %lf \nRaiz 3: %lf", x1, x2, x3);
		
	}
	
	}
	}
	
	else if

	// equação do segundo grau
		
	 (a==0 && b!=0 && c!=0 && d!=0)
	{
	// atribuicao dos valores
	
		a=b;
		b=c;
		c=d;
		
		delta=b*b-4*a*c;
	
	// se delta maior ou igual a zero a equacao tera duas raizes reais
	
	if (delta>=0) {
		
		x1=(-b+sqrt(delta))/2*a;
		x2=(-b-sqrt(delta))/2*a;
		printf ("\nRaiz 1: %lf", x1);
		printf ("\nRaiz 2: %lf", x2);
			
	}
	
	// se delta menor que zero a equacao tera duas imaginarias
	
	else {
		
		modulo=abs(delta);
		re=(-b/(2*a));
		im=(sqrt(modulo))/(2*a);
				
		printf("\nRaiz complexa 1: %lf + %lf*i", re, im); 
		printf("\nRaiz complexa 2: %lf - %lf*i", re, im); 
	
	}
	}
	
	
	// equação do primeira grau
	
	if (a==0 && b==0 && c!=0)
	{
		// atribuicao dos valores
		
		a=c;
		b=d;
		
		x1= (-b)/a;
		
		printf ("\nRaiz: %lf", x1);
	}
	
	// equação com duas raizes
	
	if (a==0 && d==0 && (c!=0 || b!=0))
	{
		// atribuicao dos valores
		
		a=b;
		b=c;
		
		x1=0;
		x2=(-b)/a;
		
		printf ("\nRaiz 1: %lf", x1);
		printf ("\nRaiz 2: %lf", x2);
		
	}
	
	// equação degenerada
	
	if (a==0 && b==0 && c==0)
	{
		printf("\nOs valores introduzidos nao determinam uma equacao "); 
	}


printf("\n\n\n");
system("pause");
return 0;

}
