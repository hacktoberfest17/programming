	#include "avl.h"

/* Cria um novo no com chave k */
No *NovoNo(int k) {
	No *p = malloc(sizeof(No));
	p->esq = p->dir = NULL;
	p->chave = k;
	p->bal = 0;
	return p;
}

/* Libera todos os nos arvore AVL */
void LiberaArvore(Arvore r) {
	if (r != NULL) {
		No *esq = r->esq;
		No *dir = r->dir;
		free(r);
		LiberaArvore(esq);
		LiberaArvore(dir);
	}
	return;
}

/* Funcaos auxiliar para imprimir uma arvore AVL */
void ImprimeChave(int k, int b) {
	int i;
	for (i=0; i<b-1; i++)
		printf("|\t");
	if (b > 0) printf("|-------%d\n",k);
	else printf("%d\n",k);
	return;
}

/* Imprime a arvore */
void ImprimeArvore(Arvore r, int b) {
	if (r == NULL)
		return;
	ImprimeArvore(r->dir, b+1);
	ImprimeChave(r->chave, b);
	ImprimeArvore(r->esq, b+1);
	return;
}

/* Retorna a altura da arvore */
int Altura(Arvore r) {
   if (r == NULL) 
      return -1; // altura da árvore vazia
   else {
      int he = altura (r->esq);
      int hd = altura (r->dir);
      if (he < hd) return hd + 1;
      else return he + 1;
   }
}

/* Rotacao a direita */
void RD(Arvore *r) {
	No *p = *r;
	No *q = p->esq;
	p->esq = q->dir;
	q->dir = p;
	*r = q;
	return;
}

/* Rotacao a esquerda */
void RE(Arvore *r) {
No *p = *r;
No*q = p->dir;
p->dir = q->esq;
q->esq = p;
*r = q;
}



/* Rotacao Dupla EsqDir */
void RED(Arvore *r) {
	No *p = *r;
	No *q = p->esq;
	No *t = q->dir;
	p->esq = t->dir;
	q->dir = t->esq;
	t->esq = q;
	t->dir = p;
	*r = t;
	return;
}

/* Rotacao Dupla DirEsq */
void RDE(Arvore *r) {
No *p = *r,
No *q = p->dir; 
No *t = q->esq;
p->dir = t->esq;
q->esq = t->dir;
t->esq = p;
t->dir = q;
*r = t;
return;
}



/* Funcao auxiliar de insercao */
int InsereAux(Arvore *r, int k, int *cresceu) {
	if (*r == NULL) {
		*r = NovoNo(k);
		*cresceu = 1;
		return 1;
	}
	if ((*r)->chave == k)
		return 0;
	if (k < (*r)->chave) {
		if (InsereAux(&(*r)->esq, k, cresceu)) {  // Inserir a esquerda
			if (*cresceu) {
				switch ((*r)->bal) {
					case +1:
						(*r)->bal = 0;
						*cresceu = 0;
					break;
					case 0:
						(*r)->bal = -1;
					break;
					case -1:
						if ((*r)->esq->bal == -1) {
							RD(r);
							(*r)->dir->bal = 0;
						}
						else { 
							RED(r);
							No *e = (*r)->esq, *d = (*r)->dir;
							switch ((*r)->bal) {
								case +1:
									e->bal = -1;
									d->bal = 0;
								break;
								case 0:
									e->bal = 0;
									d->bal = 0;
								break;
								case -1:
									e->bal = 0;
									d->bal = 1;
								break;
							}
						}
						(*r)->bal = 0;
						*cresceu = 0;
					break;
				}
			}
			return 1;
		}
		else 
			return 0;
	}
	if (k > (*r)->chave) { // Inserir a direita
		if (InsereAux(&(*r)->dir, k, cresceu)) {  
			if (*cresceu) {
				switch ((*r)->bal) {
					case +1:
						(*r)->bal = 0;
						*cresceu = 0;
					break;
					case 0:
						(*r)->bal = -1;
					break;
					case -1:
						if ((*r)->dir->bal == -1) {
							RE(r);
							(*r)->esq->bal = 0;
						}
						else { 
							RDE(r);
							No *e = (*r)->dir, *d = (*r)->esq;
							switch ((*r)->bal) {
								case +1:
									e->bal = -1;
									d->bal = 0;
								break;
								case 0:
									e->bal = 0;
									d->bal = 0;
								break;
								case -1:
									e->bal = 0;
									d->bal = 1;
								break;
							}
						}
						(*r)->bal = 0;
						*cresceu = 0;
					break;
				}
			}
			return 1;
		}
		else 
			return 0;
	}
}

/* Insere um noh em uma arvore */
int InsereArvore(Arvore *r, int k) {
	int cresceu;
	return InsereAux(r, k, &cresceu);
}
