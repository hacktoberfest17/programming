#ifndef _INDEX_
#define _INDEX_

/* PGSIZE is normally the natural page size of the machine */
#define PGSIZE	512
#define NUMDIMS	2	/* number of dimensions */
#define NDEBUG

typedef float RectReal;


/*-----------------------------------------------------------------------------
| Global definitions.
-----------------------------------------------------------------------------*/

#ifndef TRUE
#define TRUE 1
#endif
#ifndef FALSE
#define FALSE 0
#endif

#define NUMSIDES 2*NUMDIMS

struct Rect
{
	RectReal boundary[NUMSIDES]; /* xmin,ymin,...,xmax,ymax,... */
};

struct Node;

struct Branch
{
	struct Rect rect;
	struct Node *child;
};

/* max branching factor of a node */
#define MAXCARD (int)((PGSIZE-(2*sizeof(int))) / sizeof(struct Branch))

struct Node
{
	int count;
	int level; /* 0 is leaf, others positive */
	struct Branch branch[MAXCARD];
};

struct ListNode
{
	struct ListNode *next;
	struct Node *node;
};

/*
 * If passed to a tree search, this callback function will be called
 * with the ID of each data rect that overlaps the search rect
 * plus whatever user specific pointer was passed to the search.
 * It can terminate the search early by returning 0 in which case
 * the search will return the number of hits found up to that point.
 */
typedef int (*SearchHitCallback)(int id, void* arg);


extern int RTreeSearch(struct Node*, struct Rect*, SearchHitCallback, void*);
extern int RTreeInsertRect(struct Rect*, int, struct Node**, int depth);
extern int RTreeDeleteRect(struct Rect*, int, struct Node**);
extern struct Node * RTreeNewIndex();
extern struct Node * RTreeNewNode();
extern void RTreeInitNode(struct Node*);
extern void RTreeFreeNode(struct Node *);
extern void RTreePrintNode(struct Node *, int);
extern void RTreeTabIn(int);
extern struct Rect RTreeNodeCover(struct Node *);
extern void RTreeInitRect(struct Rect*);
extern struct Rect RTreeNullRect();
extern RectReal RTreeRectArea(struct Rect*);
extern RectReal RTreeRectSphericalVolume(struct Rect *R);
extern RectReal RTreeRectVolume(struct Rect *R);
extern struct Rect RTreeCombineRect(struct Rect*, struct Rect*);
extern int RTreeOverlap(struct Rect*, struct Rect*);
extern void RTreePrintRect(struct Rect*, int);
extern int RTreeAddBranch(struct Branch *, struct Node *, struct Node **);
extern int RTreePickBranch(struct Rect *, struct Node *);
extern void RTreeDisconnectBranch(struct Node *, int);
extern void RTreeSplitNode(struct Node*, struct Branch*, struct Node**);

extern int RTreeSetNodeMax(int);
extern int RTreeSetLeafMax(int);
extern int RTreeGetNodeMax();
extern int RTreeGetLeafMax();

#endif /* _INDEX_ */
